package ir.iraninsurance.composebottomnavigation.data

import ir.iraninsurance.composebottomnavigation.R
import ir.iraninsurance.composebottomnavigation.navigation.BottomNavigationScreens

data class BottomNavigationItem(
    val labelId : Int = -1,
    val iconId: Int = -1,
    val route : String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                labelId = R.string.home,
                iconId = R.drawable.ic_home,
                route = BottomNavigationScreens.Home.route
            ),
            BottomNavigationItem(
                labelId = R.string.setting,
                iconId = R.drawable.ic_settings,
                route = BottomNavigationScreens.Setting.route
            ),

            BottomNavigationItem(
                labelId = R.string.profile,
                iconId = R.drawable.ic_profile,
                route = BottomNavigationScreens.Profile.route
            ),


        )
    }
}
