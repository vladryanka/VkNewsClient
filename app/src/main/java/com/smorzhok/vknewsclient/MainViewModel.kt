package com.smorzhok.vknewsclient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smorzhok.vknewsclient.domain.FeedPost
import com.smorzhok.vknewsclient.domain.StatisticItem
import com.smorzhok.vknewsclient.ui.theme.NavigationItem

class MainViewModel : ViewModel() {

    private val initialList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it))
        }
    }

    private val _selectedNavItem = MutableLiveData<NavigationItem> (NavigationItem.Home)
    val selectedNavItem: LiveData<NavigationItem> get() = _selectedNavItem

    private val _feedPosts = MutableLiveData<List<FeedPost>>(initialList)
    val feedPosts: LiveData<List<FeedPost>> get() = _feedPosts

    fun updateCount(item: StatisticItem, feedPost: FeedPost) {
        val oldPosts = feedPosts.value?.toMutableList() ?: mutableListOf()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.map { oldItem ->
            if (oldItem.type == item.type) {
                oldItem.copy(count = oldItem.count + 1)
            } else {
                oldItem
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)
        _feedPosts.value = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) newFeedPost
                else it
            }
        }
    }

    fun changeNavItem(item: NavigationItem){
        _selectedNavItem.value = item
    }

    fun delete(feedPost: FeedPost) {
        val oldFeedPostList = feedPosts.value?.toMutableList() ?: mutableListOf()
        val feedPostForDelete = oldFeedPostList.find { it.id == feedPost.id }
        oldFeedPostList.remove(feedPostForDelete)
        _feedPosts.value = oldFeedPostList
    }

}