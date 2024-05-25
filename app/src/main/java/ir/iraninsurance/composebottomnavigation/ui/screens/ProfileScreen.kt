package ir.iraninsurance.composebottomnavigation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ir.iraninsurance.composebottomnavigation.ui.component.navigationDrawer

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun profileScreen(navController: NavHostController) {
    navigationDrawer(navController)

}

@Composable
fun profileScreenContents(padding: PaddingValues, navController: NavHostController) {
    Column(modifier = Modifier.padding(padding)) {
        Text(
            modifier = Modifier.padding(16.dp, 0.dp),
            text = "Profile Screen",
        )

    }
}