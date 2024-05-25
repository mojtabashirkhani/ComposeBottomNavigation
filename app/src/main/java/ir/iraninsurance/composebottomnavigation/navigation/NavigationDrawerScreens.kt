package ir.iraninsurance.composebottomnavigation.navigation


sealed class NavigationDrawerScreens (val route: String) {
    object Messages: NavigationDrawerScreens("messages_route")
    object Support : NavigationDrawerScreens("support_route")
    object DownloadApk : NavigationDrawerScreens("download_apk_route")
    object Logout : NavigationDrawerScreens("logout_route")
}