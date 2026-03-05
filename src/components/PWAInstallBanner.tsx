import { useState, useEffect } from "react";
import { usePWA } from "@/hooks/usePWA";
import { Download, X, Smartphone } from "lucide-react";
import { Button } from "@/components/ui/button";

export default function PWAInstallBanner() {
  const { isInstallable, isInstalled, install } = usePWA();
  const [dismissed, setDismissed] = useState(false);
  const [show, setShow] = useState(false);

  useEffect(() => {
    const wasDismissed = sessionStorage.getItem("pwa-dismissed");
    if (wasDismissed) {
      setDismissed(true);
      return;
    }
    // Delay showing the banner slightly for better UX
    if (isInstallable && !isInstalled) {
      const timer = setTimeout(() => setShow(true), 2000);
      return () => clearTimeout(timer);
    }
  }, [isInstallable, isInstalled]);

  if (!show || dismissed || isInstalled) return null;

  const handleDismiss = () => {
    setDismissed(true);
    sessionStorage.setItem("pwa-dismissed", "true");
  };

  const handleInstall = async () => {
    const accepted = await install();
    if (accepted) handleDismiss();
  };

  return (
    <div className="pwa-install-banner safe-bottom" dir="rtl">
      <div className="mx-4 mb-4 rounded-xl border border-border bg-card shadow-xl p-4">
        <div className="flex items-start gap-3">
          <div className="shrink-0 p-2.5 rounded-lg gradient-primary">
            <Smartphone className="h-5 w-5 text-primary-foreground" />
          </div>
          <div className="flex-1 min-w-0">
            <h3 className="text-sm font-bold text-foreground mb-0.5">
              تثبيت التطبيق
            </h3>
            <p className="text-xs text-muted-foreground leading-relaxed">
              ثبّت MikroTik Manager على جهازك للوصول السريع والعمل بدون إنترنت
            </p>
          </div>
          <button
            onClick={handleDismiss}
            className="shrink-0 p-1 rounded-md text-muted-foreground hover:text-foreground hover:bg-muted transition-colors"
          >
            <X className="h-4 w-4" />
          </button>
        </div>
        <div className="flex items-center gap-2 mt-3">
          <Button onClick={handleInstall} size="sm" className="flex-1 text-xs gap-1.5">
            <Download className="h-3.5 w-3.5" />
            تثبيت الآن
          </Button>
          <Button onClick={handleDismiss} size="sm" variant="ghost" className="text-xs text-muted-foreground">
            لاحقاً
          </Button>
        </div>
      </div>
    </div>
  );
}
