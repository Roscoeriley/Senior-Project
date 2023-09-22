package com.example.seniorproject.ui.theme

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfessionalScreen() {
    var selectedOption by remember { mutableStateOf("Leagues") }

    Column {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            elevation = 4.dp,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                content = {
                    IconButton(
                        onClick = { selectedOption = "Leagues" },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = "Leagues",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (selectedOption == "Leagues") Color.Red else Color.Black
                        )
                    }
                    IconButton(
                        onClick = { selectedOption = "Tournaments" },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = "Tournaments",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (selectedOption == "Tournaments") Color.Red else Color.Black
                        )
                    }
                }
            )
        }

        // Display content based on the selected option
        if (selectedOption == "Leagues") {
            // Content for "Leagues" selected
            Text(
                text = "Monday Night Trios",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(start = 8.dp),
                textAlign = TextAlign.Start,
                fontSize = 16.sp
            )
            Text(
                text = "Northrock Mixers",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(start = 8.dp),
                textAlign = TextAlign.Start,
                fontSize = 16.sp
            )
        } else if (selectedOption == "Tournaments") {
            // Content for "Tournaments" selected
            Text(
                text = "None",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(start = 8.dp),
                textAlign = TextAlign.Start,
                fontSize = 16.sp
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ProfessionalPreview(){
    ProfessionalScreen()
}