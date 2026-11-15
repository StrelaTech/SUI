import type { NextConfig } from "next";

/**
 * Static export keeps the demo fully pre-rendered (SSG), which is what the
 * React build should ship for SEO. Remove `output: "export"` if you want to
 * deploy on a Node server with per-request SSR instead.
 */
const nextConfig: NextConfig = {
  output: "export",
  images: { unoptimized: true },
  trailingSlash: true,
};

export default nextConfig;
