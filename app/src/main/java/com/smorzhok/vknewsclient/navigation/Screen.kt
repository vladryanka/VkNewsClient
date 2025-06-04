package com.smorzhok.vknewsclient.navigation

sealed class Screen(val route: String) {
     object NewsFeed: Screen(ROUTE_NEWS_FEED)
     object Favourite: Screen(ROUTE_FAVOURITE)
     object Profile: Screen(ROUTE_PROFILE)

    private companion object{
        const val ROUTE_NEWS_FEED = "NewsFeed"
        const val ROUTE_FAVOURITE = "Favourite"
        const val ROUTE_PROFILE = "Profile"
    }
}