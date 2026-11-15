package com.strela.sui.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.strela.sui.SuiTheme
import com.strela.sui.design.Button
import com.strela.sui.design.Card
import com.strela.sui.design.Checkbox
import com.strela.sui.design.CircularProgressIndicator
import com.strela.sui.design.HorizontalDivider
import com.strela.sui.design.Icon
import com.strela.sui.design.InfiniteProgressIndicator
import com.strela.sui.design.LinearProgressIndicator
import com.strela.sui.design.Switch
import com.strela.sui.design.Text
import com.strela.sui.design.TextField
import com.strela.sui.design.icons.SuiIcons
import com.strela.sui.design.SuiDialog
import com.strela.sui.kit.Badge
import com.strela.sui.kit.DropdownRow
import com.strela.sui.kit.IconTile
import com.strela.sui.kit.InlineMessage
import com.strela.sui.kit.SectionTitle
import com.strela.sui.platformName
import com.strela.sui.tokens.SuiSpacing

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "SUI Design Kit — demo",
        state = rememberWindowState(width = 1320.dp, height = 900.dp),
    ) {
        Row(Modifier.fillMaxSize()) {
            Box(Modifier.weight(1f).fillMaxHeight()) { ThemePanel(dark = false) }
            Box(Modifier.width(1.dp).fillMaxHeight().background(Color(0xFF8E8E93)))
            Box(Modifier.weight(1f).fillMaxHeight()) { ThemePanel(dark = true) }
        }
    }
}

@Composable
private fun ThemePanel(dark: Boolean) {
    SuiTheme(darkTheme = dark) {
        val colors = SuiTheme.colorScheme
        var text by remember { mutableStateOf("") }
        var search by remember { mutableStateOf("") }
        var notifications by remember { mutableStateOf(true) }
        var wifi by remember { mutableStateOf(false) }
        var accepted by remember { mutableStateOf(true) }
        var language by remember { mutableStateOf("Auto") }
        var dialogOpen by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = SuiSpacing.lg, vertical = SuiSpacing.xl),
            verticalArrangement = Arrangement.spacedBy(SuiSpacing.lg),
        ) {
            Text(
                text = "SUI Design Kit",
                style = SuiTheme.textStyles.headline1,
            )
            Text(
                text = "${if (dark) "Dark" else "Light"} theme · $platformName · Compose Multiplatform",
                style = SuiTheme.textStyles.body2,
                color = colors.onBackgroundVariant,
            )

            SectionTitle("Typography")
            Card {
                Text("Headline 1", style = SuiTheme.textStyles.headline1)
                Text("Headline 2", style = SuiTheme.textStyles.headline2)
                Text("Body 1 — the quick brown fox", style = SuiTheme.textStyles.body1)
                Text("Body 2 — the quick brown fox", style = SuiTheme.textStyles.body2)
                Text("Footnote 1", style = SuiTheme.textStyles.footnote1)
                Text("Footnote 2", style = SuiTheme.textStyles.footnote2)
            }

            SectionTitle("Buttons", icon = SuiIcons.Zap)
            Row(horizontalArrangement = Arrangement.spacedBy(SuiSpacing.sm)) {
                Button(onClick = {}) {
                    Icon(SuiIcons.Plus, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Add", style = SuiTheme.textStyles.button)
                }
                Button(onClick = {}, enabled = false) {
                    Text("Disabled", style = SuiTheme.textStyles.button)
                }
            }

            SectionTitle("Inputs")
            Card {
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = "Your name",
                )
                Spacer(Modifier.height(SuiSpacing.md))
                TextField(
                    value = search,
                    onValueChange = { search = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = "Search",
                    leadingIcon = {
                        Icon(
                            imageVector = SuiIcons.Search,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = colors.onSurfaceContainerVariant,
                        )
                    },
                )
                Spacer(Modifier.height(SuiSpacing.md))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text("Notifications", style = SuiTheme.textStyles.body1)
                    Switch(checked = notifications, onCheckedChange = { notifications = it })
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text("Wi-Fi only", style = SuiTheme.textStyles.body1)
                    Switch(checked = wifi, onCheckedChange = { wifi = it })
                }
                Spacer(Modifier.height(SuiSpacing.md))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(SuiSpacing.sm),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Checkbox(checked = accepted, onCheckedChange = { accepted = it })
                    Text("I agree to the terms", style = SuiTheme.textStyles.body2)
                }
            }

            SectionTitle("Status & badges")
            Card {
                Row(horizontalArrangement = Arrangement.spacedBy(SuiSpacing.sm)) {
                    Badge("HTTPS")
                    Badge("VLESS", color = colors.onPrimary, background = colors.primary)
                    Badge("WARN", color = colors.warning, background = colors.errorContainer)
                }
                Spacer(Modifier.height(SuiSpacing.md))
                InlineMessage(
                    text = "Connected to the nearest node",
                    icon = SuiIcons.Check,
                    color = colors.primary,
                )
                Spacer(Modifier.height(SuiSpacing.sm))
                InlineMessage(
                    text = "High latency detected",
                    icon = SuiIcons.Alert,
                    color = colors.warning,
                )
            }

            SectionTitle("Progress")
            Card {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(SuiSpacing.md),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    CircularProgressIndicator(modifier = Modifier.size(28.dp))
                    Text("Loading…", style = SuiTheme.textStyles.body2)
                }
                Spacer(Modifier.height(SuiSpacing.md))
                LinearProgressIndicator(progress = 0.65f, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(SuiSpacing.md))
                InfiniteProgressIndicator(modifier = Modifier.fillMaxWidth())
            }

            SectionTitle("Lists")
            Card(insideMargin = androidx.compose.foundation.layout.PaddingValues(0.dp)) {
                DropdownRow(
                    icon = SuiIcons.Globe,
                    title = "Language",
                    selectedLabel = language,
                    options = listOf("Auto", "English", "Русский").map { label ->
                        label to { language = label }
                    },
                )
                HorizontalDivider()
                Row(
                    modifier = Modifier.fillMaxWidth().padding(SuiSpacing.lg),
                    horizontalArrangement = Arrangement.spacedBy(SuiSpacing.md),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconTile(
                        icon = SuiIcons.Shield,
                        tint = colors.primary,
                        background = colors.primaryContainer,
                    )
                    Column(Modifier.weight(1f)) {
                        Text("Kill switch", style = SuiTheme.textStyles.headline2)
                        Text(
                            "Block traffic when the tunnel drops",
                            style = SuiTheme.textStyles.footnote2,
                            color = colors.onSurfaceContainerVariant,
                        )
                    }
                    Switch(checked = true, onCheckedChange = null)
                }
            }

            Button(onClick = { dialogOpen = true }) {
                Text("Open dialog", style = SuiTheme.textStyles.button)
            }

            Text(
                text = "Spacing: ${SuiSpacing.xs.value.toInt()} / ${SuiSpacing.sm.value.toInt()} / " +
                    "${SuiSpacing.md.value.toInt()} / ${SuiSpacing.lg.value.toInt()} / " +
                    "${SuiSpacing.xl.value.toInt()} px",
                style = SuiTheme.textStyles.footnote2,
                color = colors.onBackgroundVariant,
            )
        }

        if (dialogOpen) {
            SuiDialog(title = "SUI dialog", onDismissRequest = { dialogOpen = false }) {
                Text("Dialogs use the same semantic tokens as every other component.")
                Spacer(Modifier.height(SuiSpacing.lg))
                Button(onClick = { dialogOpen = false }) {
                    Text("Close", style = SuiTheme.textStyles.button)
                }
            }
        }
    }
}
