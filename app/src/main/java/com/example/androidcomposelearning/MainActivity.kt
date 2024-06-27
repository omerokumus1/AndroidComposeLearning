package com.example.androidcomposelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcomposelearning.ui.theme.AndroidComposeLearningTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeLearningTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }
}

@Composable
fun CaptainGame() {
    println("Composing Captain Game")
    val treasuresFound = remember { mutableIntStateOf(0) }
    val direction = remember { mutableStateOf("North") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Title()
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "This is a game where you are the captain of a ship and you have to make decisions to keep your crew alive.")

        TreasuresFoundText(treasuresFound)
        DirectionText(direction)

        Spacer(modifier = Modifier.height(16.dp))

        GoNorthButton(treasuresFound, direction)

        Spacer(modifier = Modifier.height(16.dp))
        GoSouthButton(treasuresFound, direction)
        Spacer(modifier = Modifier.height(16.dp))
        GoEastButton(treasuresFound, direction)
        Spacer(modifier = Modifier.height(16.dp))
        GoWestButton(treasuresFound, direction)
    }

}

@Composable
private fun TreasuresFoundText(treasuresFound: MutableIntState) {
    println("Treasures Found Text is Composed")
    Text(text = "Tresures Found: ${treasuresFound.intValue}")
}

@Composable
private fun DirectionText(direction: MutableState<String>) {
    println("Direction Text is Composed")
    Text(text = "Direction: ${direction.value}")
}

@Composable
private fun Title() {
    println("Title is Composed")
    Text(text = "Captain Game", style = MaterialTheme.typography.headlineLarge)
}

@Composable
private fun GoWestButton(
    treasuresFound: MutableIntState,
    direction: MutableState<String>
) {
    Button(onClick = {
        if (Random.nextBoolean())
            treasuresFound.intValue++
        direction.value = "West"
    }) {
        Text(text = "Go West")
    }
}

@Composable
private fun GoEastButton(
    treasuresFound: MutableIntState,
    direction: MutableState<String>
) {
    Button(onClick = {
        if (Random.nextBoolean())
            treasuresFound.intValue++
        direction.value = "East"
    }) {
        Text(text = "Go East")
    }
}

@Composable
private fun GoSouthButton(
    treasuresFound: MutableIntState,
    direction: MutableState<String>
) {
    Button(onClick = {
        if (Random.nextBoolean())
            treasuresFound.intValue++
        direction.value = "South"
    }) {
        Text(text = "Go South")
    }
}

@Composable
private fun GoNorthButton(
    treasuresFound: MutableIntState,
    direction: MutableState<String>
) {
    Button(onClick = {
        if (Random.nextBoolean())
            treasuresFound.intValue++
        direction.value = "North"
    }) {
        Text(text = "Go North")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidComposeLearningTheme {
        CaptainGame()
    }
}