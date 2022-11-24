package com.sermage.surfteam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sermage.surfteam.R
import com.sermage.surfteam.navigation.MAIN_SCREEN_ROUTE
import com.sermage.surfteam.ui.theme.SurfTeamTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    LaunchedEffect(key1 = Unit) {
        delay(2000L)
        navController.navigate(MAIN_SCREEN_ROUTE)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_image),
            contentDescription = "Surf logo",
            modifier = Modifier.size(width = 320.dp, height = 419.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "android logo",
            modifier = Modifier
                .size(width = 100.dp, height = 80.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
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