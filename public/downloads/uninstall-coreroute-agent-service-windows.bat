@echo off
setlocal
powershell -ExecutionPolicy Bypass -File "%~dp0uninstall-coreroute-agent-service-windows.ps1"
