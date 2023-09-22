package com.example.seniorproject.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions.Companion.Default
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BowlingScoreSheet() {
    val players = listOf("John", "Sarah") // Replace with your player names
    val scores = mutableStateListOf(
        listOf("X", "X", "9-", "X", "X", "8/", "X", "9-", "9/", "XX8"),
        listOf("6/", "X", "63", "9/", "X", "9-", "X", "X", "X", "XXX")
    )

    var currentPlayerIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Bowling Score Sheet",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
        ScoreTableHeader()
        LazyColumn {
            items(players.size) { playerIndex ->
                BowlingRow(
                    playerName = players[playerIndex],
                    scores = scores[playerIndex]
                ) {
                    // Handle score input here
                    scores[playerIndex] = it
                }
            }
        }
    }
}

@Composable
fun ScoreTableHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Player",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
        repeat(10) { frame ->
            Text(
                text = (frame + 1).toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
        }
        Text(
            text = "Total",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun BowlingRow(
    playerName: String,
    scores: List<String>,
    onScoreChange: (List<String>) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = playerName,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
        scores.forEachIndexed { index, score ->
            var isEditing by remember { mutableStateOf(false) }
            if (isEditing) {
                BasicTextField(
                    value = score,
                    onValueChange = {
                        val updatedScores = scores.toMutableList()
                        updatedScores[index] = it
                        onScoreChange(updatedScores)
                    },
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.White)
                        .border(
                            BorderStroke(1.dp, Color.Gray),
                            shape = MaterialTheme.shapes.small
                        )
                        .padding(4.dp)
                        .onFocusChanged {
                            isEditing = it.isFocused
                        }
                )
            } else {
                Text(
                    text = score,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            isEditing = true
                        }
                )
            }
        }
        Text(
            text = calculateTotalScore(scores),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

fun calculateTotalScore(scores: List<String>): String {
    // Implement your logic to calculate the total score here
    // This is a placeholder that just sums up the scores as integers
    val total = scores.map { it.toIntOrNull() ?: 0 }.sum()
    return total.toString()
}
