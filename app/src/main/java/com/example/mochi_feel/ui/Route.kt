package com.example.mochi_feel.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mochi_feel.R
import com.example.mochi_feel.ui.theme.CalmGreen

enum class MochiFeel_Screen() {
    Intro1,
    Intro2,
    Intro3,
    Login,
    SignUp,
    Home,
    Search, //Entries
    NewEntry,
    Music,
    Profile,
}

sealed class BottomNavItem(var title:String, var icon:Int, var route:String){
    object Home : BottomNavItem("Home", R.drawable.inscription, MochiFeel_Screen.Home.name)
    object Search: BottomNavItem("Search", R.drawable.baseline_search_24, MochiFeel_Screen.Search.name)
    object AddEntry: BottomNavItem("AddEntry", R.drawable.create_entry_icon,MochiFeel_Screen.NewEntry.name)
    object Music: BottomNavItem("Music", R.drawable.music,MochiFeel_Screen.Music.name)
    object Profile: BottomNavItem("Profile", R.drawable.baseline_account_circle_24,MochiFeel_Screen.Profile.name)
}

@Composable
fun BottomNavBarMF(navController:NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.AddEntry,
        BottomNavItem.Music,
        BottomNavItem.Profile
    )

    NavigationBar(
        modifier = Modifier.background(CalmGreen)
    ){
        items.forEach{ item->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(text = item.title)
                },
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route){
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MochiFeelRoute() {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val navController = rememberNavController()
    val contextToast = LocalContext.current
    var canNavigateBack by remember { mutableStateOf(navController.previousBackStackEntry != null) }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        bottomBar = {
            if (!canNavigateBack) {
                BottomNavBarMF(navController)
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MochiFeel_Screen.Intro1.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            // @Jason
            composable(MochiFeel_Screen.Intro1.name) {

            }
            composable(MochiFeel_Screen.Intro2.name) {

            }
            composable(MochiFeel_Screen.Intro2.name) {

            }
            // @EndJason

            // @Christian
            composable(MochiFeel_Screen.Login.name) {
            }
            composable(MochiFeel_Screen.SignUp.name) {
            }
            composable(MochiFeel_Screen.Music.name) {

            }
            // @EndChristian

        }
    }
}
