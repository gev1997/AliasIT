package com.aliasit.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun MainActivity.GamePage() {
    val teams = getTeamsViewModel().getStateFlow().collectAsState().value
    val timeAndScore = getTimeAndScoreViewModel().getStateFlow().collectAsState().value
    val currentTeam = teams.getCurrentTeam()

    LaunchedEffect(Unit) {
        while (timeAndScore.getCurrentRoundTime() > 0) {
            delay(1.seconds)
            timeAndScore.increaseCurrentRoundTime()
        }
    }

    Scaffold { padding ->
        BoxWithConstraints {
            val mainContentColumnWidth = maxWidth * 0.9f

            // Main Column
            Column(Modifier.fillMaxSize().background(backgroundColor).padding(padding), horizontalAlignment = Alignment.CenterHorizontally) {
                // Main content Column
                Column(Modifier.fillMaxHeight().width(mainContentColumnWidth).verticalScroll(rememberScrollState()), Arrangement.SpaceBetween) {
                    // Title Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(currentTeam.getName(), color = textColor, fontSize = 60.sp)
                        Text(currentTeam.getCurrentPlayer().getName(), color = textColor, fontSize = 60.sp)
                    }

                    // TODO: temporary design
                    // Words
                    Column(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Time left: ${timeAndScore.getCurrentRoundTime()} s", color = textColor, fontSize = 24.sp)

                        Card(Modifier.fillMaxWidth().padding(20.dp), MaterialTheme.shapes.medium, colors = CardDefaults.cardColors(containerColor = Color.Gray)) {
                            for (i in 0..<7) {
                                var isClicked by remember { mutableStateOf(false) }
                                val color = if (isClicked) Color.LightGray else buttonColor
                                val buttonColors = ButtonDefaults.buttonColors(color)
                                val onClick = {
                                    isClicked = !isClicked

                                    if (isClicked)
                                        timeAndScore.addCurrentRoundScore()
                                    else
                                        timeAndScore.removeCurrentRoundScore()
                                }

                                Button(onClick, Modifier.fillMaxWidth(), colors = buttonColors, shape = buttonShape) {
                                    Text("aaa")
                                }
                            }
                        }

                        Text("Score: ${timeAndScore.getCurrentRoundScore()}", color = textColor, fontSize = 24.sp)
                    }

                    Utility.Spacer(0, 2)

                    // Continue Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        val isContinueButtonEnabled = timeAndScore.getCurrentRoundTime() == 0
                        val continueButtonAlpha = if (isContinueButtonEnabled) 100f else 0f
                        val onContinue: () -> Unit = {
                            currentTeam.addScore(timeAndScore.getCurrentRoundScore())

                            if (currentTeam.getScore() < timeAndScore.getWinScore())
                                getNavController().getNavigator("GameState")()
                            else
                                getNavController().getNavigator("GameWin")()
                        }

                        Button(onContinue, Modifier.fillMaxWidth().alpha(continueButtonAlpha), isContinueButtonEnabled, buttonShape, ButtonDefaults.buttonColors(buttonColor)) {
                            Text("Continue", color = textColor, fontSize = 28.sp)
                        }

                        Utility.Spacer(10)
                    }
                }
            }
        }
    }

    BackHandler(true) {
        backToHomeHandler()
    }
}
