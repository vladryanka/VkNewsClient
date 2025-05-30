package com.smorzhok.vknewsclient.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.smorzhok.vknewsclient.R

sealed class NavigationItem(
    val titleResId: Int,
    val icon: ImageVector
) {
    object Home: NavigationItem(
        R.string.main_screen,
        Icons.Default.Home
    )
    object Favourites: NavigationItem(
        R.string.favourites,
        Icons.Default.Favorite
    )
    object Profile: NavigationItem(
        R.string.profile,
        Icons.Default.Person
    )
}