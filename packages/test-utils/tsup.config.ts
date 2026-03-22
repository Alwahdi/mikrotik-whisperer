import { defineConfig } from 'tsup'

export default defineConfig({
  entry: [
    'src/mocks/supabase.ts',
    'src/mocks/mikrotik.ts',
    'src/fixtures/index.ts',
    'src/utils/render.tsx',
    'src/utils/matchers.ts',
  ],
  format: ['esm'],
  dts: true,
  clean: true,
  sourcemap: true,
  external: ['react', 'react-dom', 'vitest'],
})
