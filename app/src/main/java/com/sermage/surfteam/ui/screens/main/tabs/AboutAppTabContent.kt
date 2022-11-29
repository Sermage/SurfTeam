package com.sermage.surfteam.ui.screens.main.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
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
import com.sermage.surfteam.ui.theme.*

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
                painter = painterResource(id = LocalDrawableResources.current.androidLogoGrey),
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(BottomStart)
                .background(color = MaterialTheme.colors.surface)
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.switch_to_dark_theme_text),
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .align(CenterVertically)
                        .weight(1f)
                )
                val currentTheme = vm.themeState.collectAsState()
                Switch(
                    checked = currentTheme.value == AppTheme.MODE_NIGHT ||
                            (currentTheme.value == AppTheme.MODE_AUTO && isSystemInDarkTheme()),
                    onCheckedChange = { isChecked ->
                        val theme = if (isChecked) AppTheme.MODE_NIGHT else AppTheme.MODE_DAY
                        vm.changeTheme(theme)
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Grey,
                        checkedTrackColor = BlackPearl,
                        uncheckedThumbColor = Blue,
                        uncheckedTrackColor = Blue.copy(alpha = 0.38f)
                    ),
                    modifier = Modifier
                        .align(CenterVertically)
                )
            }
            val uriHandler = LocalUriHandler.current

            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = White
                ),
                contentPadding = PaddingValues(13.dp),
                onClick = { uriHandler.openUri("https://discord.com/channels/961903679055732766/981139239611809822") }) {
                Text(
                    text = stringResource(id = R.string.about_app_button_text),
                    style = MaterialTheme.typography.subtitle2
                )
            }
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