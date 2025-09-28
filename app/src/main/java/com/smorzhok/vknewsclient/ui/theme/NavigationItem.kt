package com.smorzhok.vknewsclient.ui.theme

import com.smorzhok.vknewsclient.R
import com.smorzhok.vknewsclient.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: Int
) {
    object Home: NavigationItem(
        Screen.NewsFeed,
        R.string.main_screen,
        R.drawable.home
    )
    object Favourites: NavigationItem(
        Screen.Favourite,
        R.string.favourites,
        R.drawable.favorite
    )
    object Profile: NavigationItem(
        Screen.Profile,
        R.string.profile,
        R.drawable.person
    )
}