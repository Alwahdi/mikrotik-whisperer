#!/usr/bin/env bash
set -euo pipefail

echo "CoreRoute Local Agent Installer (macOS)"
echo "--------------------------------------"

if ! command -v npm >/dev/null 2>&1; then
  echo "Node.js/npm is required: https://nodejs.org"
  exit 1
fi

if [[ ! -d "agent" ]]; then
  echo "Run this from CoreRoute project root (contains 'agent/' folder)."
  exit 1
fi

echo "Installing dependencies..."
npm --prefix agent install

echo "Building agent..."
npm --prefix agent run build

echo "Starting agent in dev mode..."
echo "Use Ctrl+C to stop"
npm run agent:dev
