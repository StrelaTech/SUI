import type { Metadata } from "next";
import "./globals.css";
import "../src/styles/tokens.css";

export const metadata: Metadata = {
  title: "SUI — Strela UI",
  description:
    "Cross-platform design kit for Compose Multiplatform and React. Semantic design tokens, accessible components, light and dark themes.",
};

export default function RootLayout({
  children,
}: Readonly<{ children: React.ReactNode }>) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}
