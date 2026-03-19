#!/usr/bin/env bash
set -euo pipefail

echo "CoreRoute Local Agent Installer"
echo "--------------------------------"

if ! command -v npm >/dev/null 2>&1; then
  echo "npm is required. Install Node.js first: https://nodejs.org"
  exit 1
fi

if [ ! -d "agent" ]; then
  echo "Run this script from CoreRoute project root (folder that contains 'agent')."
  exit 1
fi

echo "Installing agent dependencies..."
npm --prefix agent install

echo "Building agent..."
npm --prefix agent run build

echo "Done. To run agent:"
echo "npm run agent:dev"
