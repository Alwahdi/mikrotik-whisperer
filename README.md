# Welcome to your Lovable project

## CoreRoute Runtime Modes

This project now supports two MikroTik runtime paths automatically:

- Local LAN target (192.168.x.x / 10.x.x.x / 172.16-31.x.x / localhost): uses CoreRoute Local Agent
- Public IP or DNS target: uses cloud bridge via Supabase Edge Function

At app startup, when the selected router is local LAN, the UI checks if the agent is running:

- If running: shows Local Agent running
- If down: shows install/start instructions in-app with one-click installer download
- Shows current agent version and update availability (from release manifest)

## Quick start (best experience)

```sh
# install web deps
npm install

# install agent deps
npm run agent:install

# run web + agent together
npm run dev:all
```

Agent default URL: http://127.0.0.1:3001

You can override it with:

- VITE_MIKROTIK_AGENT_URL
- Or from Settings page (CoreRoute Local Agent section)

One-click installer file (download from browser):

- /downloads/install-coreroute-agent-macos.command
- /downloads/install-coreroute-agent-windows.bat

Native packaging helper scripts:

- /downloads/build-coreroute-agent-macos-pkg.sh
- /downloads/build-coreroute-agent-windows-installer.ps1

Auto-start service installers:

- /downloads/install-coreroute-agent-service-macos.sh
- /downloads/install-coreroute-agent-service-windows.bat

CI pipeline for installers:

- .github/workflows/agent-installers.yml
- Trigger manually with workflow_dispatch or by pushing tags like agent-v1.0.0

Certificate/signing setup:

- docs/agent-signing.md

Advanced operations page:

- /health (service readiness, per-service latency, agent runtime diagnostics)

## Project info

**URL**: https://lovable.dev/projects/REPLACE_WITH_PROJECT_ID

## How can I edit this code?

There are several ways of editing your application.

**Use Lovable**

Simply visit the [Lovable Project](https://lovable.dev/projects/REPLACE_WITH_PROJECT_ID) and start prompting.

Changes made via Lovable will be committed automatically to this repo.

**Use your preferred IDE**

If you want to work locally using your own IDE, you can clone this repo and push changes. Pushed changes will also be reflected in Lovable.

## Mobile (Expo) app

A new Expo Router mobile client ships with the same feature set as the web platform: router selection, live stats, hotspot management, and an embedded full web experience.

1) Install deps: `cd mobile && npm install`
2) Copy envs: `cp .env.example .env` and set `EXPO_PUBLIC_SUPABASE_URL`, `EXPO_PUBLIC_SUPABASE_ANON_KEY`, and optional `EXPO_PUBLIC_WEB_APP_URL`
3) Run: `npm run start` then open with Expo Go (or `npm run android` / `npm run ios` / `npm run web`)

The app uses Supabase auth/storage, reads routers from the `routers` table, calls the `mikrotik-api` edge function for live device actions, and falls back to the full web UI inside the "منصة الويب" tab for 100% parity.

The only requirement is having Node.js & npm installed - [install with nvm](https://github.com/nvm-sh/nvm#installing-and-updating)

Follow these steps:

```sh
# Step 1: Clone the repository using the project's Git URL.
git clone <YOUR_GIT_URL>

# Step 2: Navigate to the project directory.
cd <YOUR_PROJECT_NAME>

# Step 3: Install the necessary dependencies.
npm i

# Step 4: Start the development server with auto-reloading and an instant preview.
npm run dev
```

**Edit a file directly in GitHub**

- Navigate to the desired file(s).
- Click the "Edit" button (pencil icon) at the top right of the file view.
- Make your changes and commit the changes.

**Use GitHub Codespaces**

- Navigate to the main page of your repository.
- Click on the "Code" button (green button) near the top right.
- Select the "Codespaces" tab.
- Click on "New codespace" to launch a new Codespace environment.
- Edit files directly within the Codespace and commit and push your changes once you're done.

## What technologies are used for this project?

This project is built with:

- Vite
- TypeScript
- React
- shadcn-ui
- Tailwind CSS

## How can I deploy this project?

Simply open [Lovable](https://lovable.dev/projects/REPLACE_WITH_PROJECT_ID) and click on Share -> Publish.

## Can I connect a custom domain to my Lovable project?

Yes, you can!

To connect a domain, navigate to Project > Settings > Domains and click Connect Domain.

Read more here: [Setting up a custom domain](https://docs.lovable.dev/features/custom-domain#custom-domain)
