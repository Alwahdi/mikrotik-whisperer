$ErrorActionPreference = 'Stop'
$taskName = "CoreRouteAgent"
Write-Host "Removing CoreRoute Agent startup task"
schtasks /Delete /TN $taskName /F | Out-Null
Write-Host "Done." -ForegroundColor Green
