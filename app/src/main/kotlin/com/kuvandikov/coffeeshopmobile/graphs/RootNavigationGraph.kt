package com.kuvandikov.coffeeshopmobile.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kuvandikov.coffeeshopmobile.screens.MainSreen
import com.kuvandikov.coffeeshopmobile.screens.StartScreen


@Composable
fun RootNavigationGraph() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = Graph.START_SCREEN,
        route = Graph.ROOT
    ){
        composable(route = Graph.START_SCREEN){
            StartScreen(navController)
        }
        composable(route = Graph.MAIN_SCREEN){
            MainSreen()
        }
    }
}


object Graph{
    const val ROOT = "root_graph"
    const val START_SCREEN = "start_screen_graph"
    const val MAIN_SCREEN = "main_screen_graph"
    const val DETAILS = "details_graph"
}