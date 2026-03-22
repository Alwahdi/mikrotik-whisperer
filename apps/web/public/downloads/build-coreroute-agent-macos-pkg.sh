#!/usr/bin/env bash
set -euo pipefail

echo "CoreRoute macOS PKG Builder"
echo "---------------------------"

if ! command -v pkgbuild >/dev/null 2>&1; then
  echo "pkgbuild is not available. Install Xcode command line tools first."
  exit 1
fi

if [[ ! -d "agent" ]]; then
  echo "Run from CoreRoute project root."
  exit 1
fi

APP_ROOT="$PWD"
STAGE_DIR="$APP_ROOT/.tmp/agent-pkg-root"
SCRIPTS_DIR="$APP_ROOT/.tmp/agent-pkg-scripts"
VERSION="${COREROUTE_AGENT_VERSION:-0.1.0}"
UNSIGNED_PKG="$APP_ROOT/CoreRoute-Agent-Setup-unsigned.pkg"
OUT_PKG="$APP_ROOT/CoreRoute-Agent-Setup.pkg"
SIGN_IDENTITY="${APPLE_INSTALLER_SIGN_IDENTITY:-}"

NOTARIZE="${APPLE_NOTARIZE:-false}"
APPLE_TEAM_ID="${APPLE_TEAM_ID:-}"
APPLE_NOTARY_PROFILE="${APPLE_NOTARY_PROFILE:-}"

rm -rf "$STAGE_DIR" "$SCRIPTS_DIR"
mkdir -p "$STAGE_DIR/usr/local/coreroute-agent" "$SCRIPTS_DIR"

cp -R "$APP_ROOT/agent" "$STAGE_DIR/usr/local/coreroute-agent/"
cp "$APP_ROOT/package.json" "$STAGE_DIR/usr/local/coreroute-agent/" || true

cat > "$SCRIPTS_DIR/postinstall" <<'POST'
#!/bin/bash
set -e
cd /usr/local/coreroute-agent
npm --prefix agent install
npm --prefix agent run build
POST
chmod +x "$SCRIPTS_DIR/postinstall"

pkgbuild \
  --root "$STAGE_DIR" \
  --identifier "com.coreroute.agent" \
  --version "$VERSION" \
  --scripts "$SCRIPTS_DIR" \
  "$UNSIGNED_PKG"

if [[ -n "$SIGN_IDENTITY" ]]; then
  if ! command -v productsign >/dev/null 2>&1; then
    echo "productsign is required for signed PKG output."
    exit 1
  fi

  echo "Signing package with identity: $SIGN_IDENTITY"
  productsign --sign "$SIGN_IDENTITY" "$UNSIGNED_PKG" "$OUT_PKG"
else
  echo "APPLE_INSTALLER_SIGN_IDENTITY not set. Producing unsigned package."
  cp "$UNSIGNED_PKG" "$OUT_PKG"
fi

if [[ "$NOTARIZE" == "true" ]]; then
  if [[ -z "$APPLE_TEAM_ID" || -z "$APPLE_NOTARY_PROFILE" ]]; then
    echo "Skipping notarization: APPLE_TEAM_ID or APPLE_NOTARY_PROFILE is missing."
  else
    if ! command -v xcrun >/dev/null 2>&1; then
      echo "xcrun is required for notarization."
      exit 1
    fi
    echo "Submitting package for notarization..."
    xcrun notarytool submit "$OUT_PKG" \
      --keychain-profile "$APPLE_NOTARY_PROFILE" \
      --team-id "$APPLE_TEAM_ID" \
      --wait

    echo "Stapling notarization ticket..."
    xcrun stapler staple "$OUT_PKG"
  fi
fi

echo "Created: $OUT_PKG"
