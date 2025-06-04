package com.smorzhok.vknewsclient.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.smorzhok.vknewsclient.R
import com.smorzhok.vknewsclient.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: ImageVector
) {
    object Home: NavigationItem(
        Screen.NewsFeed,
        R.string.main_screen,
        Icons.Default.Home
    )
    object Favourites: NavigationItem(
        Screen.Favourite,
        R.string.favourites,
        Icons.Default.Favorite
    )
    object Profile: NavigationItem(
        Screen.Profile,
        R.string.profile,
        Icons.Default.Person
    )
}