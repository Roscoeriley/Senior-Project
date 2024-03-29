package com.example.seniorproject

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.seniorproject.data.games
import com.example.seniorproject.data.practiceContentList
import com.example.seniorproject.data.professionalContentList
import com.example.seniorproject.ui.theme.*

enum class BowlingAppScreen(@StringRes val title: Int) {
    Login(title = R.string.login),
    Main(title = R.string.app_name),
    Professional(title = R.string.professional),
    Practice(title = R.string.practice),
    Statistics(title = R.string.statistics),
    Settings(title = R.string.settings),
    Tips(title = R.string.tips),
    Help(title = R.string.help),
    AddLeague(title = R.string.add_league),
    AddTournament(title = R.string.add_tournament),
    AddGame(title = R.string.add_game),
    LeagueInfo(title = R.string.league_info)
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@Composable
fun BowlingAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    showAddIcon: Boolean,
    onAddClicked: () -> Unit,
    selectedOption: String, // Add the selectedOption parameter
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreenTitle)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        actions = {
            if (showAddIcon) {
                IconButton(onClick = onAddClicked) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = null)
                }
            }

        }
    )
}

@Composable
fun BowlingApp(modifier: Modifier = Modifier) {
    // Create NavController
    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = BowlingAppScreen.valueOf(
        backStackEntry?.destination?.route ?: BowlingAppScreen.Login.name
    )

    var selectedOption by remember { mutableStateOf("Leagues") }

    /*    // Create ViewModel
        val viewModel: OrderViewModel = viewModel()*/

    Scaffold(
        topBar = {
            BowlingAppBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                showAddIcon = currentScreen == BowlingAppScreen.Professional
                        || currentScreen == BowlingAppScreen.Practice
                        || currentScreen == BowlingAppScreen.LeagueInfo,
                onAddClicked = {
                    if (currentScreen == BowlingAppScreen.Professional && selectedOption == "Leagues") {
                        navController.navigate(BowlingAppScreen.AddLeague.name)
                    } else if (currentScreen == BowlingAppScreen.Professional && selectedOption == "Tournaments") {
                        navController.navigate(BowlingAppScreen.AddTournament.name)
                    } else
                        navController.navigate(BowlingAppScreen.AddGame.name)
                },
                selectedOption = selectedOption
            )
        }
    ) { innerPadding ->
/*        val uiState by viewModel.uiState.collectAsState()*/

        NavHost(
            navController = navController,
            startDestination = BowlingAppScreen.Login.name,
            modifier = modifier.padding(innerPadding),
        ) {
            //starts on "Login screen"
            composable(route = BowlingAppScreen.Login.name) {
                LoginScreen(
                    onLoginButtonClicked = {
                        navController.navigate(BowlingAppScreen.Main.name)
                    })
            }
            //goes to "Main screen"
            composable(route = BowlingAppScreen.Main.name) {
                MainScreen(
                    onProfessionalButtonClicked = {
                        navController.navigate(BowlingAppScreen.Professional.name)
                    },
                    onPracticeButtonClicked = {
                        navController.navigate(BowlingAppScreen.Practice.name)
                    },
                    onStatisticsButtonClicked = {
                        navController.navigate(BowlingAppScreen.Statistics.name)
                    },
                    onSettingsButtonClicked = {
                        navController.navigate(BowlingAppScreen.Settings.name)
                    },
                    onTipsButtonClicked = {
                        navController.navigate(BowlingAppScreen.Tips.name)
                    },
                    onHelpButtonClicked = {
                        navController.navigate(BowlingAppScreen.Help.name)
                    }
                )
            }

            //goes to "Professional screen"
            composable(route = BowlingAppScreen.Professional.name) {
                ProfessionalScreen(
                    contentList = professionalContentList,
                    onOptionSelected = { option -> selectedOption = option },
                    onLeagueNameClicked = {
                        navController.navigate(BowlingAppScreen.LeagueInfo.name)
                    }
                )
            }

            //goes to "Practice screen"
            composable(route = BowlingAppScreen.Practice.name) {
                PracticeScreen(contentList = practiceContentList)
            }

            //goes to "Statistics screen"
            composable(route = BowlingAppScreen.Statistics.name) {
                StatisticsScreen()
            }

            //goes to "Settings screen"
            composable(route = BowlingAppScreen.Settings.name) {
                SettingsScreen()
            }

            //goes to "Tips screen"
            composable(route = BowlingAppScreen.Tips.name) {
                TipsScreen(tips = tips)
            }

            //goes to "Help screen"
            composable(route = BowlingAppScreen.Help.name) {
                HelpScreen()
            }

            //goes to "AddLeague screen"
            composable(route = BowlingAppScreen.AddLeague.name) {
                AddLeague()
            }

            //goes to "AddTournament screen"
            composable(route = BowlingAppScreen.AddTournament.name) {
                AddTournament()
            }

            //goes to "AddGame screen"
            composable(route = BowlingAppScreen.AddGame.name) {
                AddGame()
            }

            //goes to "LeagueInfo screen"
            composable(route = BowlingAppScreen.LeagueInfo.name) {
                LeagueInfoScreen(totalScore = 0, numberOfGames = 0)
            }
        }
    }
}