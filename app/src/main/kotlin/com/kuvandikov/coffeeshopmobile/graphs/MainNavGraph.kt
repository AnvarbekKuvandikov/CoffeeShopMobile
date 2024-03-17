package com.kuvandikov.coffeeshopmobile.graphs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kuvandikov.coffeeshopmobile.R

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
        route = Graph.MAIN_SCREEN
    ) {
        composable(route = BottomBarScreen.Home.route){
            Box(modifier =Modifier.fillMaxSize() , contentAlignment = Alignment.BottomEnd) {
                Image(painter = painterResource(id = R.drawable.image_cappucino), contentDescription = "", modifier = Modifier.size(200.dp))
            }
        }
        composable(route = BottomBarScreen.Heart.route){
            Text(text = BottomBarScreen.Heart.title)
        }
        composable(route = BottomBarScreen.Bag.route){
            Text(text = BottomBarScreen.Bag.title)
        }
        composable(route = BottomBarScreen.Notification.route){
            Text(text = BottomBarScreen.Notification.title)

        }
    }
}
