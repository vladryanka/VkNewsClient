package com.smorzhok.vknewsclient.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.smorzhok.vknewsclient.R
import com.smorzhok.vknewsclient.domain.FeedPost
import com.smorzhok.vknewsclient.domain.StatisticItem
import com.smorzhok.vknewsclient.domain.StatisticType

@Composable
fun VkNewsClientCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onLikeClickListener: (StatisticItem) -> Unit,
    onCommentClickListener: (StatisticItem) -> Unit,
    onRepostClickListener: (StatisticItem) -> Unit,
    onViewsClickListener: (StatisticItem) -> Unit
) {

    Card(modifier = modifier) {
        PostHeader(feedPost)
        Text(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            color = MaterialTheme.colorScheme.onPrimary,
            text = stringResource(feedPost.postText)
        )
        Image(
            painter = painterResource(feedPost.postImage),
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(50.dp),
            contentScale = ContentScale.FillWidth
        )
        Statistics(
            feedPost.statistics,
            onLikeClickListener,
            onCommentClickListener,
            onRepostClickListener,
            onViewsClickListener
        )
    }
}

@Composable
fun Statistics(
    statistics: List<StatisticItem>,
    onLikeClickListener: (StatisticItem) -> Unit,
    onCommentClickListener: (StatisticItem) -> Unit,
    onRepostClickListener: (StatisticItem) -> Unit,
    onViewsClickListener: (StatisticItem) -> Unit
) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val viewsItem = statistics.getItemByType(StatisticType.VIEWS)
        IconWithText(icon = R.drawable.ic_eye, viewsItem.count, { onViewsClickListener(viewsItem) })

        Spacer(modifier = Modifier.weight(1f))

        val repostsItem = statistics.getItemByType(StatisticType.REPOSTS)
        IconWithText(
            icon = R.drawable.ic_arrow_outward,
            repostsItem.count,
            { onRepostClickListener(repostsItem) })

        val commentsItem = statistics.getItemByType(StatisticType.COMMENTS)
        IconWithText(
            icon = R.drawable.comment,
            commentsItem.count,
            { onCommentClickListener(commentsItem) })

        val likesItem = statistics.getItemByType(StatisticType.LIKES)
        IconWithText(
            icon = R.drawable.favorite,
            likesItem.count,
            { onLikeClickListener(likesItem) })
    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { it.type == type } ?: throw IllegalStateException("Type is not found")
}

@Composable
private fun IconWithText(icon: Int, text: Int, onClickListener: () -> Unit) {
    Row(modifier = Modifier.clickable {
        onClickListener()
    }) {
        Icon(
            painterResource(icon), contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = text.toString(), color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun PostHeader(feedPost: FeedPost) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(feedPost.communityImage),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = feedPost.commutityName, color = MaterialTheme.colorScheme.onPrimary)
            Text(text = "14:00", color = MaterialTheme.colorScheme.onSecondary)
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}


