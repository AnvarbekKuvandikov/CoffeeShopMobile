package com.kuvandikov.coffeeshopmobile.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBarDefaults.windowInsets
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kuvandikov.coffeeshopmobile.R
import com.kuvandikov.coffeeshopmobile.graphs.BottomBarScreen
import com.kuvandikov.coffeeshopmobile.graphs.MainNavGraph
import com.kuvandikov.coffeeshopmobile.ui.theme.CoffeeShopMobileTheme

const val largeText =
    "You may need to override default insets when your screen has both Views and Compose code in the same hierarchy. In this case, you need to be explicit in which one should consume the insets, and which one should ignore them.\n" +
            "\n" +
            "For example, if your outermost layout is an Android View layout, you should consume the insets in the View system and ignore them for Compose. Alternatively, if your outermost layout is a composable, you should consume the insets in Compose, and pad the AndroidView composables accordingly."

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainSreen(navController: NavHostController = rememberNavController()) {

    Scaffold(
        topBar = {},
        bottomBar = { Bottombar(navController) }
    ) { padding ->
        var modifier = Modifier.padding(padding)
        MainNavGraph(navController = navController)
    }

}

@Composable
fun Bottombar(navController: NavHostController) {

    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Heart,
        BottomBarScreen.Bag,
        BottomBarScreen.Notification,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    val bottombarDestination = screens.any { it.route == currentDestination?.route }

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(
            topStart = 24.0.dp,
            topEnd = 24.0.dp,
            bottomEnd = 0.0.dp,
            bottomStart = 0.0.dp
        ),
        border = BorderStroke(1.dp, Color(0xFFF1F1F1)),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(windowInsets)
                .height(80.dp)
                .selectableGroup()
        ) {
            if (bottombarDestination) {
                screens.forEach { screen ->
                    AddItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }
            }
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    NavigationBarItem(
        icon = {
            Image(
                painterResource(screen.iconRes),
                "",
                colorFilter = if (selected) ColorFilter.tint(MaterialTheme.colorScheme.primary) else null
            )
        },
        selected = selected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainSreenPreview() {
    CoffeeShopMobileTheme {
        MainSreen()
    }
}