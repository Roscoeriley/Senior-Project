package com.example.seniorproject.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seniorproject.data.DataSource
import com.example.seniorproject.R

@Composable
fun MainScreen(onLoginButtonClicked: () -> Unit,
               onTournamentsButtonClicked: () -> Unit,
               onLeaguesButtonClicked: () -> Unit,
               onStatisticsButtonClicked: () -> Unit,
               onSettingsButtonClicked: () -> Unit,
               onHelpButtonClicked: () -> Unit,
               modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(R.drawable.bowlero_logo),
            contentDescription = "Bowlero Logo",
            modifier = Modifier.width(300.dp))
        Spacer(Modifier.height(16.dp))
        Button(onClick = onLoginButtonClicked,
            modifier.widthIn(min = 250.dp)) {
            Text(stringResource(R.string.login))
        }
        Button(onClick = onTournamentsButtonClicked,
            modifier.widthIn(min = 250.dp)) {
            Text(stringResource(R.string.tournaments))
        }
        Button(onClick = onLeaguesButtonClicked,
            modifier.widthIn(min = 250.dp)) {
            Text(stringResource(R.string.leagues))
        }
        Button(onClick = onStatisticsButtonClicked,
            modifier.widthIn(min = 250.dp)) {
            Text(stringResource(R.string.statistics))
        }
        Button(onClick = onSettingsButtonClicked,
            modifier.widthIn(min = 250.dp)) {
            Text(stringResource(R.string.settings))
        }
        Button(onClick = onHelpButtonClicked,
            modifier.widthIn(min = 250.dp)) {
            Text(stringResource(R.string.help))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SeniorProjectTheme {
        MainScreen(
            onLoginButtonClicked = {},
            onTournamentsButtonClicked = {},
            onLeaguesButtonClicked = {},
            onStatisticsButtonClicked = {},
            onSettingsButtonClicked = {},
            onHelpButtonClicked = {})
    }
}