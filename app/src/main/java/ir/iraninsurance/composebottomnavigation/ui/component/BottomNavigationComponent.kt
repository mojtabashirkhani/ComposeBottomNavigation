package ir.iraninsurance.composebottomnavigation.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ir.iraninsurance.composebottomnavigation.data.BottomNavigationItem
import ir.iraninsurance.composebottomnavigation.util.UiText


@Composable
fun bottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    NavigationBar(
        modifier = Modifier
            .padding(32.dp)
            .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
        ,
        containerColor = Color.White
    ) {
        BottomNavigationItem().bottomNavigationItems().forEachIndexed { _, navigationItem ->
            val isSelected = navigationItem.route == currentDestination?.route
            NavigationBarItem(
                selected = isSelected,
                label = {
                    if (isSelected)
                        Text(
                            UiText.StringResource(navigationItem.labelId).asString(),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,
                            fontSize = 10.sp
                        )
                },
                icon = {
                    Icon(
                        ImageVector.vectorResource(id = navigationItem.iconId),
                        contentDescription = UiText.StringResource(navigationItem.labelId)
                            .asString(),
                        tint = Color.Unspecified
                    )
                },
                alwaysShowLabel = false,
                onClick = {
                    navController.navigate(navigationItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = false
                    }
                }
            )
        }
    }
}

