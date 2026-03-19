$ErrorActionPreference = 'Stop'
Write-Host "CoreRoute Local Agent Installer (Windows)" -ForegroundColor Cyan
Write-Host "----------------------------------------"

if (-not (Get-Command npm -ErrorAction SilentlyContinue)) {
  Write-Error "Node.js/npm is required. Install from https://nodejs.org"
}

if (-not (Test-Path -Path "agent" -PathType Container)) {
  Write-Error "Run this script from CoreRoute project root (contains agent folder)."
}

Write-Host "Installing dependencies..." -ForegroundColor Yellow
npm --prefix agent install

Write-Host "Building agent..." -ForegroundColor Yellow
npm --prefix agent run build

Write-Host "Starting agent..." -ForegroundColor Green
npm run agent:dev
