package com.example.seniorproject.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seniorproject.R

@Composable
fun AddTournament(modifier: Modifier = Modifier) {
    var tournamentName by remember { mutableStateOf("") }
    var handicapActive by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = tournamentName,
            onValueChange = { tournamentName = it},
            label = { Text(stringResource(R.string.tournament_name)) },
            modifier = Modifier.fillMaxWidth()
        )
        GamesPerSeriesRow()
        HandicapRow(handicapActive = handicapActive, onHandicapActive = { handicapActive = it })
        Button(onClick = {  },
            modifier.widthIn(min = 250.dp)) {
            Text(stringResource(R.string.add))
        }
    }
}

@Preview (showBackground = true)
@Composable
fun AddTournamentPreview(){
    AddTournament()
}