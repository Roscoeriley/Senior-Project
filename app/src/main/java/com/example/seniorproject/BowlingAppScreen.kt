package com.example.seniorproject

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
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
    Start(title = R.string.app_name),
    Login(title = R.string.login),
    Tournaments(title = R.string.tournaments),
    Leagues(title = R.string.leagues),
    Statistics(title = R.string.statistics),
    Settings(title = R.string.settings),
    Help(title = R.string.help)
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@Composable
fun BowlingAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
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
        }
    )
}

@Composable
fun BowlingApp(modifier: Modifier = Modifier) {
    //Create NavController
    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = BowlingAppScreen.valueOf(
        backStackEntry?.destination?.route ?: BowlingAppScreen.Start.name
    )
/*    // Create ViewModel
    val viewModel: OrderViewModel = viewModel()*/

    Scaffold(
        topBar = {
            BowlingAppBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
/*        val uiState by viewModel.uiState.collectAsState()*/

        NavHost(
            navController = navController,
            startDestination = BowlingAppScreen.Start.name,
            modifier = modifier.padding(innerPadding),
        ) {

            composable(route = BowlingAppScreen.Start.name) {
                MainScreen(
                    onLoginButtonClicked = {
                        navController.navigate(BowlingAppScreen.Login.name)
                    },
                    onTournamentsButtonClicked = {
                        navController.navigate(BowlingAppScreen.Tournaments.name)
                    },
                    onLeaguesButtonClicked = {
                        navController.navigate(BowlingAppScreen.Leagues.name)
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
            //goes to "Login screen"
            composable(route = BowlingAppScreen.Login.name) {
                LoginScreen()
            }

            //goes to "Tournaments screen"
            composable(route = BowlingAppScreen.Tournaments.name) {
                TournamentsScreen()
            }

            //goes to "Leagues screen"
            composable(route = BowlingAppScreen.Leagues.name) {
                LeaguesScreen()
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
        }
    }
}