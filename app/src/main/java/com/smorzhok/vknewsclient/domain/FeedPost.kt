package com.smorzhok.vknewsclient.domain

import android.os.Parcelable
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.google.gson.Gson
import com.smorzhok.vknewsclient.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeedPost(
    val id: Int = 0,
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
) : Parcelable {
    companion object {
        val NavigationType: NavType<FeedPost> = object : NavType<FeedPost>(false) {
            override fun put(
                bundle: SavedState,
                key: String,
                value: FeedPost
            ) {
                bundle.putParcelable(key, value)
            }

            override fun get(
                bundle: SavedState,
                key: String
            ): FeedPost? {
                return bundle.getParcelable(key)
            }

            override fun parseValue(value: String): FeedPost {
                return Gson().fromJson(value, FeedPost::class.java)
            }
        }
    }
}