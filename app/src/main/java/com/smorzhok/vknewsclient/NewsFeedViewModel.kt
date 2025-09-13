package com.smorzhok.vknewsclient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smorzhok.vknewsclient.domain.FeedPost
import com.smorzhok.vknewsclient.domain.StatisticItem
import com.smorzhok.vknewsclient.ui.theme.NewsFeedScreenState

class NewsFeedViewModel : ViewModel() {
    private val initialList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it))
        }
    }

    private val initialState = NewsFeedScreenState.Posts(initialList)

    private val _screenState = MutableLiveData<NewsFeedScreenState>(initialState)
    val screenState: LiveData<NewsFeedScreenState> get() = _screenState

    fun updateCount(item: StatisticItem, feedPost: FeedPost) {
        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts)
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
        _screenState.value = NewsFeedScreenState.Posts(newPosts)

    }

    fun delete(feedPost: FeedPost) {
        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts)
            return
        val oldFeedPostList = currentState.posts.toMutableList()
        val feedPostForDelete = oldFeedPostList.find { it.id == feedPost.id }
        oldFeedPostList.remove(feedPostForDelete)
        _screenState.value = NewsFeedScreenState.Posts(oldFeedPostList)
    }

}