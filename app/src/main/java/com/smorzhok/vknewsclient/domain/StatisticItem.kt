package com.smorzhok.vknewsclient.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatisticItem(
    val type: StatisticType,
    val count: Int = 0
): Parcelable

enum class StatisticType {
    VIEWS, LIKES, REPOSTS, COMMENTS
}