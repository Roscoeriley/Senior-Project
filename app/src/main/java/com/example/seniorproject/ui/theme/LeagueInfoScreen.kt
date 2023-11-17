package com.example.seniorproject.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LeagueInfoScreen(totalScore: Int, numberOfGames: Int) {
    // Assuming you have a function to calculate the average score
    val averageScore = calculateAverageScore(totalScore, numberOfGames)

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Total Score: $totalScore", style = MaterialTheme.typography.h4)
            Text(text = "Number of Games: $numberOfGames", style = MaterialTheme.typography.h4)
            Text(text = "Average Score: $averageScore", style = MaterialTheme.typography.h4)

            Divider(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun calculateAverageScore(totalScore: Int, numberOfGames: Int): Float {
    return if (numberOfGames != 0) {
        totalScore.toFloat() / numberOfGames
    } else {
        0f
    }
}

@Preview(showBackground = true)
@Composable
fun LeagueInfoPreview() {
    LeagueInfoScreen(totalScore = 150, numberOfGames = 10)
}