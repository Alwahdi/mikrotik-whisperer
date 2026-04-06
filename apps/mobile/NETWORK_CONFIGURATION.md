# Mobile App Network Configuration Guide

This guide explains how the MikroTik Whisperer mobile app handles both local and public IP connections.

## Overview

The mobile app is designed to work seamlessly in both local network and remote access scenarios. The app automatically detects whether you're connecting to a router via:
- **Local IP address** (same network)
- **Public IP address or domain** (remote access)

## Architecture

### Connection Flow

```
Mobile App → Supabase Edge Functions → MikroTik Router
```

All MikroTik API calls go through Supabase Edge Functions, which means:
- ✅ No direct connection from mobile device to MikroTik
- ✅ Works behind NAT/firewalls
- ✅ Centralized authentication and security
- ✅ Same API for local and remote access

### Router Configuration Storage

Router configurations are stored in two places:

1. **Supabase Database** (server-side):
   - Router credentials (encrypted)
   - Router metadata (label, host, port, protocol)
   - User-router associations

2. **Device Local Storage** (client-side):
   - Active router selection
   - Router connection preferences
   - No sensitive credentials stored locally

## Local IP Support

### What is a Local IP?

Local IP addresses are private IP addresses used within a local network:
- `192.168.x.x` (most common home networks)
- `10.x.x.x` (enterprise networks)
- `172.16.x.x` to `172.31.x.x` (medium-sized networks)
- `127.0.0.1` (localhost)

### How It Works

When you add a router with a local IP:

1. **Detection**: App automatically detects local IP pattern
2. **Same Network Required**: Device must be on the same WiFi/network
3. **Fast Connection**: Direct local network communication
4. **No Port Forwarding**: No need to expose router to internet

### Configuration Steps

1. **Connect to the same WiFi network** as your MikroTik router
2. **Find your router's local IP**:
   - Check router label/manual
   - Use network scanner apps
   - Common default: `192.168.88.1`

3. **Add router in the app**:
   ```
   Label: Office Router
   Host: 192.168.88.1
   Port: 8728 (API) or 80 (HTTP)
   Username: admin
   Password: your-password
   ```

4. **App behavior with local IPs**:
   - Longer timeout values (45-70 seconds)
   - Optimized for local network speed
   - Shows "Local Network" badge in router list

### Limitations

- ❌ Only works when connected to same network
- ❌ Won't work over mobile data or other WiFi
- ❌ Cannot manage router when away from location

### Use Cases

- **Perfect for**:
  - Office management while on-site
  - Home network administration
  - Multiple locations with dedicated admins
  - Testing and development

## Public IP Support

### What is a Public IP?

Public IP addresses are routable on the internet:
- Assigned by your ISP
- Can be static (fixed) or dynamic (changes)
- Can also be a domain name (e.g., `router.example.com`)

### How It Works

When you add a router with a public IP:

1. **Detection**: App recognizes non-local IP pattern
2. **Internet Access**: Works from anywhere with internet
3. **Port Forwarding Required**: Router must be accessible from internet
4. **Security Critical**: Proper security measures essential

### Configuration Steps

#### 1. Get Public IP or Domain

**Option A: Static Public IP**
- Contact your ISP for static IP
- More reliable but usually costs extra

**Option B: Dynamic DNS (DDNS)**
- Sign up for DDNS service (e.g., DuckDNS, No-IP)
- Configure DDNS in your router
- Use domain name instead of IP

#### 2. Configure Port Forwarding

On your **network router** (not MikroTik):

1. Login to router admin panel
2. Find "Port Forwarding" or "Virtual Server" section
3. Add rule:
   ```
   Service Name: MikroTik API
   External Port: 8728 (or custom)
   Internal IP: 192.168.88.1 (your MikroTik's local IP)
   Internal Port: 8728
   Protocol: TCP
   ```

#### 3. Secure Your MikroTik

**Critical security steps**:

1. **Change default password**:
   ```
   /user set admin password=strong-unique-password
   ```

2. **Enable firewall**:
   ```
   /ip firewall filter add chain=input protocol=tcp dst-port=8728 action=accept src-address-list=allowed_ips
   /ip firewall filter add chain=input action=drop
   ```

3. **Use API-SSL instead of API**:
   ```
   /ip service set api disabled=yes
   /ip service set api-ssl disabled=no port=8729
   ```

4. **Limit access by IP** (if possible):
   ```
   /ip firewall address-list add list=allowed_ips address=your.vpn.ip.address
   ```

5. **Enable certificate for SSL**:
   ```
   /certificate add name=mobile-api common-name=router.example.com
   /ip service set api-ssl certificate=mobile-api
   ```

#### 4. Add Router in App

```
Label: Remote Office Router
Host: 203.0.113.100 (or router.example.com)
Port: 8729 (API-SSL) or 443 (HTTPS)
Username: admin
Password: your-strong-password
```

### App Behavior with Public IPs

- Shorter timeout values (15-30 seconds)
- Shows "Public/Remote" badge in router list
- Additional security warnings
- Optimized for internet latency

### Security Best Practices

