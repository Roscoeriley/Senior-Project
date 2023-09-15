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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.seniorproject.data.DataSource.mainMenuOptions
import com.example.seniorproject.ui.theme.*

enum class BowlingAppScreen(@StringRes val title: Int) {
    Login(title = R.string.login),
    Main(title = R.string.app_name),
    Professional(title = R.string.professional),
    Practice(title = R.string.practice),
    Statistics(title = R.string.statistics),
    Settings(title = R.string.settings),
    Help(title = R.string.help),
    AddLeague(title = R.string.add_league),
    AddTournament(title = R.string.add_tournament),
    AddGame(title = R.string.add_game)
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
/*    // Create ViewModel
    val viewModel: OrderViewModel = viewModel()*/

    Scaffold(
        topBar = {
            BowlingAppBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                showAddIcon = currentScreen == BowlingAppScreen.Professional || currentScreen == BowlingAppScreen.Practice,
                onAddClicked = {
                    if (currentScreen == BowlingAppScreen.Professional) {
                        navController.navigate(BowlingAppScreen.AddLeague.name)
                    } else
                        navController.navigate(BowlingAppScreen.AddTournament.name)
                }
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
                    credentials = Credentials(userName =  "", password = ""),
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
                    onHelpButtonClicked = {
                        navController.navigate(BowlingAppScreen.Help.name)
                    }
                )
            }

            //goes to "Professional screen"
            composable(route = BowlingAppScreen.Professional.name) {
                ProfessionalScreen()
            }

            //goes to "Practice screen"
            composable(route = BowlingAppScreen.Practice.name) {
                PracticeScreen()
            }

            //goes to "Statistics screen"
            composable(route = BowlingAppScreen.Statistics.name) {
                StatisticsScreen()
            }

            //goes to "Settings screen"
            composable(route = BowlingAppScreen.Settings.name) {
                SettingsScreen()
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
        }
    }
}