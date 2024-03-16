package com.kuvandikov.coffeeshopmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kuvandikov.coffeeshopmobile.ui.theme.CoffeeShopMobileTheme
import com.kuvandikov.coffeeshopmobile.ui.theme.soraFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeShopMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.image_background),
            contentDescription = null,
            modifier = modifier.fillMaxSize(),
            alignment = Alignment.TopCenter
        )
        Column(
            modifier.fillMaxSize()
        ) {
            Spacer(
                modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
            )
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            0.0f to Color.Transparent,
                            0.3f to Color.Black,
                            1.0f to Color.Black,
                        )
                    )
                    .padding(40.dp),
                verticalArrangement = Arrangement.Bottom,
            ) {
                Text(
                    text = "Coffee so good, your taste buds will love it.",
                    style = MaterialTheme.typography.titleLarge.copy(color = Color.White, textAlign = TextAlign.Center),
                    modifier = modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = "The best grain, the finest roast, the powerful flavor.",
                    style = MaterialTheme.typography.labelSmall.copy(color = Color(0xFFA9A9A9), textAlign = TextAlign.Center),
                    modifier = modifier.padding(vertical = 8.dp)
                )

                Button(
                    onClick = { /*TODO*/ },
                    shape = ShapeDefaults.Medium,
                    colors = ButtonDefaults
                        .buttonColors(
                            Color(0xFFC67C4E)
                        ),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                        .height(62.dp)
                ) {
                    Text(
                        text = "Get Started",
                        style = TextStyle.Default.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoffeeShopMobileTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting("Android")
        }
    }
}