package com.example.seniorproject.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.seniorproject.data.ContentForPractice
import com.example.seniorproject.data.Game
import com.example.seniorproject.data.games
import com.example.seniorproject.data.practiceContentList

@Composable
fun PracticeScreen(contentList: List<ContentForPractice>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        items(contentList) { content ->
            when (content) {
                is ContentForPractice.GameContent -> {
                    ClickableGameItem(game = content.game) {
                        // Handle click event if needed
                    }
                }
            }
        }
    }
}

@Composable
fun ClickableGameItem(game: Game, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = game.date, fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PracticePreview() {
    PracticeScreen(contentList = practiceContentList)
}