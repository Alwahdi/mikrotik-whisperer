$ErrorActionPreference = 'Stop'

Write-Host "Installing CoreRoute Agent as Windows startup task" -ForegroundColor Cyan
Write-Host "---------------------------------------------------"

if (-not (Get-Command npm -ErrorAction SilentlyContinue)) {
  Write-Error "Node.js/npm is required. Install from https://nodejs.org"
}

$projectRoot = (Get-Location).Path
if (-not (Test-Path -Path (Join-Path $projectRoot "agent") -PathType Container)) {
  Write-Error "Run this script from CoreRoute project root (contains agent folder)."
}

npm --prefix agent install
npm --prefix agent run build

$taskName = "CoreRouteAgent"
$runCmd = "cmd /c cd /d \"$projectRoot\" && npm run agent:start"

schtasks /Create /TN $taskName /SC ONLOGON /TR $runCmd /F | Out-Null
schtasks /Run /TN $taskName | Out-Null

Write-Host "Service task installed and started." -ForegroundColor Green