1. **Never use default passwords**
2. **Always use SSL/TLS** (API-SSL or HTTPS)
3. **Enable firewall rules**
4. **Use VPN when possible** (most secure)
5. **Monitor access logs**:
   ```
   /log print where topics~"api"
   ```
6. **Keep RouterOS updated**
7. **Disable unnecessary services**
8. **Use strong authentication**

### VPN Alternative (Recommended)

Instead of exposing MikroTik to internet, use VPN:

1. **Setup VPN on MikroTik**:
   - WireGuard (recommended)
   - L2TP/IPSec
   - PPTP (not recommended)

2. **Connect mobile device to VPN**

3. **Use local IP in app** (now accessible through VPN)

Benefits:
- ✅ More secure
- ✅ No port forwarding needed
- ✅ Encrypted connection
- ✅ Access to entire network

## Comparison Table

| Feature | Local IP | Public IP | VPN |
|---------|----------|-----------|-----|
| **Same Network Required** | ✅ Yes | ❌ No | ❌ No |
| **Remote Access** | ❌ No | ✅ Yes | ✅ Yes |
| **Port Forwarding** | ❌ Not needed | ✅ Required | ❌ Not needed |
| **Security Risk** | 🟢 Low | 🔴 High | 🟢 Low |
| **Speed** | 🟢 Fast | 🟡 Medium | 🟡 Medium |
| **Setup Complexity** | 🟢 Easy | 🔴 Complex | 🟡 Medium |
| **Recommended For** | On-site only | Multiple locations | Best balance |

## Troubleshooting

### Cannot Connect - Local IP

1. **Verify same network**:
   - Check WiFi name on phone and computer
   - Ping router: `ping 192.168.88.1`

2. **Check MikroTik API**:
   ```
   /ip service print
   # Ensure 'api' is enabled
   ```

3. **Check firewall**:
   ```
   /ip firewall filter print
   # Ensure input chain allows API port
   ```

4. **Verify credentials**:
   - Try logging in via Winbox/WebFig
   - Reset password if needed

### Cannot Connect - Public IP

1. **Verify public IP**:
   - Visit https://whatismyipaddress.com
   - Confirm it matches configured IP

2. **Test port forwarding**:
   - Use online port checker
   - Try telnet: `telnet your-public-ip 8728`

3. **Check ISP restrictions**:
   - Some ISPs block incoming connections
   - Contact ISP to open ports
   - Consider using VPN

4. **Verify DDNS** (if using domain):
   - Confirm domain resolves correctly
   - Check DDNS update status

5. **Check router firewall**:
   - Temporarily disable to test
   - Add explicit allow rule

### App Shows "Connection Timeout"

1. **For local IPs**:
   - Increase timeout in settings
   - Check WiFi signal strength
   - Restart router

2. **For public IPs**:
   - Verify internet connection
   - Check if router is online
   - Verify port forwarding
   - Test from external network checker

## Network Diagram

### Local Network Access
```
┌─────────────┐
│ Mobile App  │
│  (WiFi)     │
└──────┬──────┘
       │ Same Network (192.168.88.0/24)
       ↓
┌──────────────┐
│  MikroTik    │
│  Router      │
│ 192.168.88.1 │
└──────────────┘
```

### Public IP Access
```
┌─────────────┐
│ Mobile App  │
│ (Mobile/    │
│  Any WiFi)  │
└──────┬──────┘
       │ Internet
       ↓
┌──────────────┐     Port Forward     ┌──────────────┐
│ Home/Office  │──────────────────────→│  MikroTik    │
│   Router     │     8728 → 8728      │   Router     │
│ Public IP    │                      │ 192.168.88.1 │
└──────────────┘                      └──────────────┘
```

### VPN Access (Recommended)
```
┌─────────────┐
│ Mobile App  │
│ (Mobile/    │
│  Any WiFi)  │
└──────┬──────┘
       │ VPN Tunnel (Encrypted)
       ↓
┌──────────────┐
│  MikroTik    │
│  Router      │
│ VPN Server   │
│ 10.0.0.1     │
└──────────────┘
       │ Access Local Network
       ↓
   Internal Resources
```

## Best Practices Summary

### For Local Network Usage
- ✅ Use local IP (192.168.x.x)
- ✅ Enable API on MikroTik
- ✅ Use strong password
- ✅ Keep router updated

### For Remote Access
- ✅ **Preferred**: Setup VPN
- ⚠️ **Alternative**: Use public IP with:
  - Strong unique password
  - API-SSL (port 8729)
  - Firewall rules
  - IP whitelisting
  - Regular security audits

### General Security
- ✅ Enable two-factor authentication (if supported)
- ✅ Regular password rotation
- ✅ Monitor access logs
- ✅ Use Supabase RLS policies
- ✅ Keep app updated
- ✅ Review connected devices regularly

## Support

For issues or questions:
1. Check troubleshooting section
2. Review MikroTik documentation
3. Open issue on GitHub
4. Check community forums

---

**Remember**: Security is your responsibility. Always follow best practices when exposing network equipment to the internet.
