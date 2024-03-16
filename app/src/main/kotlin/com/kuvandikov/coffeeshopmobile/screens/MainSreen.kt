package com.kuvandikov.coffeeshopmobile.screens

import android.graphics.drawable.PaintDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kuvandikov.coffeeshopmobile.R
import com.kuvandikov.coffeeshopmobile.ui.theme.CoffeeShopMobileTheme

const val largeText = "You may need to override default insets when your screen has both Views and Compose code in the same hierarchy. In this case, you need to be explicit in which one should consume the insets, and which one should ignore them.\n" +
        "\n" +
        "For example, if your outermost layout is an Android View layout, you should consume the insets in the View system and ignore them for Compose. Alternatively, if your outermost layout is a composable, you should consume the insets in Compose, and pad the AndroidView composables accordingly."

@Composable
fun MainSreen(navController: NavController = rememberNavController()) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(Modifier.verticalScroll(rememberScrollState())) {
            Image(
                painter = painterResource(id = R.drawable.image_background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.TopCenter
            )// content
            for (i in 0..10){
                Text(text = largeText)
            }
        }

    }

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainSreenPreview() {
    CoffeeShopMobileTheme {
        MainSreen()
    }
}