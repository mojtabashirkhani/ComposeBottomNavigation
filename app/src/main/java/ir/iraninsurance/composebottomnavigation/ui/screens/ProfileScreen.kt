package ir.iraninsurance.composebottomnavigation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ir.iraninsurance.composebottomnavigation.ui.component.navigationDrawer

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun profileScreen(navController: NavHostController) {
    navigationDrawer(navController)

}