#!/usr/bin/env bash
set -euo pipefail

SERVICE_ID="com.coreroute.agent"
PLIST_PATH="$HOME/Library/LaunchAgents/${SERVICE_ID}.plist"
LOG_DIR="$HOME/Library/Logs"
OUT_LOG="$LOG_DIR/coreroute-agent.out.log"
ERR_LOG="$LOG_DIR/coreroute-agent.err.log"
PROJECT_ROOT="$PWD"

echo "Installing CoreRoute Agent as macOS launchd service"
echo "--------------------------------------------------"

if ! command -v npm >/dev/null 2>&1; then
  echo "npm is required. Install Node.js first: https://nodejs.org"
  exit 1
fi

if [[ ! -d "$PROJECT_ROOT/agent" ]]; then
  echo "Run this script from CoreRoute project root (contains agent folder)."
  exit 1
fi

mkdir -p "$HOME/Library/LaunchAgents" "$LOG_DIR"

cat > "$PLIST_PATH" <<PLIST
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
  <dict>
    <key>Label</key>
    <string>${SERVICE_ID}</string>
    <key>RunAtLoad</key>
    <true/>
    <key>KeepAlive</key>
    <true/>
    <key>WorkingDirectory</key>
    <string>${PROJECT_ROOT}</string>
    <key>ProgramArguments</key>
    <array>
      <string>/bin/zsh</string>
      <string>-lc</string>
      <string>cd '${PROJECT_ROOT}' && npm run agent:start</string>
    </array>
    <key>StandardOutPath</key>
    <string>${OUT_LOG}</string>
    <key>StandardErrorPath</key>
    <string>${ERR_LOG}</string>
  </dict>
</plist>
PLIST

npm --prefix agent install
npm --prefix agent run build

launchctl bootout "gui/$(id -u)/${SERVICE_ID}" >/dev/null 2>&1 || true
launchctl bootstrap "gui/$(id -u)" "$PLIST_PATH"
launchctl kickstart -k "gui/$(id -u)/${SERVICE_ID}"

echo "Service installed and started."
echo "Logs: $OUT_LOG"
