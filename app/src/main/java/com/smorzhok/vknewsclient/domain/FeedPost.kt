package com.smorzhok.vknewsclient.domain

import com.smorzhok.vknewsclient.R

data class FeedPost(
    val id:Int = 0,
    val communityName: String = "/dev/null",
    val publicationTime: String = "14:00",
    val communityImage: Int = R.drawable.ic_launcher_background,
    val postText: String = "Кабаныч, когда узнал, что если сотрудникам не платить они начинают умирать от голода",
    val postImage: Int = R.drawable.ic_launcher_background,
    val statistics: List<StatisticItem> = listOf<StatisticItem>(
        StatisticItem(StatisticType.VIEWS, 966),
        StatisticItem(StatisticType.REPOSTS, 7),
        StatisticItem(StatisticType.LIKES, 8),
        StatisticItem(StatisticType.COMMENTS, 27),
    )
)