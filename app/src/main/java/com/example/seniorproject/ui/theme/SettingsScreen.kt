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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seniorproject.R

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        PinsDownRow()
        DisplayScoreRow()
        ScoreModeRow()
        BackupRow()
    }
}

@Composable
fun PinsDownRow(modifier: Modifier = Modifier) {
    var numberOfWeeks by remember { mutableStateOf("") }

    Row(modifier = modifier
        .fillMaxWidth()
        .size(48.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(R.string.pins_down))
        EditNumberField(
            label = R.string.pins_down,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = numberOfWeeks,
            onValueChange = { numberOfWeeks = it },
            keyboardActions = KeyboardActions(
                onNext = { }
            )
        )
    }
}

@Composable
fun DisplayScoreRow(modifier: Modifier = Modifier) {
    var numberOfWeeks by remember { mutableStateOf("")}

    Row(modifier = modifier
        .fillMaxWidth()
        .size(48.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(R.string.display_score))
        EditNumberField(
            label = R.string.number_of_weeks,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = numberOfWeeks,
            onValueChange = { numberOfWeeks = it },
            keyboardActions = KeyboardActions(
                onNext = { }
            )
        )
    }
}

@Composable
fun ScoreModeRow(modifier: Modifier = Modifier) {
    var numberOfWeeks by remember { mutableStateOf("")}

    Row(modifier = modifier
        .fillMaxWidth()
        .size(48.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(R.string.score_mode))
        EditNumberField(
            label = R.string.number_of_weeks,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = numberOfWeeks,
            onValueChange = { numberOfWeeks = it },
            keyboardActions = KeyboardActions(
                onNext = { }
            )
        )
    }
}

@Composable
fun BackupRow(modifier: Modifier = Modifier) {
    var numberOfWeeks by remember { mutableStateOf("")}

    Row(modifier = modifier
        .fillMaxWidth()
        .size(48.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(R.string.backup))
        EditNumberField(
            label = R.string.number_of_weeks,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = numberOfWeeks,
            onValueChange = { numberOfWeeks = it },
            keyboardActions = KeyboardActions(
                onNext = { }
            )
        )
    }
}

@Preview
@Composable
fun SettingsPreview(){
    SettingsScreen()
}