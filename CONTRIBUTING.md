# 🤝 Contributing to MikroTik Whisperer | المساهمة في مشروع MikroTik Whisperer

Thank you for your interest in contributing! This document provides guidelines for contributing to this project.

شكراً على اهتمامك بالمساهمة! هذا المستند يوفر إرشادات للمساهمة في هذا المشروع.

---

## 📋 Table of Contents | جدول المحتويات

1. [Getting Started](#-getting-started)
2. [Development Setup](#%EF%B8%8F-development-setup)
3. [Coding Standards](#-coding-standards)
4. [Branch Strategy](#-branch-strategy)
5. [Commit Conventions](#-commit-conventions)
6. [Pull Request Process](#-pull-request-process)
7. [Testing Requirements](#-testing-requirements)
8. [Code Review](#-code-review)

---

## 🚀 Getting Started

### Prerequisites | المتطلبات الأساسية

- **Node.js**: 20.x or higher
- **pnpm**: 10.12.1 or higher
- **Git**: Latest version

### First Time Setup

```bash
# 1. Fork the repository
# 2. Clone your fork
git clone https://github.com/YOUR_USERNAME/mikrotik-whisperer.git
cd mikrotik-whisperer

# 3. Install dependencies
pnpm install

# 4. Copy environment variables
cp .env.example .env

# 5. Run development server
pnpm dev
```

---

## 🛠️ Development Setup

### Available Commands

```bash
# Development
pnpm dev          # Start all apps in dev mode
pnpm dev:app      # Start main app only (port 3000)
pnpm dev:web      # Start marketing site (port 3001)

# Building
pnpm build        # Build all packages and apps
pnpm turbo build  # Same as above (using Turbo)

# Testing
pnpm test         # Run all tests
pnpm test:watch   # Run tests in watch mode
pnpm test:coverage # Run tests with coverage report

# Linting & Type-checking
pnpm lint         # Run ESLint on all packages
pnpm type-check   # Run TypeScript type checking
pnpm format       # Format code with Prettier

# Database
pnpm db:generate  # Generate Supabase types
pnpm db:push      # Push schema changes
```

---

## 📏 Coding Standards

### **MANDATORY**: Read These First | **إلزامي**: اقرأ هذه أولاً

Before writing any code, you **MUST** read:

1. **[CODING_GUIDELINES.md](./CODING_GUIDELINES.md)** - Coding standards (MANDATORY)
2. **[ARCHITECTURE.md](./ARCHITECTURE.md)** - System architecture
3. **[TESTING_STRATEGY.md](./TESTING_STRATEGY.md)** - Testing requirements

### Key Principles | المبادئ الأساسية

#### 1. Single Responsibility Principle (SRP)

```typescript
// ❌ BAD: Function doing multiple things
function createUserAndSendEmail() {}

// ✅ GOOD: Separate responsibilities
function createUser() {}
function sendWelcomeEmail() {}
```

#### 2. DRY (Don't Repeat Yourself)

```typescript
// ❌ BAD: Duplicate validation
if (email.includes('@')) {}  // In multiple places

// ✅ GOOD: Single source of truth
function isValidEmail(email: string) {
  return EMAIL_REGEX.test(email)
}
```

#### 3. KISS (Keep It Simple, Stupid)

```typescript
// ❌ BAD: Overly complex
const result = arr.reduce((acc, val) => [...acc, ...(val > 0 ? [val * 2] : [])], [])

// ✅ GOOD: Simple and clear
const result = arr.filter(val => val > 0).map(val => val * 2)
```

#### 4. Function Size Limit

- **Maximum**: 50 lines (including comments)
- **Ideal**: 10-20 lines
- **If longer**: Split into smaller functions

#### 5. Naming Conventions

```typescript
// Variables & Functions: camelCase
const userName = 'John'
function getUserProfile() {}

// Classes & Types: PascalCase
class UserService {}
type UserProfile = {}

// Constants: UPPER_SNAKE_CASE
const MAX_RETRIES = 3

// Booleans: is*, has*, can*, should*
const isValid = true
const hasPermission = false
```

---

## 🌳 Branch Strategy

### Branch Types | أنواع الفروع

```
main              Production branch (protected)
  ↓
feature/*         New features
fix/*             Bug fixes
refactor/*        Code refactoring
docs/*            Documentation changes
test/*            Test additions/fixes
chore/*           Maintenance tasks
```

### Branch Naming | تسمية الفروع

```bash
# Feature
feature/add-voucher-expiry
feature/implement-bulk-delete

# Bug Fix
fix/voucher-generation-error
fix/dashboard-loading-state

# Refactor
refactor/service-layer-cleanup
refactor/migrate-to-react-19

# Documentation
docs/update-api-examples
docs/add-architecture-guide
```

### Creating a Branch

```bash
# 1. Update main
git checkout main
git pull origin main

# 2. Create feature branch
git checkout -b feature/my-awesome-feature

# 3. Make changes and commit
git add .
git commit -m "feat: add awesome feature"

# 4. Push to your fork
git push origin feature/my-awesome-feature
```

---

## 📝 Commit Conventions

### Conventional Commits Format

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Types | الأنواع

- **feat**: New feature
- **fix**: Bug fix
- **refactor**: Code refactoring
- **docs**: Documentation changes
- **test**: Adding/fixing tests
- **chore**: Maintenance tasks
- **perf**: Performance improvements
- **style**: Code style changes (formatting)

### Examples | أمثلة

```bash
# Feature
feat(vouchers): add bulk generation support

# Bug Fix
fix(auth): resolve session timeout issue

# Refactoring
refactor(services): simplify error handling logic

# Documentation
docs(readme): update installation instructions

# Testing
test(mikrotik): add integration tests for retry logic

# Performance
perf(dashboard): optimize voucher list rendering
```

### Commit Message Guidelines

```bash
# ✅ GOOD: Clear and specific
feat(vouchers): add expiry date validation
fix(auth): prevent duplicate session creation
refactor(services): extract retry logic to utility

# ❌ BAD: Vague and unclear
feat: add stuff
fix: fix bug
refactor: clean code
```

---

## 🔄 Pull Request Process

### Before Creating PR

1. **Update your branch**
   ```bash
   git checkout main
   git pull origin main
   git checkout your-branch
   git rebase main
   ```

2. **Run all checks**
   ```bash
   pnpm turbo build      # Build succeeds
   pnpm turbo lint       # No linting errors
   pnpm turbo type-check # No type errors
   pnpm turbo test       # All tests pass
   ```

3. **Review your changes**
   ```bash
   git diff main...your-branch
   ```

### Creating the PR

1. **Title Format**
   ```
   feat(vouchers): add bulk generation support
   fix(auth): resolve session timeout issue
   ```

2. **Description Template**
   ```markdown
   ## Summary
   Brief description of what this PR does

   ## Changes
   - Added bulk voucher generation
   - Updated validation logic
   - Added integration tests

   ## Testing
   - [ ] Unit tests added/updated
   - [ ] Integration tests added
   - [ ] Manually tested in dev environment

   ## Screenshots (if applicable)
   [Add screenshots for UI changes]

   ## Related Issues
   Closes #123
   ```

3. **Checklist**
   - [ ] Code follows [CODING_GUIDELINES.md](./CODING_GUIDELINES.md)
   - [ ] Tests added/updated
   - [ ] Documentation updated
   - [ ] No breaking changes (or documented)
   - [ ] Commit messages follow conventions
   - [ ] All CI checks passing

---

## 🧪 Testing Requirements

### Coverage Requirements | متطلبات التغطية

- **Services**: **> 80%** (MANDATORY) 🔥
- **Utilities**: **> 90%**
- **Components**: **> 60%**

### Testing Checklist

- [ ] Unit tests for new functions
- [ ] Integration tests for services
- [ ] E2E tests for critical journeys (if applicable)
- [ ] Mock external dependencies
- [ ] Test both success and failure paths
- [ ] No skipped tests without reason

### Running Tests

```bash
# Run all tests
pnpm test

# Run specific package tests
pnpm test --filter=@repo/services

# Run with coverage
pnpm test --coverage

# Watch mode
pnpm test:watch
```

See [TESTING_STRATEGY.md](./TESTING_STRATEGY.md) for detailed guidelines.

---

## 👀 Code Review

### What Reviewers Look For

1. **Code Quality**
   - Follows coding guidelines
   - Clean and readable
   - Properly documented

2. **Testing**
   - Adequate test coverage
   - Tests are meaningful
   - Edge cases covered

3. **Performance**
   - No obvious performance issues
   - Efficient algorithms
   - Proper caching if needed

4. **Security**
   - Input validation
   - No sensitive data exposure
   - Proper error handling

5. **Architecture**
   - Follows existing patterns
   - Proper separation of concerns
   - Scalable design

### Addressing Review Comments

```bash
# 1. Make requested changes
# ... edit files ...

# 2. Commit changes
git add .
git commit -m "refactor: address review comments"

# 3. Push to PR
git push origin your-branch
```

---

## 🔒 Security Practices

### Input Validation

```typescript
// ✅ Always validate with Zod
import { z } from 'zod'

const schema = z.object({
  email: z.string().email(),
  age: z.number().min(18),
})

const validated = schema.parse(input)
```

### Never Commit Secrets

```typescript
// ❌ BAD: Hardcoded secrets
const API_KEY = 'sk_live_abc123'

// ✅ GOOD: Use environment variables
import { env } from '@repo/env'
const API_KEY = env.API_KEY
```

### Redact Sensitive Data in Logs

```typescript
// ❌ BAD: Logging passwords
logger.info('User login', { email, password })

// ✅ GOOD: Redact sensitive fields
logger.info('User login', { email, password: '[REDACTED]' })
```

---

## 📚 Additional Resources

### Documentation

- [ARCHITECTURE.md](./ARCHITECTURE.md) - System architecture
- [CODING_GUIDELINES.md](./CODING_GUIDELINES.md) - Coding standards
- [TESTING_STRATEGY.md](./TESTING_STRATEGY.md) - Testing guidelines
- [OBSERVABILITY.md](./OBSERVABILITY.md) - Logging & monitoring

### External Resources

- [Turborepo Docs](https://turbo.build/repo/docs)
- [Next.js Docs](https://nextjs.org/docs)
- [Supabase Docs](https://supabase.com/docs)
- [TypeScript Best Practices](https://www.typescriptlang.org/docs/handbook/declaration-files/do-s-and-don-ts.html)

---

## 🤔 Questions?

- **Issues**: [GitHub Issues](https://github.com/Alwahdi/mikrotik-whisperer/issues)
- **Discussions**: [GitHub Discussions](https://github.com/Alwahdi/mikrotik-whisperer/discussions)

---

## 🎯 Quick Reference

### Pre-Commit Checklist

```bash
# Run these before every commit
pnpm turbo build      # ✅ Builds successfully
pnpm turbo lint       # ✅ No linting errors
pnpm turbo type-check # ✅ No type errors
pnpm turbo test       # ✅ All tests pass
```

### PR Checklist

- [ ] Branch updated from main
- [ ] All checks passing
- [ ] Tests added/updated
- [ ] Documentation updated
- [ ] Follows coding guidelines
- [ ] Meaningful commit messages
- [ ] No merge conflicts

---

**Thank you for contributing!** 🎉

**شكراً على مساهمتك!** 🎉

---

**Last Updated**: 2026-03-22
**Version**: 1.0
