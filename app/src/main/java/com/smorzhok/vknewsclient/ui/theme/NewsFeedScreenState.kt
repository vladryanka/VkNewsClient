package com.smorzhok.vknewsclient.ui.theme

import com.smorzhok.vknewsclient.domain.FeedPost

sealed class NewsFeedScreenState {

    object Initial: NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState()

}