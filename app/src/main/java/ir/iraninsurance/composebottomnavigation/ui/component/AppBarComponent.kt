package ir.iraninsurance.composebottomnavigation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import ir.iraninsurance.composebottomnavigation.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun appBar(scope: CoroutineScope, navigationState: DrawerState) {
    CenterAlignedTopAppBar(
        title = {
          Text(text = "Bottom Navigation Template")
        },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    navigationState.open()
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = colorResource(
                        id = R.color.purple_700
                    )
                )
            }
        },
    )
}