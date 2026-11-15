package com.strela.sui.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Design tokens for SUI.
 *
 * Values are generated from `tokens/tokens.json` into [GeneratedColorTokens] and
 * friends. Edit the JSON and run `node scripts/generate-tokens.mjs` instead of
 * changing the generated file. The same JSON produces `web/src/styles/tokens.css`
 * and `web/src/generated/tokens.ts`, so Compose and React stay in sync.
 */

/** Semantic colour palette. Text colour is not baked into typography. */
@Immutable
data class SuiColorScheme(
    val background: Color,
    val onBackground: Color,
    val onBackgroundVariant: Color,
    val surfaceContainer: Color,
    val surfaceContainerHigh: Color,
    val onSurfaceContainer: Color,
    val onSurfaceContainerVariant: Color,
    val onSurfaceVariantSummary: Color,
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val secondary: Color,
    val onSecondary: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,
    val error: Color,
    val errorContainer: Color,
    /** Amber accent used for warnings. */
    val warning: Color,
    val disabledPrimary: Color,
    val disabledOnPrimary: Color,
    val disabledPrimaryButton: Color,
    val disabledOnPrimaryButton: Color,
    val dividerLine: Color,
    val switchTrackUnchecked: Color,
    val switchThumbUnchecked: Color,
    val pressedOverlay: Color,
)

/** Type scale. Colour comes from the surrounding content colour. */
@Immutable
data class SuiTextStyles(
    val headline1: TextStyle,
    val headline2: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val footnote1: TextStyle,
    val footnote2: TextStyle,
    val button: TextStyle,
)

/** 4-based spacing scale. */
object SuiSpacing {
    val xs: Dp = GeneratedSpacingTokens.xs.dp
    val sm: Dp = GeneratedSpacingTokens.sm.dp
    val md: Dp = GeneratedSpacingTokens.md.dp
    val lg: Dp = GeneratedSpacingTokens.lg.dp
    val xl: Dp = GeneratedSpacingTokens.xl.dp
    val xxl: Dp = GeneratedSpacingTokens.xxl.dp
    val xxxl: Dp = GeneratedSpacingTokens.xxxl.dp
    val huge: Dp = GeneratedSpacingTokens.huge.dp
}

/** Corner radius scale. */
object SuiRadius {
    val sm: Dp = GeneratedRadiusTokens.sm.dp
    val md: Dp = GeneratedRadiusTokens.md.dp
    val lg: Dp = GeneratedRadiusTokens.lg.dp
    val xl: Dp = GeneratedRadiusTokens.xl.dp
    val pill: Dp = GeneratedRadiusTokens.pill.dp
}

private val lightColorScheme = SuiColorScheme(
    background = Color(GeneratedColorTokens.lightBackground),
    onBackground = Color(GeneratedColorTokens.lightOnBackground),
    onBackgroundVariant = Color(GeneratedColorTokens.lightOnBackgroundVariant),
    surfaceContainer = Color(GeneratedColorTokens.lightSurfaceContainer),
    surfaceContainerHigh = Color(GeneratedColorTokens.lightSurfaceContainerHigh),
    onSurfaceContainer = Color(GeneratedColorTokens.lightOnSurfaceContainer),
    onSurfaceContainerVariant = Color(GeneratedColorTokens.lightOnSurfaceContainerVariant),
    onSurfaceVariantSummary = Color(GeneratedColorTokens.lightOnSurfaceVariantSummary),
    primary = Color(GeneratedColorTokens.lightPrimary),
    onPrimary = Color(GeneratedColorTokens.lightOnPrimary),
    primaryContainer = Color(GeneratedColorTokens.lightPrimaryContainer),
    onPrimaryContainer = Color(GeneratedColorTokens.lightOnPrimaryContainer),
    secondary = Color(GeneratedColorTokens.lightSecondary),
    onSecondary = Color(GeneratedColorTokens.lightOnSecondary),
    secondaryContainer = Color(GeneratedColorTokens.lightSecondaryContainer),
    onSecondaryContainer = Color(GeneratedColorTokens.lightOnSecondaryContainer),
    error = Color(GeneratedColorTokens.lightError),
    errorContainer = Color(GeneratedColorTokens.lightErrorContainer),
    warning = Color(GeneratedColorTokens.lightWarning),
    disabledPrimary = Color(GeneratedColorTokens.lightDisabledPrimary),
    disabledOnPrimary = Color(GeneratedColorTokens.lightDisabledOnPrimary),
    disabledPrimaryButton = Color(GeneratedColorTokens.lightDisabledPrimaryButton),
    disabledOnPrimaryButton = Color(GeneratedColorTokens.lightDisabledOnPrimaryButton),
    dividerLine = Color(GeneratedColorTokens.lightDividerLine),
    switchTrackUnchecked = Color(GeneratedColorTokens.lightSwitchTrackUnchecked),
    switchThumbUnchecked = Color(GeneratedColorTokens.lightSwitchThumbUnchecked),
    pressedOverlay = Color(GeneratedColorTokens.lightPressedOverlay),
)

