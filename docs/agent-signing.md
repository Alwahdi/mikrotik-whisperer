# CoreRoute Agent Signing Guide

This guide configures signed installers for macOS and Windows in CI.

## macOS signed PKG

Required GitHub secrets:

- APPLE_INSTALLER_SIGN_IDENTITY
- APPLE_INSTALLER_CERT_BASE64
- APPLE_INSTALLER_CERT_PASSWORD

Optional for notarization:

- APPLE_NOTARIZE=true
- APPLE_TEAM_ID
- APPLE_NOTARY_PROFILE

Notes:

- `APPLE_INSTALLER_CERT_BASE64` is a base64-encoded `.p12` installer certificate.
- The workflow imports this cert to a temporary keychain.
- If signing secrets are missing, CI still builds an unsigned PKG.

## Windows signed Setup.exe

Required for signing:

- WINDOWS_SIGN_PFX_BASE64
- WINDOWS_SIGN_PFX_PASSWORD

Optional:

- WINDOWS_SIGN_TIMESTAMP_URL (default: http://timestamp.digicert.com)

Notes:

- `WINDOWS_SIGN_PFX_BASE64` is a base64-encoded `.pfx` code-sign certificate.
- CI builds `CoreRoute-Agent-Setup.exe` using Inno Setup.
- If signing secrets are missing, installer is built unsigned.

## Release trigger

Use one of:

- Manual workflow dispatch
- Push a tag like `agent-v1.0.0`

Artifacts:

- `CoreRoute-Agent-Setup.pkg` (+ sha256)
- `CoreRoute-Agent-Setup.exe` (if Inno Setup build succeeds)
- `CoreRoute-Agent-Setup.zip` (+ sha256)
