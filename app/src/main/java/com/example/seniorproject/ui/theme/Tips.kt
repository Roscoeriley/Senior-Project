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
    BowlingTip("Stance", "Feet Placement: Start with your feet shoulder-width apart. Your non-dominant foot (left foot for right-handed bowlers, right foot for left-handed bowlers) should be slightly ahead of the other.\n" +
            "\n" +
            "Body Posture: Maintain an upright and balanced posture. Keep your upper body straight, with your spine aligned. Avoid leaning forward or backward.\n" +
            "\n" +
            "Grip: Hold the bowling ball with a relaxed and firm grip. Your non-bowling hand should support the ball from underneath while your dominant hand holds the ball on the side. The weight of the ball should rest on your non-bowling hand.\n" +
            "\n" +
            "Ball Position: Position the bowling ball in front of you with your dominant hand at about waist height. Your non-bowling hand should guide and support the ball."),
    BowlingTip("Approach", "Number of Steps: Most bowlers use a four-step or five-step approach. A four-step approach is more common and begins with your non-dominant foot (left foot for right-handed bowlers) forward.\n" +
            "\n" +
            "Step Rhythm: Develop a consistent and smooth rhythm in your approach. Each step should be of approximately equal length, and you should move at a steady pace.\n" +
            "\n" +
            "Timing: The timing of your steps and swing is crucial. Work on syncing your steps with your arm swing. Typically, the ball should be pushed away on the second step of a four-step approach and on the first step of a five-step approach.\n" +
            "\n" +
            "Balanced Approach: Maintain your balance throughout the approach. Avoid excessive swaying or tilting. Keep your eyes focused on your target (the pins) and your head steady.\n" +
            "\n" +
            "Slide and Release: As you reach the final steps of your approach, focus on a smooth slide into the foul line with your slide foot (non-dominant foot). Simultaneously, release the ball at the bottom of your swing when your arm is in line with your target.\n" +
            "\n" +
            "Follow Through: After releasing the ball, your hand should continue its upward motion toward your target. This helps with accuracy and consistency.\n" +
            "\n" +
            "Finish: After the release, maintain your balance and follow through by bringing your non-bowling hand up and pointing it toward your target.\n" +
            "\n" +
            "Practice: Consistent practice is essential for improving your approach and stance. Video recording your approach can help you identify areas for improvement."),
    BowlingTip("Grip", "Choose the Right Ball: Make sure you're using a bowling ball that fits your hand comfortably. Visit a pro shop to get a custom-fit ball if possible. The holes should be snug but not too tight, allowing for a relaxed and secure grip.\n" +
            "\n" +
            "Finger Insert Placement: Ensure that your fingers are inserted up to the second joint for maximum control and consistency. Your thumb should be inserted all the way to the base of the hole.\n" +
            "\n" +
            "Grip Pressure: Maintain a relaxed grip pressure on the ball. A tight grip can lead to inaccuracies and reduce your ability to impart the right amount of spin on the ball.\n" +
            "\n" +
            "Grip Types: There are various grip types, including the conventional grip (fingers and thumb inserted completely), fingertip grip (fingers inserted only to the first joint), and semi-fingertip grip (somewhere in between). Experiment to find the grip that works best for you."),
    BowlingTip("Release", "Timing: The timing of your release is crucial. Ideally, you should release the ball when your arm is in line with your target, and it should be a smooth, uninterrupted motion.\n" +
            "\n" +
            "Wrist Position: Keep your wrist in a firm but relaxed position. Avoid excessive bending or cupping of the wrist during the release.\n" +
            "\n" +
            "Smooth Delivery: Focus on delivering the ball smoothly and consistently. Avoid jerky or forced motions. Let the ball roll off your hand naturally.\n" +
            "\n" +
            "Thumb Release: For a proper thumb release, practice maintaining a straight thumb position during your downswing. The thumb should exit the ball first, allowing your fingers to generate the rotation needed for hooking the ball.\n" +
            "\n" +
            "Finger Release: As your thumb exits the ball, concentrate on lifting and rolling the fingers from the inside of the ball. This action imparts the desired spin on the ball.\n" +
            "\n" +
            "Follow Through: After releasing the ball, your hand should continue its motion towards the target. A solid follow-through can help maintain accuracy and improve your consistency.\n" +
            "\n" +
            "Watch the Target: Keep your eyes on your target throughout the release. Your eyes play a crucial role in directing the ball to the desired spot on the lane.\n" +
            "\n" +
            "Practice: Regular practice is essential for honing your grip and release. Work on your timing and aim for a consistent, comfortable release each time you bowl.\n" +
            "\n" +
            "Seek Coaching: Consider getting instruction from a certified bowling coach. They can provide personalized guidance and help you fine-tune your grip and release technique."),
    BowlingTip("Tip5", "Description of the tip..."),
    BowlingTip("Videos", "Description of the tip..."),
    // Add more tips here
)

@Preview(showBackground = true)
@Composable
fun TipsPreview() {
    TipsScreen(tips = tips)
}