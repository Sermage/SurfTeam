package com.sermage.surfteam.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sermage.surfteam.ui.screens.employee_details.EmployeeDetailsScreen
import com.sermage.surfteam.ui.screens.main.MainScreen
import com.sermage.surfteam.ui.screens.project_details.ProjectDetailsScreen
import com.sermage.surfteam.ui.screens.splash.SplashScreen

private const val SPLASH_SCREEN_ROUTE = "splash_screen"
private const val MAIN_SCREEN_ROUTE = "main_screen"

private const val EMPLOYEE_ID = "employeeId"
private const val EMPLOYEE_DETAILS_SCREEN_ROUTE = "employee_details_screen"

private const val PROJECT_ID = "projectId"
private const val PROJECT_DETAILS_SCREEN_ROUTE = "project_details_screen"


@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = SPLASH_SCREEN_ROUTE,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(SPLASH_SCREEN_ROUTE) {
            SplashScreen(navigateToMainScreen = {
                navController.navigate(MAIN_SCREEN_ROUTE) {
                    launchSingleTop = true
                    popUpTo(SPLASH_SCREEN_ROUTE) { inclusive = true }
                }
            })
        }
        composable(MAIN_SCREEN_ROUTE) {
            MainScreen(
                backClick = { navController.popBackStack() },
                onEmployeeCardClick = { employeeId ->
                    navController.navigate("$EMPLOYEE_DETAILS_SCREEN_ROUTE/$employeeId")
                },
                onProjectCardClick = { projectName ->
                    navController.navigate("$PROJECT_DETAILS_SCREEN_ROUTE/$projectName")
                }
            )
        }
        composable(
            "$EMPLOYEE_DETAILS_SCREEN_ROUTE/{$EMPLOYEE_ID}",
            arguments = listOf(navArgument(EMPLOYEE_ID) { type = NavType.StringType })
        ) {
            EmployeeDetailsScreen(
                employeeId = it.arguments?.getString(EMPLOYEE_ID) ?: "",
                backClick = { navController.popBackStack() }
            )
        }

        composable(
            route = "$PROJECT_DETAILS_SCREEN_ROUTE/{$PROJECT_ID}",
            arguments = listOf(navArgument(PROJECT_ID) { type = NavType.StringType })
        ) {
            ProjectDetailsScreen(
                projectName = it.arguments?.getString(PROJECT_ID) ?: "",
                backClick = { navController.popBackStack() }
            )
        }
    }
}