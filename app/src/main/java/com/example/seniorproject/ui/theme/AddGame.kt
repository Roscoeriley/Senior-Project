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
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
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
import com.example.seniorproject.data.ContentForPractice
import com.example.seniorproject.data.ContentForProfessional
import com.example.seniorproject.data.Game
import com.example.seniorproject.data.games
import com.example.seniorproject.data.practiceContentList
import com.example.seniorproject.data.professionalContentList
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun AddGame(modifier: Modifier = Modifier) {
    var date by remember { mutableStateOf(LocalDate.now()) }
    var type by remember { mutableStateOf("") }
    var handicapActive by remember { mutableStateOf(false) }
    var mode by remember { mutableStateOf("") }
    var hand by remember { mutableStateOf("") }
    var score by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        GameDateRow()
        TypeRow()
        ModeRow(onModeSelected = { selectedMode -> mode = selectedMode })
        HandRow()
        IncludeStatsRow(handicapActive = handicapActive, onHandicapActive = { handicapActive = it })
        if (mode == "Final Score") {
            ScoreRow()
        }
        HouseRow()
        LaneRow()
        Notes()
        Button(onClick = {
            // Create a new game object with the current values
            val newGame = Game.createFromInputFields(
                pickedDate = date,
                type = type,
                mode = mode,
                hand = hand,
                score = score.toIntOrNull() ?: 0 // Convert score to Int, default to 0 if conversion fails
            )

            // Add the new League object to the practiceContentList
            practiceContentList += ContentForPractice.GameContent(newGame)

            // Reset fields for a new entry
            date = LocalDate.now()
            type = ""
            mode = ""
            hand = ""
            score = ""

        },
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

@OptIn(ExperimentalMaterialApi::class)

@Composable
fun TypeRow(modifier: Modifier = Modifier){
    var isExpanded by remember { mutableStateOf(false) }
    var type by remember { mutableStateOf("") }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(100.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Hand")

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it }
        ) {
            TextField(
                value = type,
                onValueChange = { type = it },
                placeholder = { Text("Select hand") }, // Placeholder text
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                DropdownMenuItem(
                    onClick = {
                        type = "League"
                        isExpanded = false
                    }
                ) {
                    Text(text = "League")
                }
                DropdownMenuItem(
                    onClick = {
                        type = "Tournament"
                        isExpanded = false
                    }
                ) {
                    Text(text = "Tournament")
                }
                DropdownMenuItem(
                    onClick = {
                        type = "Practice"
                        isExpanded = false
                    }
                ) {
                    Text(text = "Practice")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModeRow(modifier: Modifier = Modifier, onModeSelected: (String) -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }
    var mode by remember { mutableStateOf("") }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(100.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Mode")

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it }
        ) {
            TextField(
                value = mode,
                onValueChange = { /* Do not update mode here */ },
                placeholder = { Text("Select mode") },
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                DropdownMenuItem(
                    onClick = {
                        mode = "Final Score" // Update the mode variable here
                        onModeSelected(mode)
                        isExpanded = false
                    }
                ) {
                    Text(text = "Final Score")
                }
                DropdownMenuItem(
                    onClick = {
                        mode = "Frame-by-frame" // Update the mode variable here
                        onModeSelected(mode)
                        isExpanded = false
                    }
                ) {
                    Text(text = "Frame-by-frame")
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HandRow(modifier: Modifier = Modifier){
    var isExpanded by remember { mutableStateOf(false) }
    var hand by remember { mutableStateOf("") }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(100.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Hand")

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it }
        ) {
            TextField(
                value = hand,
                onValueChange = { hand = it },
                placeholder = { Text("Select hand") }, // Placeholder text
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                DropdownMenuItem(
                    onClick = {
                        hand = "Right"
                        isExpanded = false
                    }
                ) {
                    Text(text = "Right")
                }
                DropdownMenuItem(
                    onClick = {
                        hand = "Left"
                        isExpanded = false
                    }
                ) {
                    Text(text = "Left")
                }
            }
        }
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