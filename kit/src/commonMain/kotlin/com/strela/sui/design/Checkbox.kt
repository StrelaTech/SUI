package com.strela.sui.design

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.strela.sui.SuiTheme
import com.strela.sui.design.icons.SuiIcons

/**
 * Checkbox with a check mark. Checked state uses the monochrome accent;
 * the unchecked state is an outlined square.
 */
@Composable
fun Checkbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
) {
    val colors = SuiTheme.colorScheme
    val shape = RoundedCornerShape(6.dp)
    val enabled = onCheckedChange != null

    Box(
        modifier = modifier
            .size(22.dp)
            .clip(shape)
            .background(if (checked) colors.primary else colors.surfaceContainer)
            .border(
                width = 1.5.dp,
                color = if (checked) colors.primary else colors.onSurfaceContainerVariant,
                shape = shape,
            )
            .clickable(enabled = enabled) { onCheckedChange?.invoke(!checked) },
        contentAlignment = Alignment.Center,
    ) {
        if (checked) {
            Icon(
                imageVector = SuiIcons.Check,
                contentDescription = null,
                modifier = Modifier.size(15.dp),
                tint = colors.onPrimary,
            )
        }
    }
}
