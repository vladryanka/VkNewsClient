package com.smorzhok.vknewsclient.samples

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ActivityResultScreen(){
    var imageUri by remember{ mutableStateOf(Uri.EMPTY) }
    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { imageUri = it }

    Column (modifier = Modifier.fillMaxSize().padding(8.dp), Arrangement.Center) {
        AsyncImage(imageUri, null, modifier = Modifier.height(200.dp))
        Button(modifier = Modifier.fillMaxWidth(), onClick = {launcher.launch("image/*")}){
            Text(text = "launch")
        }

    }
}