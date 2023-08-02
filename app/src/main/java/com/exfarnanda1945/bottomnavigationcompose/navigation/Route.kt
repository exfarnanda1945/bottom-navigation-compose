package com.exfarnanda1945.bottomnavigationcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.exfarnanda1945.bottomnavigationcompose.ui.theme.Aqua
import com.exfarnanda1945.bottomnavigationcompose.ui.theme.GrapeFruit
import com.exfarnanda1945.bottomnavigationcompose.ui.theme.Lavender
import com.exfarnanda1945.bottomnavigationcompose.ui.theme.Mint

sealed class Route(
    val routeId: String,
    val title: String,
    val icon: ImageVector,
    val iconSelected: ImageVector,
    val color: Color
) {
    object Home : Route(
        "home",
        "Home",
        Icons.Outlined.Home,
        Icons.Default.Home,
        Mint
    )

    object Post : Route(
        "post",
        "Post",
        Icons.Outlined.Add,
        Icons.Default.AddCircle,
        GrapeFruit
    )

    object Mail:Route(
        "mail",
        "Mail",
        Icons.Outlined.MailOutline,
        Icons.Filled.Email,
        Lavender
    )

    object Account :
        Route(
            "me",
            "Me",
            Icons.Outlined.AccountCircle,
            Icons.Default.AccountCircle,
            Aqua
        )
}
