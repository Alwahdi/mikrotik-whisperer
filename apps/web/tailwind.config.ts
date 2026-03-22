import type { Config } from "tailwindcss";
import designSystemPreset from "@repo/design-system/tailwind.config";

export default {
  presets: [designSystemPreset as Config],
  content: [
    "./src/**/*.{ts,tsx}",
    "../../packages/design-system/src/**/*.{ts,tsx}",
  ],
} satisfies Config;
