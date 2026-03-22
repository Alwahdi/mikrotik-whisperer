/**
 * Shared Prettier configuration for the entire workspace
 * Ensures consistent code formatting across all packages
 *
 * @see https://prettier.io/docs/en/configuration.html
 */
export default {
  // Core formatting
  semi: false,
  singleQuote: true,
  tabWidth: 2,
  useTabs: false,
  trailingComma: 'es5',
  printWidth: 100,
  arrowParens: 'always',

  // JSX
  jsxSingleQuote: false,
  bracketSpacing: true,
  bracketSameLine: false,

  // Prose
  proseWrap: 'preserve',
  endOfLine: 'lf',

  // Plugins
  plugins: ['prettier-plugin-tailwindcss'],

  // File-specific overrides
  overrides: [
    {
      files: '*.md',
      options: {
        proseWrap: 'always',
        printWidth: 80,
      },
    },
    {
      files: '*.json',
      options: {
        printWidth: 80,
      },
    },
  ],
}
