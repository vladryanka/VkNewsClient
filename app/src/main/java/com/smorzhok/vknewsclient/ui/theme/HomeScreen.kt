package com.smorzhok.vknewsclient.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.smorzhok.vknewsclient.MainViewModel

@Composable
fun HomeScreen(paddingValues: PaddingValues,
               viewModel: MainViewModel){
    CommentsScreen()
//    val feedPosts = viewModel.feedPosts.observeAsState(listOf())
//    LazyColumn(
//        contentPadding = PaddingValues(
//            top = 16.dp,
//            start = 8.dp,
//            end = 8.dp,
//            bottom = paddingValues.calculateBottomPadding()
//        ),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(items = feedPosts.value, key = { it.id }) { feedPost ->
//            val dismissThresholds = with(receiver = LocalDensity.current) {
//                LocalConfiguration.current.screenWidthDp.dp.toPx() * 0.30f
//            }
//
//            val state = rememberSwipeToDismissBoxState(
//                positionalThreshold = { dismissThresholds },
//                confirmValueChange = { value ->
//                    val isDismissed = value == SwipeToDismissBoxValue.EndToStart
//                    if (isDismissed) viewModel.delete(feedPost)
//                    true
//                }
//            )
//
//
//            SwipeToDismissBox(
//                modifier = Modifier.animateItem(),
//                state = state,
//                enableDismissFromEndToStart = true,
//                enableDismissFromStartToEnd = false,
//                backgroundContent = {
//                    Box(
//                        Modifier
//                            .padding(16.dp)
//                            .background(Color.Red.copy(alpha = 0.5f))
//                            .fillMaxSize(),
//                        contentAlignment = Alignment.CenterEnd
//                    ) {
//                        Text(
//                            modifier = Modifier.padding(16.dp),
//                            text = "Swipe to delete",
//                            color = MaterialTheme.colorScheme.onPrimary,
//                            fontSize = 24.sp
//                        )
//                    }
//                },
//            ) {
//                VkNewsClientCard(
//                    feedPost = feedPost,
//                    onLikeClickListener = { statisticsItem ->
//                        viewModel.updateCount(statisticsItem, feedPost)
//                    },
//                    onCommentClickListener = { statisticsItem ->
//                        viewModel.updateCount(statisticsItem, feedPost)
//                    },
//                    onRepostClickListener = { statisticsItem ->
//                        viewModel.updateCount(statisticsItem, feedPost)
//                    },
//                    onViewsClickListener = { statisticsItem ->
//                        viewModel.updateCount(statisticsItem, feedPost)
//                    }
//                )
//            }
//        }
//    }
}