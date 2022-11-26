package com.sermage.surfteam.ui.screens.main.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sermage.surfteam.R
import com.sermage.surfteam.ui.elements.TextLink
import com.sermage.surfteam.ui.theme.SurfTeamTheme

@Composable
fun AboutAppTabContent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo_grey),
                contentDescription = "android logo",
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(bottom = 16.dp)
                    .size(width = 56.dp, height = 48.dp)
            )
            Text(
                text = stringResource(id = R.string.about_app_description),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 40.dp)
            )

            TextLink(
                text = stringResource(id = R.string.about_app_link_to_github_text),
                link = "https://github.com/Sermage/SurfTeam",
                modifier = Modifier
                    .padding(top = 24.dp)
                    .align(CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutAppContentPreview() {
    SurfTeamTheme {
        Surface(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            AboutAppTabContent()
        }
    }
}