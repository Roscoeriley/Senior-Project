package com.example.seniorproject.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Slider
import androidx.compose.runtime.*
import androidx.compose.ui.focus.onFocusChanged

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BowlingScoreSheet() {
    Scaffold(
        bottomBar = {
            BottomAppBar() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BottomBarButton("Strike") { handleButtonAction("Strike") }
                    BottomBarButton("Spare") { handleButtonAction("Spare") }
                    BottomBarButton("Gutter") { handleButtonAction("Gutter") }
                    BottomBarButton("Foul") { handleButtonAction("Foul") }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyRow (
                modifier = Modifier
                    .padding(16.dp)
            ) {
                //Frame 1
                item {
                    SquareWithSmallSquare("1", "/", "10", "1")
                }
                //Frame 2
                item {
                    SquareWithSmallSquare("1", "/", "10", "2")
                }
                //Frame 3
                item {
                    SquareWithSmallSquare("1", "/", "10", "3")
                }
                //Frame 4
                item {
                    SquareWithSmallSquare("1", "/", "10", "4")
                }
                //Frame 5
                item {
                    SquareWithSmallSquare("1", "/", "10", "5")
                }
                //Frame 6
                item {
                    SquareWithSmallSquare("1", "/", "10", "6")
                }
                //Frame 7
                item {
                    SquareWithSmallSquare("1", "/", "10", "7")
                }
                //Frame 8
                item {
                    SquareWithSmallSquare("1", "/", "10", "8")
                }
                //Frame 9
                item {
                    SquareWithSmallSquare("1", "/", "10", "9")
                }
                //Frame 10
                item {
                    SquareWithThreeSmallerSquares("1", "/", "10", "300", "10")
                }
            }

            TriangleOfButtons()
        }
    }
}

@Composable
fun SquareWithSmallSquare(firstBall: String, secondBall: String, total: String, frameNum: String,) {
    Column {
        Box(
            modifier = Modifier
                .size(100.dp, 50.dp)
                .background(color = Color.Gray, shape = MaterialTheme.shapes.small)
                .border(1.dp, Color.Black, shape = MaterialTheme.shapes.small)
        ) {
            Text(
                text = frameNum,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Transparent, shape = MaterialTheme.shapes.small)
                .border(1.dp, Color.Black, shape = MaterialTheme.shapes.small)
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Transparent)
                    .border(1.dp, Color.Black, shape = MaterialTheme.shapes.small)
                    .align(Alignment.TopEnd)
            )

            Text(
                text = firstBall,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(10.dp)
                    .padding(horizontal = 8.dp),
            )

            Text(
                text = secondBall,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(10.dp)
                    .padding(horizontal = 8.dp),
            )

            Text(
                text = total,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(8.dp),
            )
        }
    }
}

@Composable
fun SquareWithThreeSmallerSquares(firstBall: String, secondBall: String, thirdBall: String, total: String, frameNum: String,) {
    Column {
        Box(
            modifier = Modifier
                .size(150.dp, 50.dp)
                .background(color = Color.Gray, shape = MaterialTheme.shapes.small)
                .border(1.dp, Color.Black, shape = MaterialTheme.shapes.small)
        ) {
            Text(
                text = frameNum,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .size(150.dp, 100.dp) // Slightly longer size
                .background(color = Color.Transparent, shape = MaterialTheme.shapes.small)
                .border(1.dp, Color.Black, shape = MaterialTheme.shapes.small)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                SmallSquare()
                SmallSquare()
                SmallSquare()
            }
            Text(
                text = firstBall,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(10.dp)
                    .padding(horizontal = 8.dp),
            )

            Text(
                text = secondBall,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(10.dp)
            )

            Text(
                text = thirdBall,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .padding(horizontal = 8.dp),
            )

            Text(
                text = total,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(8.dp),
            )
        }
    }
}

@Composable
fun SmallSquare() {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.Transparent)
            .border(1.dp, Color.Black, shape = MaterialTheme.shapes.small)
    )
}

