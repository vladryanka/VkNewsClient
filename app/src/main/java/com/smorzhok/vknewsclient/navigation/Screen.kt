package com.smorzhok.vknewsclient.navigation

import com.smorzhok.vknewsclient.domain.FeedPost

sealed class Screen(val route: String) {
    object NewsFeed : Screen(ROUTE_NEWS_FEED)
    object Favourite : Screen(ROUTE_FAVOURITE)
    object Profile : Screen(ROUTE_PROFILE)
    object Comments : Screen(ROUTE_COMMENTS) {
        private const val ROUTE_FOR_ARGS = "comments"
        fun getCommentsWithArgs(feedPost: FeedPost): String {
            return "$ROUTE_FOR_ARGS/${feedPost.id}"
        }
    }

    object Home : Screen(ROUTE_HOME)

    companion object {

        const val KEY_FEED_POST_ID = "feed_post_id"
        const val ROUTE_NEWS_FEED = "NewsFeed"
        const val ROUTE_COMMENTS = "comments/${KEY_FEED_POST_ID}"
        const val ROUTE_HOME = "home"
        const val ROUTE_FAVOURITE = "Favourite"
        const val ROUTE_PROFILE = "Profile"
    }
}