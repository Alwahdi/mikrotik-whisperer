import baseConfig from './base.js'
import reactHooks from 'eslint-plugin-react-hooks'

/**
 * ESLint configuration for React library packages
 * Extends base config with React library specific rules
 */
export default [
  ...baseConfig,
  {
    files: ['**/*.{ts,tsx}'],
    plugins: {
      'react-hooks': reactHooks,
    },
    rules: {
      ...reactHooks.configs.recommended.rules,

      // React library specific
      'react-hooks/rules-of-hooks': 'error',
      'react-hooks/exhaustive-deps': 'warn',

      // Allow console in libraries for debugging
      'no-console': 'off',
    },
  },
]
