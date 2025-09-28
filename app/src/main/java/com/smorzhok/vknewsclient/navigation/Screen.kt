package com.smorzhok.vknewsclient.navigation

import android.net.Uri
import com.google.gson.Gson
import com.smorzhok.vknewsclient.domain.FeedPost

sealed class Screen(val route: String) {
    object NewsFeed : Screen(ROUTE_NEWS_FEED)
    object Favourite : Screen(ROUTE_FAVOURITE)
    object Profile : Screen(ROUTE_PROFILE)
    object Comments : Screen(ROUTE_COMMENTS) {
        private const val ROUTE_FOR_ARGS = "comments"
        fun getCommentsWithArgs(feedPost: FeedPost): String {
            val feedPostJson = Gson().toJson(feedPost)
            return "$ROUTE_FOR_ARGS/${feedPostJson.encode()}"
        }
    }

    object Home : Screen(ROUTE_HOME)

    companion object {

        const val KEY_FEED_POST = "feed_post"
        const val ROUTE_NEWS_FEED = "NewsFeed"
        const val ROUTE_COMMENTS = "comments/{$KEY_FEED_POST}"
        const val ROUTE_HOME = "home"
        const val ROUTE_FAVOURITE = "Favourite"
        const val ROUTE_PROFILE = "Profile"
    }
}

fun String.encode():String{
    return Uri.encode(this)
}