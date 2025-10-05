package com.smorzhok.vknewsclient

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.smorzhok.vknewsclient.ui.theme.ActivityResultScreen
import com.smorzhok.vknewsclient.ui.theme.VkNewsClientTheme
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkNewsClientTheme {

                val launcher = rememberLauncherForActivityResult(contract = VK.getVKAuthActivityResultContract()) {
                    when (it) {
                        is VKAuthenticationResult.Success -> {
                            Log.d("Doing", "Success")
                        }

                        is VKAuthenticationResult.Failed -> {
                            Log.d("Doing", "Failed")
                        }
                    }
                }


                launcher.launch(listOf<VKScope>(VKScope.WALL))
                ActivityResultScreen()
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