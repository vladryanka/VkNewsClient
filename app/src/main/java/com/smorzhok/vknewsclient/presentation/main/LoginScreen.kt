package com.smorzhok.vknewsclient.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.smorzhok.vknewsclient.R
import com.smorzhok.vknewsclient.ui.theme.Black500
import com.smorzhok.vknewsclient.ui.theme.DarkBlue

@Composable
fun LoginScreen(onClick: () ->Unit) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(R.drawable.vk_logo), contentDescription = null)
            Spacer(modifier = Modifier.height(100.dp))
            Button(onClick = {
                onClick()
            },
                colors = ButtonColors(
                    containerColor = DarkBlue,
                    contentColor = Color.White,
                    disabledContainerColor = DarkBlue,
                    disabledContentColor = Black500
                )){
                Text(text = "Login")
            }
        }
    }
}