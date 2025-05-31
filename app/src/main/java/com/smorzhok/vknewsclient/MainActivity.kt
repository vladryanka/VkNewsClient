package com.smorzhok.vknewsclient

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.smorzhok.vknewsclient.ui.theme.MainScreen
import com.smorzhok.vknewsclient.ui.theme.VkNewsClientTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
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