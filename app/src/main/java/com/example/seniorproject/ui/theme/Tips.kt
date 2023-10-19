package com.example.seniorproject.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class BowlingTip(
    val title: String,
    val content: String
)

@Composable
fun TipsScreen(tips: List<BowlingTip>) {
    val expandedStates = remember { mutableStateMapOf<String, Boolean>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Bowling Tips",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
        LazyColumn {
            items(tips) { tip ->
                ExpandableItem(
                    title = tip.title,
                    content = tip.content,
                    expanded = expandedStates[tip.title] ?: false,
                    onToggleExpansion = { isExpanded ->
                        expandedStates[tip.title] = isExpanded
                    }
                )
            }
        }
    }
}

@Composable
fun ExpandableItem(title: String, content: String, expanded: Boolean, onToggleExpansion: (Boolean) -> Unit) {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { onToggleExpansion(!expanded) },
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                if (expanded) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = content, fontSize = 16.sp)
                }
            }
        }
    }
}

val tips = listOf(
    BowlingTip("Proper Stance and Approach", "Description of the tip..."),
    BowlingTip("Grip and Release", "Description of the tip..."),
    BowlingTip("Tip3", "Description of the tip..."),
    BowlingTip("Tip4", "Description of the tip..."),
    BowlingTip("Tip5", "Description of the tip..."),
    BowlingTip("Videos", "Description of the tip..."),
    // Add more tips here
)

@Preview(showBackground = true)
@Composable
fun TipsPreview() {
    TipsScreen(tips = tips)
}