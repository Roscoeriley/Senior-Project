package com.example.seniorproject.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HelpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Help and Support",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Divider(color = Color.Gray, thickness = 1.dp)

        Text(
            text = "App Overview",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Welcome to Rolling Stats! This app is designed to help you track and analyze your bowling performance.",
            fontSize = 16.sp
        )

        Text(
            text = "Navigation Instructions",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "To navigate through the app, use the menu on the top left corner. You can access settings, view statistics, and more.",
            fontSize = 16.sp
        )

        Text(
            text = "How to Record Scores",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "To record scores for a game, navigate to the 'Score Entry' section. Select the players, input the scores, and save the game.",
            fontSize = 16.sp
        )

        Text(
            text = "Troubleshooting and FAQs",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "If you encounter issues or have questions, check our FAQs in the 'Support' section. You can also contact us for assistance.",
            fontSize = 16.sp
        )

        Text(
            text = "Contact Us",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "For support, email us at support@yourbowlingapp.com. We value your feedback and will respond promptly.",
            fontSize = 16.sp
        )

        // Add more sections as needed (Privacy, Tips, etc.)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Thank you for using our app!",
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HelpPreview(){
    HelpScreen()
}