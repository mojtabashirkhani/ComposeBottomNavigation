package ir.iraninsurance.composebottomnavigation.data

import androidx.annotation.DrawableRes
import ir.iraninsurance.composebottomnavigation.R
import ir.iraninsurance.composebottomnavigation.navigation.NavigationDrawerScreens


data class NavigationDrawerItem(
    val labelId: Int = -1,
    @DrawableRes val selectedIcon: Int = -1,
    @DrawableRes val unselectedIcon: Int = -1,
    val route : String = ""
) {
    fun navigationDrawerItems(): List<NavigationDrawerItem> {
        return listOf(

            NavigationDrawerItem(
                labelId = R.string.messages,
                selectedIcon = R.drawable.ic_message,
                unselectedIcon = R.drawable.ic_message,
                route = NavigationDrawerScreens.Messages.route
            ),

            NavigationDrawerItem(
                labelId = R.string.support,
                selectedIcon = R.drawable.ic_support,
                unselectedIcon = R.drawable.ic_support,
                route = NavigationDrawerScreens.Support.route
            ),
            NavigationDrawerItem(
                labelId = R.string.download_apk,
                selectedIcon = R.drawable.ic_download,
                unselectedIcon = R.drawable.ic_download,
                route = NavigationDrawerScreens.DownloadApk.route
            ),
            NavigationDrawerItem(
                labelId = R.string.logout,
                selectedIcon = R.drawable.ic_logout,
                unselectedIcon = R.drawable.ic_message,
                route = NavigationDrawerScreens.Logout.route
            ),
        )
    }

}