private val darkColorScheme = SuiColorScheme(
    background = Color(GeneratedColorTokens.darkBackground),
    onBackground = Color(GeneratedColorTokens.darkOnBackground),
    onBackgroundVariant = Color(GeneratedColorTokens.darkOnBackgroundVariant),
    surfaceContainer = Color(GeneratedColorTokens.darkSurfaceContainer),
    surfaceContainerHigh = Color(GeneratedColorTokens.darkSurfaceContainerHigh),
    onSurfaceContainer = Color(GeneratedColorTokens.darkOnSurfaceContainer),
    onSurfaceContainerVariant = Color(GeneratedColorTokens.darkOnSurfaceContainerVariant),
    onSurfaceVariantSummary = Color(GeneratedColorTokens.darkOnSurfaceVariantSummary),
    primary = Color(GeneratedColorTokens.darkPrimary),
    onPrimary = Color(GeneratedColorTokens.darkOnPrimary),
    primaryContainer = Color(GeneratedColorTokens.darkPrimaryContainer),
    onPrimaryContainer = Color(GeneratedColorTokens.darkOnPrimaryContainer),
    secondary = Color(GeneratedColorTokens.darkSecondary),
    onSecondary = Color(GeneratedColorTokens.darkOnSecondary),
    secondaryContainer = Color(GeneratedColorTokens.darkSecondaryContainer),
    onSecondaryContainer = Color(GeneratedColorTokens.darkOnSecondaryContainer),
    error = Color(GeneratedColorTokens.darkError),
    errorContainer = Color(GeneratedColorTokens.darkErrorContainer),
    warning = Color(GeneratedColorTokens.darkWarning),
    disabledPrimary = Color(GeneratedColorTokens.darkDisabledPrimary),
    disabledOnPrimary = Color(GeneratedColorTokens.darkDisabledOnPrimary),
    disabledPrimaryButton = Color(GeneratedColorTokens.darkDisabledPrimaryButton),
    disabledOnPrimaryButton = Color(GeneratedColorTokens.darkDisabledOnPrimaryButton),
    dividerLine = Color(GeneratedColorTokens.darkDividerLine),
    switchTrackUnchecked = Color(GeneratedColorTokens.darkSwitchTrackUnchecked),
    switchThumbUnchecked = Color(GeneratedColorTokens.darkSwitchThumbUnchecked),
    pressedOverlay = Color(GeneratedColorTokens.darkPressedOverlay),
)

/** Applies the text scale from accessibility settings to every type style. */
internal fun suiTextStyles(scale: Float = 1f): SuiTextStyles {
    fun style(
        fontSize: Float,
        lineHeight: Float,
        fontWeight: Int,
        letterSpacing: Float,
    ) = TextStyle(
        fontSize = (fontSize * scale).sp,
        lineHeight = (lineHeight * scale).sp,
        fontWeight = FontWeight(fontWeight),
        letterSpacing = (letterSpacing * scale).sp,
    )

    return SuiTextStyles(
        headline1 = style(
            GeneratedTypographyTokens.headline1FontSize,
            GeneratedTypographyTokens.headline1LineHeight,
            GeneratedTypographyTokens.headline1FontWeight,
            GeneratedTypographyTokens.headline1LetterSpacing,
        ),
        headline2 = style(
            GeneratedTypographyTokens.headline2FontSize,
            GeneratedTypographyTokens.headline2LineHeight,
            GeneratedTypographyTokens.headline2FontWeight,
            GeneratedTypographyTokens.headline2LetterSpacing,
        ),
        body1 = style(
            GeneratedTypographyTokens.body1FontSize,
            GeneratedTypographyTokens.body1LineHeight,
            GeneratedTypographyTokens.body1FontWeight,
            GeneratedTypographyTokens.body1LetterSpacing,
        ),
        body2 = style(
            GeneratedTypographyTokens.body2FontSize,
            GeneratedTypographyTokens.body2LineHeight,
            GeneratedTypographyTokens.body2FontWeight,
            GeneratedTypographyTokens.body2LetterSpacing,
        ),
        footnote1 = style(
            GeneratedTypographyTokens.footnote1FontSize,
            GeneratedTypographyTokens.footnote1LineHeight,
            GeneratedTypographyTokens.footnote1FontWeight,
            GeneratedTypographyTokens.footnote1LetterSpacing,
        ),
        footnote2 = style(
            GeneratedTypographyTokens.footnote2FontSize,
            GeneratedTypographyTokens.footnote2LineHeight,
            GeneratedTypographyTokens.footnote2FontWeight,
            GeneratedTypographyTokens.footnote2LetterSpacing,
        ),
        button = style(
            GeneratedTypographyTokens.buttonFontSize,
            GeneratedTypographyTokens.buttonLineHeight,
            GeneratedTypographyTokens.buttonFontWeight,
            GeneratedTypographyTokens.buttonLetterSpacing,
        ),
    )
}

/** Public entry point for token values. */
object SuiTokens {
    val lightColors: SuiColorScheme get() = lightColorScheme
    val darkColors: SuiColorScheme get() = darkColorScheme

    fun colors(darkTheme: Boolean): SuiColorScheme = if (darkTheme) darkColorScheme else lightColorScheme

    fun textStyles(fontScale: Float = 1f): SuiTextStyles = suiTextStyles(fontScale)

    val spacing: SuiSpacing get() = SuiSpacing
    val radius: SuiRadius get() = SuiRadius
}
