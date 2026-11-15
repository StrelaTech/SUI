import { Button } from "@/components/Button";
import { Checkbox } from "@/components/Checkbox";
import { Input } from "@/components/Input";

type ThemeName = "light" | "dark";

const swatches = [
  "background",
  "surface-container",
  "primary",
  "primary-container",
  "error",
  "warning",
] as const;

function SearchIcon() {
  return (
    <svg
      width="16"
      height="16"
      viewBox="0 0 24 24"
      fill="none"
      stroke="currentColor"
      strokeWidth="2.5"
      strokeLinecap="round"
      aria-hidden="true"
    >
      <circle cx="11" cy="11" r="7" />
      <path d="M16.5 16.5 21 21" />
    </svg>
  );
}

function ThemePanel({ theme }: { theme: ThemeName }) {
  return (
    <section
      className="panel"
      data-theme={theme}
      aria-label={`${theme} theme preview`}
    >
      <header className="panelHeader">
        <h2 className="panelTitle">{theme === "dark" ? "Dark" : "Light"}</h2>
        <p className="panelMeta">data-theme=&quot;{theme}&quot;</p>
      </header>

      <div className="section">
        <p className="sectionLabel">Buttons</p>
        <div className="row">
          <Button>Primary</Button>
          <Button variant="secondary">Secondary</Button>
          <Button disabled>Disabled</Button>
        </div>
      </div>

      <div className="section">
        <p className="sectionLabel">Inputs</p>
        <div className="card">
          <Input placeholder="Your name" aria-label="Your name" />
          <Input
            placeholder="Search"
            aria-label="Search"
            leadingIcon={<SearchIcon />}
          />
        </div>
      </div>

      <div className="section">
        <p className="sectionLabel">Checkboxes</p>
        <div className="card">
          <Checkbox
            id={`${theme}-terms`}
            defaultChecked
            label="I agree to the terms"
          />
          <Checkbox id={`${theme}-wifi`} label="Wi-Fi only" />
        </div>
      </div>

      <div className="section">
        <p className="sectionLabel">Semantic colours</p>
        <div className="row">
          {swatches.map((name) => (
            <span key={name} className="badge">
              <span
                aria-hidden="true"
                style={{
                  display: "inline-block",
                  width: 10,
                  height: 10,
                  marginRight: 6,
                  borderRadius: 999,
                  border: "1px solid rgba(127,127,127,.35)",
                  background: `var(--sui-color-${name})`,
                }}
              />
              {name}
            </span>
          ))}
        </div>
      </div>
    </section>
  );
}

export default function Page() {
  return (
    <main className="page">
      <header className="hero">
        <div>
          <p className="eyebrow">Strela UI · Design Kit</p>
          <h1 className="title">One set of tokens. Every platform.</h1>
          <p className="subtitle">
            SUI is a cross-platform design system for Compose Multiplatform
            (Android, JVM, Kotlin/JS) and React. Colours, typography, spacing and
            radii are generated from a single <code>tokens.json</code>, so the
            native and web implementations never drift apart.
          </p>
        </div>
        <div className="stack">
          <span className="badge badgeAccent">Compose Multiplatform</span>
          <span className="badge">React 19</span>
          <span className="badge">Next.js · static export</span>
          <span className="badge">SSR / SSG ready</span>
        </div>
      </header>

      <div className="themes">
        <ThemePanel theme="light" />
        <ThemePanel theme="dark" />
      </div>

      <footer className="footer">
        This page is pre-rendered at build time. Run{" "}
        <code>./gradlew :demo:run</code> for the Compose desktop demo, or{" "}
        <code>npm run dev</code> in <code>web/</code> for the React one. Source:{" "}
        <a href="https://github.com/StrelaTech/SUI">github.com/StrelaTech/SUI</a>
        .
      </footer>
    </main>
  );
}
