package com.strela.sui

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import com.strela.sui.design.LocalContentColor
import com.strela.sui.design.PressIndication
import com.strela.sui.tokens.SuiColorScheme
import com.strela.sui.tokens.SuiTextStyles
import com.strela.sui.tokens.SuiTokens

/**
 * Compose theme for SUI. Built on foundation + ui only; no Material dependency.
 *
 * The accent is monochrome: black on the light theme and white on the dark one.
 * Colours and typography come from [SuiTokens], which are generated from
 * `tokens/tokens.json` and shared with the React implementation.
 */

val LocalSuiColors = staticCompositionLocalOf { SuiTokens.lightColors }
val LocalSuiTextStyles = staticCompositionLocalOf { SuiTokens.textStyles() }

/** Access tokens inside composables: `SuiTheme.colorScheme` / `SuiTheme.textStyles`. */
object SuiTheme {
    val colorScheme: SuiColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalSuiColors.current

    val textStyles: SuiTextStyles
        @Composable
        @ReadOnlyComposable
        get() = LocalSuiTextStyles.current
}

@Composable
fun SuiTheme(
    darkTheme: Boolean,
    fontScale: Float = 1f,
    content: @Composable () -> Unit,
) {
    val colors = SuiTokens.colors(darkTheme)
    val indication = remember(colors) { PressIndication(colors.pressedOverlay) }
    val textStyles = remember(fontScale) { SuiTokens.textStyles(fontScale) }

    CompositionLocalProvider(
        LocalSuiColors provides colors,
        LocalSuiTextStyles provides textStyles,
        LocalContentColor provides colors.onBackground,
        LocalIndication provides indication,
        LocalStrings provides SuiStrings.Default,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.background),
        ) {
            content()
        }
    }
}
