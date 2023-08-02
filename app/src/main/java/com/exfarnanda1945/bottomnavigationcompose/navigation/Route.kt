package com.exfarnanda1945.bottomnavigationcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Route(
    val routeId: String,
    val title: String,
    val icon: ImageVector,
    val iconSelected: ImageVector
) {
    object Home : Route(
        "home",
        "Home",
        Icons.Outlined.Home,
        Icons.Default.Home)
    object Post : Route(
        "post",
        "Post",
        Icons.Outlined.Add,
        Icons.Default.AddCircle)
    object Account :
        Route(
            "account",
            "Account",
            Icons.Outlined.AccountCircle,
            Icons.Default.AccountCircle)
}
