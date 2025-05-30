package com.smorzhok.vknewsclient

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.smorzhok.vknewsclient.ui.theme.MainScreen
import com.smorzhok.vknewsclient.ui.theme.VkNewsClientTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkNewsClientTheme {
                MainScreen()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VkNewsClientTheme {
    }
}