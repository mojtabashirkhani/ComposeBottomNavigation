package ir.iraninsurance.composebottomnavigation.navigation

sealed class BottomNavigationScreens (val route: String) {
    object Home : BottomNavigationScreens("home_route")
    object Setting : BottomNavigationScreens("setting_route")
    object Profile : BottomNavigationScreens("profile_route")

}
