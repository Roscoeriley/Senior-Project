package com.example.seniorproject.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seniorproject.R
import java.util.*

@Composable
fun LoginScreen(onLoginButtonClicked: () -> Unit, modifier: Modifier = Modifier, credentials: Credentials) {
    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = credentials.userName,
            onValueChange = { credentials.userName = it},
            label = { Text(stringResource(R.string.login)) },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = credentials.password,
            onValueChange = { credentials.password = it},
            label = { Text(stringResource(R.string.password)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = onLoginButtonClicked,
            modifier.widthIn(min = 250.dp)) {
            Text(stringResource(R.string.login))
        }
    }
}

data class Credentials(
    var userName: String = "",
    var password: String = ""
)

@Preview(showBackground = true)
@Composable
fun LoginPreview(){
    LoginScreen(onLoginButtonClicked = {}, credentials = Credentials(userName =  "", password = ""))
}