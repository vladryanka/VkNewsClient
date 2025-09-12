package com.smorzhok.vknewsclient.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smorzhok.vknewsclient.domain.FeedPost
import com.smorzhok.vknewsclient.domain.PostComment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentsScreen(
    feedPost: FeedPost,
    comments: List<PostComment>,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Comments for FeedPost Id: ${feedPost.id}",
                        fontSize = 24.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackPressed()
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)

                    }
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it),
            contentPadding = PaddingValues(bottom = 72.dp)
        ) {
            items(items = comments, key = { it.id }) { comment ->
                CommentItem(comment)
            }
        }
    }
}

@Composable
private fun CommentItem(comment: PostComment) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 4.dp
            )
    ) {
        Image(
            painterResource(comment.authorAvatarId), contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
        Spacer(Modifier.width(8.dp))
        Column {
            Text(
                text = "${comment.authorName} CommentId: ${comment.id}",
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 12.sp
            )
            Text(
                text = comment.commentText,
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 14.sp
            )
            Text(
                text = comment.time,
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = 12.sp
            )
        }
    }
}