package com.example.wb_homework.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wb_homework.HomeWork2
import com.example.wb_homework.R
import com.example.wb_homework.domain.Profile
import com.example.wb_homework.more_screen_states.MoreScreenState
import com.example.wb_homework.navigation.AppNavGraph
import com.example.wb_homework.navigation.rememberNavigationState
import com.example.wb_homework.ui.theme.NavigationItem
import com.example.wb_homework.ui.theme.TextColor
import com.example.wb_homework.ui.theme.ui_kit.BodyText1


@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()

    val moreScreenState: MutableState<MoreScreenState> =  remember {
        mutableStateOf(MoreScreenState.Initial)
    }

    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                val items = listOf(
                    NavigationItem.Meet,
                    NavigationItem.Community,
                    NavigationItem.More
                )
                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                val currentRout = navBackStackEntry?.destination?.route
                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRout == item.screen.route,
                        onClick = { navigationState.navigateTo(item.screen.route) },
                        label = { },
                        icon = {
                            if (currentRout != item.screen.route) {
                                Icon(
                                    painter = painterResource(id = item.image),
                                    contentDescription = "",
                                    modifier = Modifier.size(32.dp)
                                )
                            } else {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    BodyText1(text = stringResource(id = item.titleResId))
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Icon(
                                        painter = painterResource(id = R.drawable.point_icon),
                                        contentDescription = "",
                                    )
                                }
                            }

                        },
                        colors = NavigationBarItemColors(
                            selectedIconColor = TextColor,
                            selectedTextColor = TextColor,
                            selectedIndicatorColor = Color.White,
                            unselectedIconColor = TextColor,
                            unselectedTextColor = TextColor,
                            disabledIconColor = TextColor,
                            disabledTextColor = TextColor
                        ),
                    )

                }
            }
        }
    ) { padding ->
        AppNavGraph(
            navHostController = navigationState.navHostController,
            meetScreenContent = {
                AllMeetsScreen(onBackPressed = {})
            },
            communityScreenContent = {
                HomeWork2(modifier = Modifier.padding(padding))
            },
            moreScreenContent = {
                when (moreScreenState.value) {
                    MoreScreenState.Initial -> {
                        MoreScreen(onProfileClickListener = {
                            moreScreenState.value = MoreScreenState.Profile
                        }, onMyMeetsClickListener = {
                            moreScreenState.value = MoreScreenState.Meets
                        })
                    }
                    MoreScreenState.Profile -> {
                        ProfileScreen(onBackPressed = { moreScreenState.value = MoreScreenState.Initial})
                    }
                    else -> {
                        MyMeetsScreen(onBackPressed = {moreScreenState.value = MoreScreenState.Initial})
                    }
                }

            })
    }
}