package com.example.seniorproject.ui.theme

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
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seniorproject.R
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun AddGame(modifier: Modifier = Modifier) {
    var handicapActive by remember { mutableStateOf(false) }
    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        GameDateRow()
        TypeRow()
        ModeRow()
        HandRow()
        IncludeStatsRow(handicapActive = handicapActive, onHandicapActive = { handicapActive = it })
        ScoreRow()
        HouseRow()
        LaneRow()
        Notes()
        Button(onClick = {  },
            modifier.widthIn(min = 250.dp)) {
            Text(stringResource(R.string.add))
        }
    }
}

@Composable
fun GameDateRow(modifier: Modifier = Modifier){
    var pickedDate by remember { mutableStateOf(LocalDate.now()) }
    var pickedTime by remember { mutableStateOf(LocalTime.now()) }

    val formattedDate by remember { derivedStateOf {
        DateTimeFormatter
            .ofPattern("MMM dd yyyy")
            .format(pickedDate)
    }
    }
    val formattedTime by remember { derivedStateOf {
        DateTimeFormatter
            .ofPattern("hh:mm")
            .format(pickedTime)
    }
    }

    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
                dateDialogState.show()
            },
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
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
fun TypeRow(modifier: Modifier = Modifier){
    var type by remember { mutableStateOf("")}

    Row(modifier = modifier
        .fillMaxWidth()
        .size(100.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Type")
        EditNumberField(
            label = R.string.type,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            value = type,
            onValueChange = { type = it },
            keyboardActions = KeyboardActions(
                onNext = { }
            )
        )
    }
}

@Composable
fun ModeRow(modifier: Modifier = Modifier){
    var mode by remember { mutableStateOf("")}

    Row(modifier = modifier
        .fillMaxWidth()
        .size(100.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Mode")
        EditNumberField(
            label = R.string.mode,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            value = mode,
            onValueChange = { mode = it },
            keyboardActions = KeyboardActions(
                onNext = { }
            )
        )
    }
}

@Composable
fun HandRow(modifier: Modifier = Modifier){
    var hand by remember { mutableStateOf("")}

    Row(modifier = modifier
        .fillMaxWidth()
        .size(100.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Hand")
        EditNumberField(
            label = R.string.hand,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            value = hand,
            onValueChange = { hand = it },
            keyboardActions = KeyboardActions(
                onNext = { }
            )
        )
    }
}

@Composable
fun IncludeStatsRow(modifier: Modifier = Modifier, handicapActive: Boolean, onHandicapActive: (Boolean) -> Unit){

    Row(modifier = modifier
        .fillMaxWidth()
        .size(100.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Include in Stats")
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
fun ScoreRow(modifier: Modifier = Modifier){
    var score by remember { mutableStateOf("")}

    Row(modifier = modifier
        .fillMaxWidth()
        .size(100.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Score")
        EditNumberField(
            label = R.string.score,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            value = score,
            onValueChange = { score = it },
            keyboardActions = KeyboardActions(
                onNext = { }
            )
        )
    }
}

@Composable
fun LaneRow(modifier: Modifier = Modifier){

}

@Composable
fun Notes(modifier: Modifier = Modifier){

}

@Preview (showBackground = true)
@Composable
fun AddGamePreview(){
    AddGame()
}