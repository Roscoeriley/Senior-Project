package com.example.seniorproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seniorproject.data.DataSource.quantityOptions
import com.example.seniorproject.ui.theme.SeniorProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SeniorProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(quantityOptions = quantityOptions, onNextButtonClicked = {})
                }
            }
        }
    }
}

@Composable
fun MainScreen(quantityOptions: List<Pair<Int, Int>>, onNextButtonClicked: (Int) -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(R.drawable.bowlero_logo),
            contentDescription = "Bowlero Logo",
            modifier = Modifier.width(300.dp))
        Spacer(Modifier.height(16.dp))
        quantityOptions.forEach { item ->
            MainScreenButtons(
                labelResourceId = item.first,
                onClick = { onNextButtonClicked(item.second) }
            )
        }
    }
}

@Composable
fun MainScreenButtons(
    @StringRes labelResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text(stringResource(labelResourceId))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SeniorProjectTheme {
        MainScreen(quantityOptions = quantityOptions, onNextButtonClicked = {})
    }
}