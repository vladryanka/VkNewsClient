package com.smorzhok.vknewsclient.presentation.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smorzhok.vknewsclient.domain.FeedPost
import com.smorzhok.vknewsclient.domain.PostComment

class CommentsViewModel(feedPost: FeedPost) : ViewModel() {
    private val comments = mutableListOf<PostComment>().apply {
        repeat(10) {
            add(PostComment(it,
                commentText = "content $it"))
        }
    }

    private val _screenState = MutableLiveData<CommentsScreenState>(CommentsScreenState.Initial)
    val screenState: LiveData<CommentsScreenState> get() = _screenState

    fun loadComments(feedPost: FeedPost){
        _screenState.value = CommentsScreenState.Comments(feedPost, comments)
    }
}