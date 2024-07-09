package com.example.wb_homework.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wb_homework.R
import com.example.wb_homework.navigation.AppNavGraph
import com.example.wb_homework.navigation.Screen
import com.example.wb_homework.navigation.rememberNavigationState
import com.example.wb_homework.navigation.NavigationItem
import com.example.wb_homework.ui.theme.TextColor
import com.example.wb_homework.ui.ui_kit.BodyText1
import com.example.wb_homework.ui.custom_phone_field.CustomPhoneField


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()

    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
            ) {
                val items = listOf(
                    NavigationItem.Meet,
                    NavigationItem.Community,
                    NavigationItem.More
                )
                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                items.forEach { item ->
                    val selected = navBackStackEntry?.destination?.hierarchy?.any {
                        it.route == item.screen.route
                    } ?: false
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            if (!selected) {
                                navigationState.navigateTo(item.screen.route)
                            }
                        },
                        label = { },
                        icon = {
                            if (!selected) {
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
    ) {
        AppNavGraph(
            navHostController = navigationState.navHostController,
            eventsScreenContent = {
                AllEventsScreen(
                    onAddPressed = {},
                    onEventCardClickListener = {
                        navigationState.navHostController.navigate(
                            Screen.DetailEventFromEventScreen.route
                        )
                    }
                )
            },
            detailEventFromEventScreenContent = {
                EventDetailsScreen(
                    onBackPressedClickListener = {
                        navigationState.navHostController.popBackStack()
                    }
                )
            },

            detailEventFromCommunityScreenContent = {
                EventDetailsScreen(
                    onBackPressedClickListener = {
                        navigationState.navHostController.popBackStack()
                    }
                )
            },

            detailEventFromMoreScreenContent = {
                EventDetailsScreen(
                    onBackPressedClickListener = {
                        navigationState.navHostController.popBackStack()
                    }
                )
            },

            detailCommunityScreenContent = {
                CommunityDetailsScreen(
                    onBackPressedClickListener = {
                        navigationState.navHostController.popBackStack()
                    },
                    onEventCardClickListener = {
                        navigationState.navHostController.navigate(
                            Screen.DetailEventFromCommunityScreen.route
                        )
                    }
                )
            },
            communityScreenContent = {
                CommunityScreen(
                    onClickCommunityCardListener = {
                        navigationState.navHostController.navigate(
                            Screen.DetailCommunity.route
                        )
                    }
                )
            },
            moreScreenContent = {
                MoreScreen(
                    onProfileClickListener = {
                        navigationState.navHostController.navigate(
                            Screen.Profile.route
                        )
                    },
                    onMyMeetsClickListener = {
                        navigationState.navHostController.navigate(
                            Screen.MyEvents.route
                        )
                    },
                    onThemeClickListener = {
                        navigationState.navHostController.navigate(
                            Screen.Theme.route
                        )
                    }
                )
            },
            profileEventScreenContent = {
                ProfileScreen(
                    onBackPressed = {
                        navigationState.navHostController.popBackStack()
                    }
                )
            },
            myEventsScreenContent = {
                MyEventsScreen(
                    onBackPressed = {
                        navigationState.navHostController.popBackStack()
                    },
                    onEventCardClickListener = {
                        navigationState.navHostController.navigate(
                            Screen.DetailEventFromMoreScreen.route
                        )
                    },

                    )
            },
            themeScreenContent = {
                CustomUI()
            }

        )
    }
}
