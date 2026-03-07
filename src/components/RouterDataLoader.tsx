import { useEffect, useRef } from "react";
import { useNavigate } from "react-router-dom";
import { useRouterPrefetch } from "@/hooks/useRouterPrefetch";
import { Progress } from "@/components/ui/progress";
import { Loader2, Wifi, AlertTriangle, RefreshCw } from "lucide-react";
import { Button } from "@/components/ui/button";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";

export default function RouterDataLoader() {
  const navigate = useNavigate();
  const { prefetch, progress, currentStep, loading, error } = useRouterPrefetch();
  const started = useRef(false);
  const config = getMikrotikConfig();

  useEffect(() => {
    if (started.current) return;
    started.current = true;

    if (!config) {
      navigate("/routers", { replace: true });
      return;
    }

    prefetch().then((success) => {
      if (success) {
        // Small delay to show 100% before navigating
        setTimeout(() => navigate("/dashboard", { replace: true }), 400);
      }
    });
  }, []);

  return (
    <div className="min-h-screen bg-background flex items-center justify-center p-4" dir="rtl">
      <div className="w-full max-w-sm text-center space-y-6">
        {/* Logo / Icon */}
        <div className="flex justify-center">
          <div className={`p-4 rounded-2xl gradient-primary ${loading ? "animate-pulse" : ""}`}>
            <Wifi className="h-8 w-8 text-primary-foreground" />
          </div>
        </div>

        {/* Router Name */}
        <div>
          <h2 className="text-lg font-bold text-foreground">{config?.label || "MikroTik"}</h2>
          <p className="text-xs text-muted-foreground font-mono mt-1">{config?.host}:{config?.port}</p>
        </div>

        {/* Error State */}
        {error ? (
          <div className="space-y-4">
            <div className="p-4 rounded-lg bg-destructive/5 border border-destructive/20">
              <AlertTriangle className="h-5 w-5 text-destructive mx-auto mb-2" />
              <p className="text-sm text-destructive">{error}</p>
            </div>
            <div className="flex gap-2 justify-center">
              <Button size="sm" variant="outline" onClick={() => navigate("/routers", { replace: true })}>
                الراوترات
              </Button>
              <Button size="sm" onClick={() => {
                started.current = false;
                prefetch().then((success) => {
                  if (success) setTimeout(() => navigate("/dashboard", { replace: true }), 250);
                });
              }}>
                <RefreshCw className="h-3.5 w-3.5 ml-1" />
                إعادة المحاولة
              </Button>
            </div>
          </div>
        ) : (
          /* Loading State */
          <div className="space-y-4">
            <Progress value={progress} className="h-2" />
            <div className="flex items-center justify-center gap-2">
              <Loader2 className="h-3.5 w-3.5 animate-spin text-primary" />
              <p className="text-xs text-muted-foreground">{currentStep}</p>
            </div>
            <p className="text-[10px] text-muted-foreground/60">
              {progress < 100 ? `${progress}%` : "جاري الانتقال..."}
            </p>
          </div>
        )}
      </div>
    </div>
  );
}
