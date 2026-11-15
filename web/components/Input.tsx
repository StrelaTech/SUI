import type { InputHTMLAttributes, ReactNode } from "react";
import styles from "./Input.module.css";

export interface InputProps extends InputHTMLAttributes<HTMLInputElement> {
  leadingIcon?: ReactNode;
}

/** Single-line input that mirrors the Compose `TextField` surface. */
export function Input({ leadingIcon, className, ...props }: InputProps) {
  return (
    <label className={[styles.wrapper, className].filter(Boolean).join(" ")}>
      {leadingIcon ? <span className={styles.icon}>{leadingIcon}</span> : null}
      <input className={styles.input} {...props} />
    </label>
  );
}
