package com.smorzhok.vknewsclient

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.smorzhok.vknewsclient.ui.theme.VkNewsClientTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkNewsClientTheme {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Test() {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Simple TopAppBar") },
            navigationIcon = { Icon(Icons.Filled.Menu, contentDescription = null) },
            actions = {Icon(Icons.Default.Close, contentDescription = null)}
        )
    },
        bottomBar = {
            BottomAppBar(contentColor = Color.Black) {
                Icon(Icons.Filled.Favorite, contentDescription = null)
            }
        }) {
        Text(text = "jjj", Modifier.padding(it))
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VkNewsClientTheme {
        Test()
    }
}