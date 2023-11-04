package com.example.seniorproject.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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

@Composable
fun PracticeScreen() {
Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        ClickableText("9/22/2023"){}
        Spacer(modifier = Modifier.width(16.dp))
        ClickableText("9/29/2023") {}
        Spacer(modifier = Modifier.width(16.dp))
        ClickableText("9/29/2023") {}
        Spacer(modifier = Modifier.width(16.dp))
        ClickableText("9/29/2023") {}
    }
}

@Composable
fun ClickableText(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        modifier = Modifier.clickable { onClick() }
            .padding(8.dp), // Add padding for better spacing
        fontSize = 20.sp // Set the font size to 20sp (adjust as needed)
    )
}

@Preview(showBackground = true)
@Composable
fun PracticePreview(){
    PracticeScreen()
}