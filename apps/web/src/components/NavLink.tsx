'use client'
import NextLink from "next/link";
import { usePathname } from "next/navigation";
import { forwardRef } from "react";
import { cn } from "@/lib/utils";

interface NavLinkCompatProps {
  to: string;
  className?: string;
  activeClassName?: string;
  pendingClassName?: string;
  children?: React.ReactNode;
  [key: string]: any;
}

const NavLink = forwardRef<HTMLAnchorElement, NavLinkCompatProps>(
  ({ className, activeClassName, pendingClassName, to, children, ...props }, ref) => {
    const pathname = usePathname();
    const isActive = pathname === to || pathname.startsWith(to + '/');

    return (
      <NextLink
        ref={ref}
        href={to}
        className={cn(className, isActive && activeClassName)}
        {...props}
      >
        {children}
      </NextLink>
    );
  },
);

NavLink.displayName = "NavLink";

export { NavLink };
