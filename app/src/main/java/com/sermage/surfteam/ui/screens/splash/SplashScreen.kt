package com.sermage.surfteam.ui.screens.splash

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sermage.surfteam.navigation.MAIN_SCREEN_ROUTE
import com.sermage.surfteam.ui.theme.LocalDrawableResources
import com.sermage.surfteam.ui.theme.SurfTeamTheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SplashScreen(
    navController: NavController
) {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = Unit) {
        visible = true
        delay(2000L)
        visible = false
        delay(1000L)
        navController.navigate(MAIN_SCREEN_ROUTE)
    }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(
            animationSpec = tween(2000, delayMillis = 500)
        ),
        exit = ExitTransition.None
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {

            Image(
                painter = painterResource(id = LocalDrawableResources.current.splashImage),
                contentDescription = "Surf logo",
                modifier = Modifier
                    .size(width = 320.dp, height = 419.dp)
                    .animateEnterExit(
                        exit = scaleOut(
                            animationSpec = tween(1000, delayMillis = 500)
                        )
                    )
            )
            Image(
                painter = painterResource(id = LocalDrawableResources.current.androidLogo),
                contentDescription = "android logo",
                modifier = Modifier
                    .size(width = 100.dp, height = 80.dp)
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp)

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SurfTeamTheme {
        SplashScreen(rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenDarkPreview() {
    SurfTeamTheme(darkTheme = true) {
        SplashScreen(rememberNavController())
    }
}