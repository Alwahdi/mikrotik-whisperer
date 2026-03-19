#!/usr/bin/env bash
set -euo pipefail

SERVICE_ID="com.coreroute.agent"
PLIST_PATH="$HOME/Library/LaunchAgents/${SERVICE_ID}.plist"

echo "Uninstalling CoreRoute Agent macOS service"
launchctl bootout "gui/$(id -u)/${SERVICE_ID}" >/dev/null 2>&1 || true
rm -f "$PLIST_PATH"
echo "Done."
