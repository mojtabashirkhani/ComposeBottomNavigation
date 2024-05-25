package ir.iraninsurance.composebottomnavigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.iraninsurance.composebottomnavigation.ui.screens.homeScreen

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
             homeScreen(
                 navController
             )
        }

        composable(BottomNavigationScreens.Setting.route) {

        }
        composable(BottomNavigationScreens.Profile.route) {

        }
    }


}