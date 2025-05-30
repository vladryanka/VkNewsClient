package com.smorzhok.vknewsclient.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnrememberedMutableState")
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Simple TopAppBar") },
                navigationIcon = { Icon(Icons.Filled.Menu, contentDescription = null) },
                actions = { Icon(Icons.Default.Close, contentDescription = null) }
            )
        },
        bottomBar = {
            BottomAppBar(containerColor = MaterialTheme.colorScheme.surface) {
                val selectedItemPosition = remember { mutableStateOf(0) }
                val items = listOf<NavigationItem>(
                    NavigationItem.Home,
                    NavigationItem.Favourites,
                    NavigationItem.Profile
                )
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemPosition.value == index,
                        onClick = {
                            selectedItemPosition.value = index
                        },
                        icon = {
                            Icon(
                                item.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(item.titleResId)
                            )
                        }
                    )
                }
            }
        }) {
        Text(text = "jjj", Modifier.padding(it))
    }

}

