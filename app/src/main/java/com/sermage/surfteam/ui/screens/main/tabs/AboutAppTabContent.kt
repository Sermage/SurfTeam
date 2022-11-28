package com.sermage.surfteam.ui.screens.main.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sermage.surfteam.R
import com.sermage.surfteam.settings.AppTheme
import com.sermage.surfteam.ui.elements.TextLink
import com.sermage.surfteam.ui.screens.main.SettingsViewModel
import com.sermage.surfteam.ui.theme.SurfTeamTheme

@Composable
fun AboutAppTabContent(
    modifier: Modifier = Modifier,
    vm: SettingsViewModel = hiltViewModel()
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(BottomStart)
                .background(color = MaterialTheme.colors.surface)
        ) {
            Text(
                text = stringResource(id = R.string.switch_to_dark_theme_text),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 20.dp, top = 24.dp)
            )
            val currentTheme = vm.themeState.collectAsState()
            Switch(
                checked = currentTheme.value == AppTheme.MODE_NIGHT,
                onCheckedChange = { isChecked ->
                    val theme = if (isChecked) AppTheme.MODE_NIGHT else AppTheme.MODE_DAY
                    vm.changeTheme(theme)
                },
                modifier = Modifier
                    .align(TopEnd)
                    .padding(20.dp)
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