package com.smorzhok.vknewsclient.ui.theme

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smorzhok.vknewsclient.MainViewModel
import com.smorzhok.vknewsclient.domain.FeedPost

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    viewModel: MainViewModel
) {
    val screenState = viewModel.screenState.observeAsState(HomeScreenState.Initial)
    val currentState = screenState.value

    when (currentState) {
        is HomeScreenState.Posts -> {
            FeedPostsScreen(paddingValues, currentState.posts, viewModel)
        }

        is HomeScreenState.Comments -> {
            CommentsScreen(currentState.feedPost, currentState.comments, {
                viewModel.closeComments()
            })
            BackHandler {
                viewModel.closeComments()
            }
        }

        is HomeScreenState.Initial -> {}
    }

}


@Composable
fun FeedPostsScreen(
    paddingValues: PaddingValues,
    posts: List<FeedPost>,
    viewModel: MainViewModel
) {
    LazyColumn(
        contentPadding = PaddingValues(
            top = 16.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = paddingValues.calculateBottomPadding()
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = posts, key = { it.id }) { feedPost ->
            val dismissThresholds = with(receiver = LocalDensity.current) {
                LocalConfiguration.current.screenWidthDp.dp.toPx() * 0.30f
            }

            val state = rememberSwipeToDismissBoxState(
                positionalThreshold = { dismissThresholds },
                confirmValueChange = { value ->
                    val isDismissed = value == SwipeToDismissBoxValue.EndToStart
                    if (isDismissed) viewModel.delete(feedPost)
                    true
                }
            )


            SwipeToDismissBox(
                modifier = Modifier.animateItem(),
                state = state,
                enableDismissFromEndToStart = true,
                enableDismissFromStartToEnd = false,
                backgroundContent = {
                    Box(
                        Modifier
                            .padding(16.dp)
                            .background(Color.Red.copy(alpha = 0.5f))
                            .fillMaxSize(),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = "Swipe to delete",
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 24.sp
                        )
                    }
                },
            ) {
                VkNewsClientCard(
                    feedPost = feedPost,
                    onLikeClickListener = { statisticsItem ->
                        viewModel.updateCount(statisticsItem, feedPost)
                    },
                    onCommentClickListener = {
                        viewModel.showComment(feedPost)
                    },
                    onRepostClickListener = { statisticsItem ->
                        viewModel.updateCount(statisticsItem, feedPost)
                    },
                    onViewsClickListener = { statisticsItem ->
                        viewModel.updateCount(statisticsItem, feedPost)
                    }
                )
            }
        }
    }
}
