# Dependency audit (stage 2)

Scope: `kit/build.gradle.kts` and every `.kt` file under `kit/` in the original
OneBox repository. No other modules were scanned.

## Found dependencies

| File | Import / dependency | What it does |
| --- | --- | --- |
| `kit/build.gradle.kts` | `api(project(":core-i18n"))` | Exposes the OneBox i18n module to consumers of the kit because `OneBoxTheme` accepted an `AppLanguage` and provided `LocalStrings`. |
| `kit/src/main/java/com/strela/onebox/ui/OneBoxTheme.kt` | `com.strela.onebox.i18n.AppLanguage` | Language enum passed to `OneBoxTheme(language = ...)`. |
| `kit/src/main/java/com/strela/onebox/ui/OneBoxTheme.kt` | `com.strela.onebox.i18n.stringsFor` | Resolves the string bundle for the current language and provides it via `LocalStrings`. |
| `kit/src/main/java/com/strela/onebox/ui/Strings.kt` | `com.strela.onebox.i18n.OneBoxStrings` | Type of the composition-local string bundle used by UI components. |
| `kit/src/main/java/com/strela/onebox/ui/Strings.kt` | `com.strela.onebox.i18n.RuStrings` | Default Russian implementation used as the initial value of `LocalStrings`. |

No imports from `:api`, `:core-model`, `:engine`, `:vpn` (or any other OneBox
module) were present. There were also no Android-specific platform calls
(`Context`, `LocalContext`, `painterResource`, `R.drawable`) in the module.

## Resolution

| Original | Replacement in SUI |
| --- | --- |
| `api(project(":core-i18n"))` | Removed from `kit/build.gradle.kts`. |
| `AppLanguage` / `stringsFor(language)` | Removed. `SuiTheme` no longer takes a language. |
| `OneBoxStrings`, `RuStrings` | Minimal `SuiStrings` interface with a `Default` object and a `LocalStrings` slot. Apps override it with their own translations. |
| `com.strela.onebox.*` packages | Renamed to `com.strela.sui.*`. |
| Android-only module (`com.android.library`) | Kotlin Multiplatform with `android`, `jvm` and `js(IR)` targets. |

## Verification

```bash
./gradlew build
grep -R "com.strela.onebox\|project(\":core-i18n\")" kit demo
```

Both commands pass: the library builds for all targets and no OneBox imports
remain.
