package com.smorzhok.vknewsclient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smorzhok.vknewsclient.domain.FeedPost
import com.smorzhok.vknewsclient.domain.PostComment
import com.smorzhok.vknewsclient.domain.StatisticItem
import com.smorzhok.vknewsclient.ui.theme.HomeScreenState

class MainViewModel : ViewModel() {

    private val commentsList = mutableListOf<PostComment>().apply {
        repeat(10) {
            add(PostComment(
                id = it
            ))
        }
    }

    private val initialList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it))
        }
    }

    private val initialState = HomeScreenState.Posts(initialList)

    private val _screenState = MutableLiveData<HomeScreenState>(initialState)
    val screenState: LiveData<HomeScreenState> get() = _screenState

    private var savedState: HomeScreenState = initialState

    fun showComment(feedPost: FeedPost){
        savedState = _screenState.value!!
        _screenState.value = HomeScreenState.Comments(feedPost = feedPost, commentsList)
    }

    fun closeComments(){
        _screenState.value = savedState
    }

    fun updateCount(item: StatisticItem, feedPost: FeedPost) {
        val currentState = screenState.value
        if (currentState !is HomeScreenState.Posts)
            return
        val oldPosts = currentState.posts.toMutableList()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.map { oldItem ->
            if (oldItem.type == item.type) {
                oldItem.copy(count = oldItem.count + 1)
            } else {
                oldItem
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)
        val newPosts = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) newFeedPost
                else it
            }
        }
        _screenState.value = HomeScreenState.Posts(newPosts)

    }

    fun delete(feedPost: FeedPost) {
        val currentState = screenState.value
        if (currentState !is HomeScreenState.Posts)
            return
        val oldFeedPostList = currentState.posts.toMutableList()
        val feedPostForDelete = oldFeedPostList.find { it.id == feedPost.id }
        oldFeedPostList.remove(feedPostForDelete)
        _screenState.value = HomeScreenState.Posts(oldFeedPostList)
    }

}