package com.example.mochi_feel.ui

import LoginView
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mochi_feel.R
import com.example.mochi_feel.model.Music
import com.example.mochi_feel.ui.screen.help.EmotionView
import com.example.mochi_feel.ui.screen.help.HelpMainView
import com.example.mochi_feel.ui.screen.help.RandomView
import com.example.mochi_feel.ui.screen.intro.ViewIntro1
import com.example.mochi_feel.ui.screen.intro.ViewIntro2
import com.example.mochi_feel.ui.screen.intro.ViewIntro3
import com.example.mochi_feel.ui.screen.journalingEntry.HomeView
import com.example.mochi_feel.ui.screen.journalingEntry.ViewEntry
import com.example.mochi_feel.ui.screen.journalingEntry.ViewEntryDetail
import com.example.mochi_feel.ui.screen.journalingEntry.ViewNewEntry
import com.example.mochi_feel.ui.screen.music.MusicView
import com.example.mochi_feel.ui.screen.music.MusicViewModel
import com.example.mochi_feel.ui.screen.settings.SettingsView
import com.example.mochi_feel.ui.screen.signUp.SignUpView
import com.example.mochi_feel.ui.screen.statisticsProfile.ViewProfile
import com.example.mochi_feel.ui.theme.CalmGreen
import com.example.mochi_feel.viewmodel.Random.RandomViewModel

enum class MochiFeel_Screen() {
    Intro1,
    Intro2,
    Intro3,
    Login,
    SignUp,
    Home,
    EntryList, //Entries
    NewEntry,
    EntryDetail,
    Music,
    Profile,
    Settings,
    HelpMain,
    Emotion,
    Random
}

sealed class BottomNavItem(var title: String, var icon: Int, var route: String) {
    object Home : BottomNavItem("Home", R.drawable.inscription, MochiFeel_Screen.Home.name)
    object Search : BottomNavItem("Search", R.drawable.baseline_search_24, MochiFeel_Screen.EntryList.name)
    object AddEntry : BottomNavItem("AddEntry", R.drawable.baseline_add_circle_24, MochiFeel_Screen.NewEntry.name)
    object Music : BottomNavItem("Music", R.drawable.music, MochiFeel_Screen.Music.name)
    object Profile : BottomNavItem("Profile", R.drawable.baseline_account_circle_24, MochiFeel_Screen.Profile.name)
}

@Composable
fun BottomNavBarMF(navController: NavController) {
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
        // https://stackoverflow.com/questions/70942583/what-is-color-of-navigationbar-in-jetpack-compose-in-material-color-scheme YAOLO KETEMU
        containerColor = CalmGreen
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = if (item.icon == R.drawable.baseline_add_circle_24) {
                            Modifier.size(48.dp)
                        } else {
                            Modifier.size(28.dp)
                        }
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                // Customize the colors
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.Transparent,
                    indicatorColor = CalmGreen // ini warna efek clickednya!
                )
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MochiFeelRoute() {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val navController = rememberNavController()

    val context = LocalContext.current
    val musicViewModel = remember { MusicViewModel() }

//    val musicViewModel: MusicViewModel by viewModels()

//    var canNavigateBack by remember { mutableStateOf(navController.previousBackStackEntry != null) }
    var canNavigateBack by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        bottomBar = {
            if (canNavigateBack) {
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
            composable(
                MochiFeel_Screen.Intro1.name,
            ) {
                musicViewModel.initializeMediaPlayer(context, Music("Mochi Memory", "Mochi Feel", R.raw.matcha_mochi_cute)) // set default music
                musicViewModel.startMusic()

                canNavigateBack = false
                ViewIntro1 { navController.navigate(MochiFeel_Screen.Intro2.name) }
            }
            composable(
                MochiFeel_Screen.Intro2.name,
            ) {
                canNavigateBack = false
                ViewIntro2 { navController.navigate(MochiFeel_Screen.Intro3.name) }
            }
            composable(
                MochiFeel_Screen.Intro3.name
            ) {
                canNavigateBack = false
                ViewIntro3(
                    { navController.navigate(MochiFeel_Screen.Login.name) },
                    { navController.navigate(MochiFeel_Screen.SignUp.name) })
            }
            // @EndJason

            // @Christian
            composable(MochiFeel_Screen.Login.name) {
                canNavigateBack = false
                LoginView(
                    navController = navController
                )
            }
            composable(MochiFeel_Screen.SignUp.name) {
                canNavigateBack = false
                SignUpView(
                    navController = navController
                )
            }
            composable(MochiFeel_Screen.Music.name) {
                canNavigateBack = true
                MusicView(
                    musicViewModel = musicViewModel
                )
            }
            // @EndChristian

            // @Samuel
            composable(MochiFeel_Screen.Home.name) {
                canNavigateBack = true
                HomeView(
                    { navController.navigate(MochiFeel_Screen.NewEntry.name) }
                )
            }
            composable(MochiFeel_Screen.Profile.name) {
                canNavigateBack = true
                ViewProfile(
                    { navController.navigate(MochiFeel_Screen.Settings.name) })
            }
            // @EndSamuel

            // @Gavin
            composable(MochiFeel_Screen.EntryList.name) {
                canNavigateBack = true
                ViewEntry(

                )
            }

            composable(MochiFeel_Screen.NewEntry.name) {
                canNavigateBack = true
                ViewNewEntry(
                    { navController.navigate(MochiFeel_Screen.Home.name) },
                    { navController.navigate(MochiFeel_Screen.HelpMain.name) },
                    { navController.navigateUp() }
                )
            }

            composable(MochiFeel_Screen.EntryDetail.name) {
                canNavigateBack = false
                ViewEntryDetail(
                    { navController.navigateUp() }
                )
            }
            // @EndGavin

            // @Karyna
            composable(MochiFeel_Screen.Settings.name) {
                canNavigateBack = false
                SettingsView(
                    { navController.navigateUp() }
                )
            }

            composable(MochiFeel_Screen.HelpMain.name) {
                canNavigateBack = false
                HelpMainView(
                    { navController.navigate(MochiFeel_Screen.Random.name) },
                    { navController.navigate(MochiFeel_Screen.Emotion.name) },
                    { navController.navigateUp() }
                )
            }
            
            composable(MochiFeel_Screen.Random.name) {
                canNavigateBack = false
                RandomView(
                    RandomViewModel(),
                    { navController.navigate(MochiFeel_Screen.NewEntry.name) },
                    { navController.navigateUp() }
                )
            }

            composable(MochiFeel_Screen.Emotion.name) {
                canNavigateBack = false
                EmotionView(
                    { navController.navigate(MochiFeel_Screen.NewEntry.name) },
                    { navController.navigateUp() }
                )
            }
            // @EndKaryna
        }
    }
}
