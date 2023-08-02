package com.exfarnanda1945.bottomnavigationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.exfarnanda1945.bottomnavigationcompose.screens.AccountScreen
import com.exfarnanda1945.bottomnavigationcompose.screens.HomeScreen
import com.exfarnanda1945.bottomnavigationcompose.screens.PostScreen

@Composable
fun BottomNavigationNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Route.Home.routeId){
        composable(Route.Home.routeId){
            HomeScreen()
        }
        composable(Route.Post.routeId){
            PostScreen()
        }
        composable(Route.Account.routeId){
            AccountScreen()
        }
    }

}