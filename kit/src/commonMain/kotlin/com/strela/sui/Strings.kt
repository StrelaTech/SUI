package com.strela.sui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Text slot. SUI itself does not ship translations: an application overrides
 * [LocalStrings] inside [SuiTheme] (or provides its own wrapper) with the strings
 * it needs. Keeping this interface tiny is intentional.
 */
interface SuiStrings {
    val appName: String get() = "SUI"

    /** Default English strings, enough for an out-of-the-box demo. */
    object Default : SuiStrings
}

val LocalStrings = staticCompositionLocalOf<SuiStrings> { SuiStrings.Default }

val strings: SuiStrings
    @Composable
    @ReadOnlyComposable
    get() = LocalStrings.current
