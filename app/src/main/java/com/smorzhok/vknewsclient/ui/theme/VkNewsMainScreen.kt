package com.smorzhok.vknewsclient.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.smorzhok.vknewsclient.domain.FeedPost
import com.smorzhok.vknewsclient.navigation.AppNavGraph
import com.smorzhok.vknewsclient.navigation.rememberNavigationState

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navState = rememberNavigationState()

    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = MaterialTheme.colorScheme.surface) {
                val navBackStackEntry by navState.navHostController.currentBackStackEntryAsState()

                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourites,
                    NavigationItem.Profile
                )
                items.forEach { item ->
                    val selected = navBackStackEntry?.destination?.hierarchy?.any {
                        it.route == item.screen.route
                    } ?: false
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            if (!selected)
                                navState.navigateTo(item.screen.route)
                        },
                        icon = {
                            Icon(
                                painterResource(item.icon),
                                contentDescription = null,
                                tint = Color.Black
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
        AppNavGraph(
            navState.navHostController,
            {
                HomeScreen(it, {
                    navState.navigateToComments(feedPost = FeedPost(id = it.id))
                })
            },
            commentsScreenContent = { feedPost ->
                CommentsScreen(feedPost) { navState.navHostController.popBackStack() }
            },
            profileScreenContent = { TextCounter("Profile") },
            favouriteScreenContent = { TextCounter("Favourites") },

            )
    }

}

@Composable
private fun TextCounter(name: String) {
    var count by rememberSaveable {
        mutableIntStateOf(0)
    }
    Text(
        "$name. Count: $count", modifier = Modifier
            .padding(50.dp)
            .clickable {
                count++
            }, color = Color.Black
    )
}
