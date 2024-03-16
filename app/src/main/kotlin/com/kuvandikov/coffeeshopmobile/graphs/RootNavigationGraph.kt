package com.kuvandikov.coffeeshopmobile.graphs

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kuvandikov.coffeeshopmobile.screens.MainSreen
import com.kuvandikov.coffeeshopmobile.screens.StartScreen

private const val TIME_DURATION = 300

val enterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
    slideInHorizontally(
        initialOffsetX = { it },
        animationSpec = tween(durationMillis = TIME_DURATION, easing = LinearOutSlowInEasing)
    )
}

val exitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition = {
    slideOutHorizontally(
        targetOffsetX = { -it / 3 },
        animationSpec = tween(durationMillis = TIME_DURATION, easing = LinearOutSlowInEasing)
    )
}

val popEnterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
    slideInHorizontally(
        initialOffsetX = { -it / 3 },
        animationSpec = tween(durationMillis = TIME_DURATION, easing = LinearOutSlowInEasing)
    )
}

val popExitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition = {
    slideOutHorizontally(
        targetOffsetX = { it },
        animationSpec = tween(durationMillis = TIME_DURATION, easing = LinearOutSlowInEasing)
    )
}
@Composable
fun RootNavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Graph.START_SCREEN,
        route = Graph.ROOT,
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popEnterTransition = enterTransition,
        popExitTransition = exitTransition,
    ) {
        composable(route = Graph.START_SCREEN) {
            StartScreen(navController)
        }
        composable(
            route = Graph.MAIN_SCREEN
        ) {
            Box(Modifier.safeDrawingPadding()) {
                MainSreen()
            }

        }
    }
}


object Graph {
    const val ROOT = "root_graph"
    const val START_SCREEN = "start_screen_graph"
    const val MAIN_SCREEN = "main_screen_graph"
    const val DETAILS = "details_graph"
}