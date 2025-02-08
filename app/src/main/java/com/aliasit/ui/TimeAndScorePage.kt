package com.aliasit.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun MainActivity.TimeAndScorePage() {
    val timeAndScore = getTimeAndScoreViewModel().getStateFlow().collectAsState().value

    Scaffold { padding ->
        BoxWithConstraints {
            val mainContentColumnWidth = maxWidth * 0.9f

            // Main Column
            Column(Modifier.fillMaxSize().background(backgroundColor).padding(padding), horizontalAlignment = Alignment.CenterHorizontally) {
                // Main content Column
                Column(Modifier.fillMaxHeight().width(mainContentColumnWidth).verticalScroll(rememberScrollState()), Arrangement.SpaceBetween) {
                    // Title Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Set the points, time the game, and let the fun begin!", lineHeight = 1.em, textAlign = TextAlign.Center, color = textColor, fontSize = 60.sp)
                    }

                    // TimeAndScore Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        // Time Column
                        Column(Modifier.fillMaxWidth()) {
                            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {
                                Button({ timeAndScore.removeRoundTime() }, colors = ButtonDefaults.buttonColors(buttonColor), shape = buttonShape) {
                                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = null, tint = textColor)
                                }

                                Text("Round Time ${timeAndScore.getRoundTime()}", color = textColor, fontSize = 22.sp)

                                Button({ timeAndScore.addRoundTime() }, colors = ButtonDefaults.buttonColors(buttonColor), shape = buttonShape) {
                                    Icon(Icons.Default.KeyboardArrowUp, contentDescription = null, tint = textColor)
                                }
                            }
                        }

                        // Score Column
                        Column(Modifier.fillMaxWidth()) {
                            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {
                                Button({ timeAndScore.removeWinScore() }, colors = ButtonDefaults.buttonColors(buttonColor), shape = buttonShape) {
                                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = null, tint = textColor)
                                }

                                Text("Win Score ${timeAndScore.getWinScore()}", color = textColor, fontSize = 22.sp)

                                Button({ timeAndScore.addWinScore() }, colors = ButtonDefaults.buttonColors(buttonColor), shape = buttonShape) {
                                    Icon(Icons.Default.KeyboardArrowUp, contentDescription = null, tint = textColor)
                                }
                            }
                        }

                        Utility.Spacer(20)
                    }

                    // Play Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Button(getNavController().getNavigator("Game"), Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(buttonColor), shape = buttonShape) {
                            Text("Let's Go", color = textColor, fontSize = 28.sp)
                        }

                        Utility.Spacer(10)
                    }
                }
            }
        }
    }
}
