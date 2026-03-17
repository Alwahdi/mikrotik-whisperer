# Contributing to MikroTik Whisperer

Thank you for your interest in contributing! This document provides guidelines and instructions for contributing.

## Development Setup

1. Fork the repository
2. Clone your fork: `git clone https://github.com/YOUR_USERNAME/mikrotik-whisperer.git`
3. Install dependencies: `npm install`
4. Create a branch: `git checkout -b feature/your-feature`

## Code Standards

### TypeScript

- Use strict TypeScript mode
- Avoid `any` types
- Provide proper type annotations
- Use interfaces for object shapes

### React

- Use functional components with hooks
- Follow React hooks rules
- Keep components small and focused
- Use proper prop types

### Styling

- Use Tailwind CSS utility classes
- Follow the design system
- Ensure responsive design
- Support dark mode

### Naming Conventions

- **Files**: kebab-case (`user-profile.tsx`)
- **Components**: PascalCase (`UserProfile`)
- **Functions**: camelCase (`getUserData`)
- **Constants**: UPPER_SNAKE_CASE (`API_URL`)

## Commit Guidelines

Follow [Conventional Commits](https://www.conventionalcommits.org/):

```
type(scope): description

[optional body]

[optional footer]
```

### Types

- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting, etc.)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Maintenance tasks

### Examples

```
feat(auth): add social login support
fix(dashboard): resolve data loading issue
docs(readme): update installation instructions
refactor(api): improve error handling
```

## Pull Request Process

1. Update documentation if needed
2. Add tests for new features
3. Ensure all tests pass
4. Update the README if needed
5. Request review from maintainers

### PR Checklist

- [ ] Code follows project standards
- [ ] Tests added/updated
- [ ] Documentation updated
- [ ] No console errors or warnings
- [ ] Builds successfully
- [ ] Commits follow conventional format

## Testing

```bash
# Run all tests
npm test

# Run tests in watch mode
npm run test:watch

# Run tests with coverage
npm run test:coverage
```

## Questions?

- Open an issue for bugs
- Use discussions for questions
- Contact maintainers for urgent matters
