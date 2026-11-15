package com.strela.sui.design

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.strela.sui.SuiTheme

/** Карточка: скруглённая поверхность с внутренним отступом. */
@Composable
fun Card(
    modifier: Modifier = Modifier,
    insideMargin: PaddingValues = PaddingValues(16.dp),
    shape: Shape = RoundedCornerShape(16.dp),
    color: Color = SuiTheme.colorScheme.surfaceContainer,
    content: @Composable ColumnScope.() -> Unit,
) {
    Surface(modifier = modifier, shape = shape, color = color) {
        Column(modifier = Modifier.padding(insideMargin), content = content)
    }
}
