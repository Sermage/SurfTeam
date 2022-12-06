package com.sermage.surfteam.ui.elements.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
    iconContentDescription: String,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier = modifier
            .size(40.dp),
        contentPadding = PaddingValues(10.dp),
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            tint = MaterialTheme.colors.onSurface,
            contentDescription = iconContentDescription,
            modifier = Modifier.size(20.dp)
        )
    }
}