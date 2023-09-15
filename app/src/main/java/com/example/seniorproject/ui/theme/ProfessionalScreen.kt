package com.example.seniorproject.ui.theme

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfessionalScreen() {
    Column {
        Text(text = "Leagues:", style = MaterialTheme.typography.h5)
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

        Text(text = "Tournaments:", style = MaterialTheme.typography.h5)
        Text(
            text = "None",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(start = 8.dp),
            textAlign = TextAlign.Start,
            fontSize = 16.sp
        )
    }
}

@Preview (showBackground = true)
@Composable
fun ProfessionalPreview(){
    ProfessionalScreen()
}