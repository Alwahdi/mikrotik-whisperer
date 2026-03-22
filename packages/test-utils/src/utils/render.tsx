/**
 * Custom render function with providers for testing React components
 */
import { render, type RenderOptions, type RenderResult } from '@testing-library/react'
import type { ReactElement, ReactNode } from 'react'

export interface TestProviderProps {
  children: ReactNode
}

/**
 * Wrapper component that includes all necessary providers for testing
 */
function TestProviders({ children }: TestProviderProps) {
  // Add providers as needed (React Query, Auth, etc.)
  return <>{children}</>
}

/**
 * Custom render function that wraps components with test providers
 */
export function renderWithProviders(
  ui: ReactElement,
  options?: Omit<RenderOptions, 'wrapper'>
): RenderResult {
  return render(ui, { wrapper: TestProviders, ...options })
}

/**
 * Re-export everything from @testing-library/react
 */
export * from '@testing-library/react'
export { renderWithProviders as render }
