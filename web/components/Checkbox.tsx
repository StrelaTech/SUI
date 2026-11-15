import type { InputHTMLAttributes, ReactNode } from "react";
import styles from "./Checkbox.module.css";

export interface CheckboxProps
  extends Omit<InputHTMLAttributes<HTMLInputElement>, "type"> {
  label?: ReactNode;
}

/** Native checkbox with a token-styled box, so it stays keyboard accessible. */
export function Checkbox({ label, id, className, ...props }: CheckboxProps) {
  return (
    <label className={[styles.root, className].filter(Boolean).join(" ")}>
      <input id={id} type="checkbox" className={styles.input} {...props} />
      <span className={styles.box} aria-hidden="true" />
      {label ? <span className={styles.label}>{label}</span> : null}
    </label>
  );
}
