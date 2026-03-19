$ErrorActionPreference = 'Stop'
Write-Host "CoreRoute Windows Installer Builder" -ForegroundColor Cyan
Write-Host "-----------------------------------"
Write-Host "This script builds Setup.exe (Inno Setup) and optionally signs it." -ForegroundColor Yellow

$root = Get-Location
$outDir = Join-Path $root "CoreRoute-Agent-Installer"
$zipPath = Join-Path $root "CoreRoute-Agent-Setup.zip"
$exePath = Join-Path $root "CoreRoute-Agent-Setup.exe"
$issPath = Join-Path $root ".tmp\coreroute-agent.iss"
$tmpDir = Join-Path $root ".tmp"
$version = $env:COREROUTE_AGENT_VERSION
if ([string]::IsNullOrWhiteSpace($version)) { $version = "0.1.0" }

if (Test-Path $outDir) { Remove-Item $outDir -Recurse -Force }
if (Test-Path $zipPath) { Remove-Item $zipPath -Force }
if (Test-Path $exePath) { Remove-Item $exePath -Force }
if (Test-Path $tmpDir) { Remove-Item $tmpDir -Recurse -Force }

New-Item -ItemType Directory -Path $tmpDir | Out-Null

New-Item -ItemType Directory -Path $outDir | Out-Null
Copy-Item -Path "agent" -Destination $outDir -Recurse
Copy-Item -Path "public/downloads/install-coreroute-agent-windows.ps1" -Destination $outDir
Copy-Item -Path "public/downloads/install-coreroute-agent-windows.bat" -Destination $outDir
Copy-Item -Path "public/downloads/install-coreroute-agent-service-windows.ps1" -Destination $outDir
Copy-Item -Path "public/downloads/install-coreroute-agent-service-windows.bat" -Destination $outDir

$iss = @"
[Setup]
AppName=CoreRoute Agent
AppVersion=$version
DefaultDirName={autopf}\CoreRouteAgent
DefaultGroupName=CoreRoute Agent
OutputDir=$root
OutputBaseFilename=CoreRoute-Agent-Setup
Compression=lzma2
SolidCompression=yes
DisableProgramGroupPage=yes

[Files]
Source: "$outDir\*"; DestDir: "{app}"; Flags: recursesubdirs createallsubdirs

[Run]
Filename: "{cmd}"; Parameters: "/C cd /D ""{app}"" && npm --prefix agent install && npm --prefix agent run build"; Flags: runhidden

[Icons]
Name: "{group}\Start CoreRoute Agent"; Filename: "{cmd}"; Parameters: "/C cd /D ""{app}"" && npm run agent:start"
"@

Set-Content -Path $issPath -Value $iss -Encoding UTF8

$iscc = $null
if (Get-Command iscc -ErrorAction SilentlyContinue) {
	$iscc = "iscc"
} elseif (Test-Path "C:\Program Files (x86)\Inno Setup 6\ISCC.exe") {
	$iscc = "C:\Program Files (x86)\Inno Setup 6\ISCC.exe"
}

if ($iscc) {
	Write-Host "Building Setup.exe using Inno Setup..." -ForegroundColor Yellow
	& $iscc $issPath
} else {
	Write-Host "Inno Setup not found. Falling back to ZIP payload." -ForegroundColor Yellow
}

$pfxPath = $env:WINDOWS_SIGN_PFX_PATH
$pfxPassword = $env:WINDOWS_SIGN_PFX_PASSWORD
$timestampUrl = $env:WINDOWS_SIGN_TIMESTAMP_URL
if ([string]::IsNullOrWhiteSpace($timestampUrl)) { $timestampUrl = "http://timestamp.digicert.com" }

if ((Test-Path $exePath) -and -not [string]::IsNullOrWhiteSpace($pfxPath) -and -not [string]::IsNullOrWhiteSpace($pfxPassword)) {
	$signtool = "${env:ProgramFiles(x86)}\Windows Kits\10\bin\x64\signtool.exe"
	if (-not (Test-Path $signtool)) {
		$signtool = "signtool"
	}

	Write-Host "Signing Setup.exe..." -ForegroundColor Yellow
	& $signtool sign /f $pfxPath /p $pfxPassword /fd SHA256 /tr $timestampUrl /td SHA256 $exePath
}

Compress-Archive -Path "$outDir\*" -DestinationPath $zipPath -Force

if (Test-Path $exePath) {
	Write-Host "Created: $exePath" -ForegroundColor Green
}
Write-Host "Created: $zipPath" -ForegroundColor Green
