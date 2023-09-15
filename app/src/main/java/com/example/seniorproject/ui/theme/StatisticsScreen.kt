package com.example.seniorproject.ui.theme

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seniorproject.R

@Composable
fun StatisticsScreen(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.Start)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.game),
            modifier = Modifier.weight(1f) // Set weight to fill available space in row
        )
        Text(
            text = stringResource(R.string.frame),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(R.string.leaves),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(R.string.ball),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(R.string.charts),
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview (showBackground = true)
@Composable
fun StatisticsPreview(){
    StatisticsScreen()
}