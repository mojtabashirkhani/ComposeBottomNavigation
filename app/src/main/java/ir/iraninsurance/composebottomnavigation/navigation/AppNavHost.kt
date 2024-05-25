package ir.iraninsurance.composebottomnavigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.iraninsurance.composebottomnavigation.ui.screens.homeScreen
import ir.iraninsurance.composebottomnavigation.ui.screens.profileScreen
import ir.iraninsurance.composebottomnavigation.ui.screens.settingScreen

@Composable
fun appNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = BottomNavigationScreens.Home.route,
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
        ) {

        composable(BottomNavigationScreens.Home.route) {
             homeScreen(navController = navController)
        }

        composable(BottomNavigationScreens.Setting.route) {
            settingScreen(navController = navController)
        }

        composable(BottomNavigationScreens.Profile.route) {
            profileScreen(navController = navController)
        }

    }


}