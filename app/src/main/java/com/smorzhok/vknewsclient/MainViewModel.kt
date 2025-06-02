package com.smorzhok.vknewsclient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smorzhok.vknewsclient.domain.FeedPost
import com.smorzhok.vknewsclient.domain.StatisticItem

class MainViewModel: ViewModel() {

    private val _feedPost = MutableLiveData(FeedPost())
    val feedPost: LiveData<FeedPost> get() = _feedPost

    fun updateCount(item: StatisticItem){
        val oldStatistics = feedPost.value?.statistics ?: throw IllegalStateException()
        val newStatistics = oldStatistics.map { oldItem ->
            if (oldItem.type == item.type) {
                oldItem.copy(count = oldItem.count + 1)
            } else {
                oldItem
            }
        }
        _feedPost.value = feedPost.value?.copy(statistics = newStatistics)
    }

}