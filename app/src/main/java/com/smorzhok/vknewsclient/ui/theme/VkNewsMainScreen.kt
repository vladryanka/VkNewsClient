package com.smorzhok.vknewsclient.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smorzhok.vknewsclient.MainViewModel

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {

    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = MaterialTheme.colorScheme.surface) {
                val selectedItemPosition = remember { mutableIntStateOf(0) }
                val items = listOf<NavigationItem>(
                    NavigationItem.Home,
                    NavigationItem.Favourites,
                    NavigationItem.Profile
                )
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemPosition.value == index,
                        onClick = {
                            selectedItemPosition.value = index
                        },
                        icon = {
                            Icon(
                                item.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(item.titleResId)
                            )
                        }
                    )
                }
            }
        }) {
        val feedPosts = viewModel.feedPosts.observeAsState(listOf())
        LazyColumn(
            contentPadding = PaddingValues(
                top = 16.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = it.calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = feedPosts.value, key = { it.id }) { feedPost ->
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
                        onCommentClickListener = { statisticsItem ->
                            viewModel.updateCount(statisticsItem, feedPost)
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

}

