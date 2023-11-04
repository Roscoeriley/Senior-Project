package com.example.seniorproject.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.seniorproject.R

@Composable
fun StatisticsScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        SectionHeader("General")
        StatisticRow("Average", "123.45")
        StatisticRow("First Ball Average", "67.89")
        StatisticRow("Game Count", "42")
        StatisticRow("High Game", "300")
        StatisticRow("Low Game", "100")
        StatisticRow("Strikes", "240")
        StatisticRow("Spares", "125")
        StatisticRow("Opens", "50")
        StatisticRow("Single Pin Spares", "80")
        StatisticRow("Multi Pin Spares", "45")
        StatisticRow("Non-split Spares", "60")
        StatisticRow("Splits", "35")
        StatisticRow("Single Pin Spare %", "60.0%")
        StatisticRow("Non-split Spare", "30")

        SectionHeader("Series")
        StatisticRow("High Series Total", "750")
        StatisticRow("High Series Game Count", "3")
        StatisticRow("High Series Avg", "250")
        StatisticRow("High Series Date", "2023-10-20")
        StatisticRow("Low Series Total", "500")
        StatisticRow("Low Series Game Count", "2")
        StatisticRow("Low Series Avg", "250")
        StatisticRow("Low Series Date", "2023-10-19")
    }
}

@Composable
fun SectionHeader(headerText: String) {
    Text(
        text = headerText,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
    )
}

@Composable
fun StatisticRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label)
        Text(text = value)
    }
}

@Preview (showBackground = true)
@Composable
fun StatisticsPreview(){
    StatisticsScreen()
}