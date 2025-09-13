package com.smorzhok.vknewsclient.ui.theme

import com.smorzhok.vknewsclient.domain.FeedPost
import com.smorzhok.vknewsclient.domain.PostComment

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) :CommentsScreenState()
}