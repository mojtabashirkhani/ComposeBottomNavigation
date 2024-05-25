package ir.iraninsurance.composebottomnavigation.ui.component

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.iraninsurance.composebottomnavigation.R
import ir.iraninsurance.composebottomnavigation.data.NavigationDrawerItem
import ir.iraninsurance.composebottomnavigation.ui.screens.homeScreenContents
import ir.iraninsurance.composebottomnavigation.util.UiText
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun navigationDrawer(navController: NavHostController) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Surface {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                val navigationState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }
                val navigationDrawerItems = NavigationDrawerItem()
                // to define navigation drawer here

                ModalNavigationDrawer(
                    drawerContent = {
                        ModalDrawerSheet {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 10.dp)
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(150.dp)
                                        .fillMaxWidth()
                                        .align(Alignment.CenterHorizontally)

                                )
                                Text(
                                    text = "Name",
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.SemiBold,
                                )
                                Text(
                                    text = "Phone",
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.SemiBold,
                                )
                                HorizontalDivider(color = Color.Gray, thickness = 1.dp)
                                navigationDrawerItems.navigationDrawerItems().forEachIndexed { index, drawerItem ->
                                    NavigationDrawerItem(
                                        colors = NavigationDrawerItemDefaults.colors(
                                            selectedContainerColor = colorResource(id = R.color.purple_700)
                                        ),
                                        label = {
                                            Text(
                                                text = UiText.StringResource(drawerItem.labelId)
                                                    .asString(),
                                                color = colorResource(id = R.color.purple_200),
                                                fontWeight = FontWeight.Normal,
                                                fontSize = 14.sp
                                            )
                                        },
                                        selected = index == selectedItemIndex,
                                        onClick = {
                                            selectedItemIndex = index
                                            scope.launch {
                                                navigationState.close()
                                            }

                                        },
                                        icon = {
                                            Icon(
                                                imageVector = if (index == selectedItemIndex) {
                                                    ImageVector.vectorResource(id = drawerItem.selectedIcon)
                                                } else ImageVector.vectorResource(id = drawerItem.unselectedIcon),
                                                contentDescription = UiText.StringResource(drawerItem.labelId)
                                                    .asString()
                                            )
                                        },
                                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                                    )

                                }


                            }

                            DrawerFooter()

                        }
                    },
                    drawerState = navigationState,
                    content = {
                        Scaffold(topBar = {
                            appBar(scope, navigationState)
                        }, bottomBar = {
                            bottomNavigationBar(navController)
                        },
                            content = { padding ->
                            homeScreenContents(padding = padding, navController)
                        })
                    }
                )
            }

        }
    }


}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun DrawerFooter(
) {
    Box(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxSize()
        ,
        contentAlignment = Alignment.BottomCenter
    ) {


        Text(
            text = "Version",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
        )
    }
}
