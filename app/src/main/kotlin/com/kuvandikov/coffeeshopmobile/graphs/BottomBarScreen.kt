package com.kuvandikov.coffeeshopmobile.graphs

import androidx.annotation.DrawableRes
import com.kuvandikov.coffeeshopmobile.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    @DrawableRes
    val iconRes: Int
) {
    object Home : BottomBarScreen(
        route = "HOME",
        title = "HOME",
        iconRes = R.drawable.icon_home
    )

    object Heart : BottomBarScreen(
        route = "HEART",
        title = "HEART",
        iconRes = R.drawable.icon_heart
    )

    object Bag : BottomBarScreen(
        route = "BAG",
        title = "BAG",
        iconRes = R.drawable.icon_bag
    )

    object Notification : BottomBarScreen(
        route = "NOTIFICATION",
        title = "NOTIFICATION",
        iconRes = R.drawable.icon_notification
    )
}