@Composable
fun TriangleOfButtons() {
    val buttonSize = 56.dp
    val spacing = 10.dp

    // Create a state to track the button clicks
    var button1Clicked by remember { mutableStateOf(false) }
    var button2Clicked by remember { mutableStateOf(false) }
    var button3Clicked by remember { mutableStateOf(false) }
    var button4Clicked by remember { mutableStateOf(false) }
    var button5Clicked by remember { mutableStateOf(false) }
    var button6Clicked by remember { mutableStateOf(false) }
    var button7Clicked by remember { mutableStateOf(false) }
    var button8Clicked by remember { mutableStateOf(false) }
    var button9Clicked by remember { mutableStateOf(false) }
    var button10Clicked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Create the fourth row with four buttons (upside down)
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { button7Clicked = !button7Clicked },
                modifier = Modifier.size(buttonSize),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (button7Clicked) Color.Gray else Color.White
                ),
                shape = CircleShape
            ) {
                Text(text = "7", color = Color.Black)
            }
            Button(
                onClick = { button8Clicked = !button8Clicked },
                modifier = Modifier.size(buttonSize),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (button8Clicked) Color.Gray else Color.White
                ),
                shape = CircleShape
            ) {
                Text(text = "8", color = Color.Black)
            }
            Button(
                onClick = { button9Clicked = !button9Clicked },
                modifier = Modifier.size(buttonSize),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (button9Clicked) Color.Gray else Color.White
                ),
                shape = CircleShape
            ) {
                Text(text = "9", color = Color.Black)
            }
            Button(
                onClick = { button10Clicked = !button10Clicked },
                modifier = Modifier.size(buttonSize),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (button10Clicked) Color.Gray else Color.White
                ),
                shape = CircleShape
            ) {
                Text(text = "10", color = Color.Black)
            }
        }
        // Create the third row with three buttons (upside down)
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { button4Clicked = !button4Clicked },
                modifier = Modifier.size(buttonSize),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (button4Clicked) Color.Gray else Color.White
                ),
                shape = CircleShape
            ) {
                Text(text = "4", color = Color.Black)
            }
            Button(
                onClick = { button5Clicked = !button5Clicked },
                modifier = Modifier.size(buttonSize),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (button5Clicked) Color.Gray else Color.White
                ),
                shape = CircleShape
            ) {
                Text(text = "5", color = Color.Black)
            }
            Button(
                onClick = { button6Clicked = !button6Clicked },
                modifier = Modifier.size(buttonSize),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (button6Clicked) Color.Gray else Color.White
                ),
                shape = CircleShape
            ) {
                Text(text = "6", color = Color.Black)
            }
        }
        // Create the second row with two buttons (upside down)
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { button2Clicked = !button2Clicked },
                modifier = Modifier.size(buttonSize),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (button2Clicked) Color.Gray else Color.White
                ),
                shape = CircleShape
            ) {
                Text(text = "2", color = Color.Black)
            }
            Button(
                onClick = { button3Clicked = !button3Clicked },
                modifier = Modifier.size(buttonSize),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (button3Clicked) Color.Gray else Color.White
                ),
                shape = CircleShape
            ) {
                Text(text = "3", color = Color.Black)
            }
        }
        // Create the top row with a single button (upside down)
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { button1Clicked = !button1Clicked },
                modifier = Modifier.size(buttonSize),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (button1Clicked) Color.Gray else Color.White
                ),
                shape = CircleShape
            ) {
                Text(text = "1", color = Color.Black)
            }
        }
    }
}

@Composable
fun BottomBarButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp),
    ) {
        Text(text = text)
    }
}

fun handleButtonAction(action: String) {
    // Handle the button action here
    // You can update the scores or perform any other relevant action
}

fun calculateTotalScore(scores: List<String>): String {
    // Implement your logic to calculate the total score here
    // This is a placeholder that just sums up the scores as integers
    val total = scores.map { it.toIntOrNull() ?: 0 }.sum()
    return total.toString()
}

@Preview(showBackground = true)
@Composable
fun ScorePreview() {
    BowlingScoreSheet()
}
