package com.exfarnanda1945.bottomnavigationcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Route(
    val routeId:String,
    val title:String,
    val icon:ImageVector
){
    object Home: Route("home","Home", Icons.Default.Home)
    object Post: Route("post","Post", Icons.Default.AddCircle)
    object Account: Route("account","Account", Icons.Default.AccountCircle)
}
