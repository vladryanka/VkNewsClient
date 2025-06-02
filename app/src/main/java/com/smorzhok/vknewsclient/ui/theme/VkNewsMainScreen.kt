package com.smorzhok.vknewsclient.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.smorzhok.vknewsclient.MainViewModel
import com.smorzhok.vknewsclient.domain.FeedPost

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
        it
        val feedPost = viewModel.feedPost.observeAsState(FeedPost())
        VkNewsClientCard(
            modifier = Modifier.padding(8.dp),
            feedPost = feedPost.value,
            onLikeClickListener = viewModel::updateCount,
            onCommentClickListener =  viewModel::updateCount,
            onRepostClickListener =  viewModel::updateCount,
            onViewsClickListener =  viewModel::updateCount,
        )

    }

}

