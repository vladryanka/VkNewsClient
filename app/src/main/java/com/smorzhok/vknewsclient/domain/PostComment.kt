package com.smorzhok.vknewsclient.domain

import com.smorzhok.vknewsclient.R

data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.comment_author_avatar,
    val commentText: String = "Long comment text",
    val time: String = "14:00"
)