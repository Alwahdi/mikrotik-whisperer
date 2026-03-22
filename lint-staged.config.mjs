const lintCommand =
  "turbo lint --filter=@mikrotik-whisperer/web... --filter=@mikrotik-whisperer/docs... --filter=@mikrotik-whisperer/agent...";
const testCommand =
  "turbo test --filter=@mikrotik-whisperer/web... --filter=@mikrotik-whisperer/agent...";

export default {
  "*.{ts,tsx,js,jsx,md,mdx,json,css}": () => [lintCommand, testCommand],
};
