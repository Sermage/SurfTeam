package com.sermage.surfteam.ui.screens.main.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ProjectsTabContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Projects Tab",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}