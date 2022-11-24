package com.sermage.surfteam.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sermage.surfteam.ui.theme.*

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    name: String,
    color: Color? = null
) {
    val backgroundAlpha = if (isSystemInDarkTheme()) 0.2f else 0.12f
    val textAlpha = if (isSystemInDarkTheme()) 0.8f else 1f
    Box(
        modifier = modifier
            .background(
                color = color?.copy(alpha = backgroundAlpha) ?: Grey.copy(alpha = backgroundAlpha),
                shape = MaterialTheme.shapes.small
            )
            .padding(end = 4.dp)
    ) {
        Text(
            text = name,
            color = color?.copy(alpha = textAlpha) ?: MaterialTheme.colors.onBackground.copy(
                alpha = textAlpha
            ),
            style = MaterialTheme.typography.body2,
            modifier = modifier
                .padding(horizontal = 8.dp, vertical = 2.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChipPreview() {
    SurfTeamTheme {
        Chip(name = "Android", color = Green)
    }
}

@Preview(showBackground = true)
@Composable
fun ChipDarkPreview() {
    SurfTeamTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.surface) {
            Chip(name = "Android")
        }
    }
}