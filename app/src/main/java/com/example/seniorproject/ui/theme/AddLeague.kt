package com.example.seniorproject.ui.theme

import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.seniorproject.R
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun AddLeague(modifier: Modifier = Modifier) {
    var leagueName by remember { mutableStateOf("") }
    var handicapActive by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = leagueName,
            onValueChange = { leagueName = it},
            label = { Text(stringResource(R.string.league_name)) },
            modifier = Modifier.fillMaxWidth()
        )
        StartDateRow()
        WeeksRow()
        GamesPerWeekRow()
        GamesPerSeriesRow()
        HouseRow()
        HandicapRow(handicapActive = handicapActive, onHandicapActive = { handicapActive = it })
        Button(onClick = {  },
            modifier.widthIn(min = 250.dp)) {
            Text(stringResource(R.string.add))
        }
    }
}

@Composable
fun StartDateRow(modifier: Modifier = Modifier) {
    var pickedDate by remember { mutableStateOf(LocalDate.now())}

    val formattedDate by remember { derivedStateOf {
        DateTimeFormatter
            .ofPattern("MMM dd yyyy")
            .format(pickedDate)
    }}

    val dateDialogState = rememberMaterialDialogState()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.start_date))

        Button(
            onClick = {
                dateDialogState.show()
            },
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
        ) {
            Text(text = formattedDate)
        }
    }
    MaterialDialog(
        dialogState = dateDialogState,
        buttons = {
            positiveButton(text = "Ok")
            negativeButton(text = "Cancel")
        }
    ) {
        datepicker(
            initialDate = LocalDate.now(),
            title = "Pick a date"
        ) {
            pickedDate = it
        }
    }
}

@Composable
fun WeeksRow(modifier: Modifier = Modifier) {
    var numberOfWeeks by remember { mutableStateOf("")}

    Row(modifier = modifier
        .fillMaxWidth()
        .size(48.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(R.string.number_of_weeks))
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
fun GamesPerWeekRow(modifier: Modifier = Modifier) {
    var gamesPerWeek by remember { mutableStateOf("")}

    Row(modifier = modifier
        .fillMaxWidth()
        .size(48.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(R.string.games_per_week))
        EditNumberField(
            label = R.string.games_per_week,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = gamesPerWeek,
            onValueChange = { gamesPerWeek = it },
            keyboardActions = KeyboardActions(
                onNext = { }
            )
        )
    }
}

@Composable
fun GamesPerSeriesRow(modifier: Modifier = Modifier) {
    var gamesPerSeries by remember { mutableStateOf("")}

    Row(modifier = modifier
        .fillMaxWidth()
        .size(48.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(R.string.games_per_series))
        EditNumberField(
            label = R.string.games_per_series,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = gamesPerSeries,
            onValueChange = { gamesPerSeries = it },
            keyboardActions = KeyboardActions(
                onNext = { }
            )
        )
    }
}

@Composable
fun HouseRow(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
        DropdownMenuItem(
            content = { Text("Load") },
            onClick = { Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show() }
        )
        DropdownMenuItem(
            content = { Text("Save") },
            onClick = { Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show() }
        )
    }
}

@Composable
fun HandicapRow(modifier: Modifier = Modifier, handicapActive: Boolean, onHandicapActive: (Boolean) -> Unit,) {
    Row(modifier = modifier
        .fillMaxWidth()
        .size(48.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(R.string.handicap))
        Switch(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            checked = handicapActive,
            onCheckedChange = onHandicapActive,
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.DarkGray
            )
        )
        if (handicapActive) {
            BasisScoreRow()
            PercentFactorRow()
        }
    }
}

@Composable
fun BasisScoreRow(modifier: Modifier = Modifier) {
    var basisScore by remember { mutableStateOf("")}

    Row(modifier = modifier
        .fillMaxWidth()
        .size(48.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(R.string.games_per_series))
        EditNumberField(
            label = R.string.games_per_series,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = basisScore,
            onValueChange = { basisScore = it },
            keyboardActions = KeyboardActions(
                onNext = { }
            )
        )
    }
}

@Composable
fun PercentFactorRow(modifier: Modifier = Modifier) {
    var percentFactor by remember { mutableStateOf("")}

    Row(modifier = modifier
        .fillMaxWidth()
        .size(48.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(R.string.games_per_series))
        EditNumberField(
            label = R.string.games_per_series,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = percentFactor,
            onValueChange = { percentFactor = it },
            keyboardActions = KeyboardActions(
                onNext = { }
            )
        )
    }
}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    value: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(label)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions

    )
}

@Preview (showBackground = true)
@Composable
fun AddLeaguePreview(){
    AddLeague()
}