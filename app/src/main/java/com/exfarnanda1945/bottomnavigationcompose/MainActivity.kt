package com.exfarnanda1945.bottomnavigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.exfarnanda1945.bottomnavigationcompose.navigation.BottomNavigationNavGraph
import com.exfarnanda1945.bottomnavigationcompose.navigation.Route
import com.exfarnanda1945.bottomnavigationcompose.ui.theme.BottomNavigationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navHostController = navController)
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            BottomNavigationNavGraph(navHostController = navController)
        }
    }
}

@Composable
fun BottomBar(navHostController: NavHostController) {
    val listOfScreen = listOf(
        Route.Home,
        Route.Post,
        Route.Account,
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(Modifier.clip(shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp))) {
        listOfScreen.forEach {
            AddBottomBarItem(
                route = it,
                currentDestination = currentDestination,
                navHostController = navHostController
            )
        }
    }
}

@Composable
fun RowScope.AddBottomBarItem(
    route: Route,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = route.title)
        },
        icon = {
            Icon(imageVector = route.icon, contentDescription = route.title)
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == route.routeId
        } == true,
        onClick = {
            navHostController.navigate(route.routeId){
                popUpTo(navHostController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
    )
}