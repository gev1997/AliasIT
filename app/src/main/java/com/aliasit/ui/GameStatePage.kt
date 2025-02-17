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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun MainActivity.GameStatePage() {
    val teams = getTeamsViewModel().getStateFlow().collectAsState().value
    val timeAndScore = getTimeAndScoreViewModel().getStateFlow().collectAsState().value

    val nextCurrentTeam by remember { mutableStateOf(teams.getNextCurrentTeam()) }
    val nextCurrentPlayer by remember { mutableStateOf(nextCurrentTeam.getCurrentPlayer()) }

    Scaffold { padding ->
        BoxWithConstraints {
            val mainContentColumnWidth = maxWidth * 0.9f

            // Main Column
            Column(Modifier.fillMaxSize().background(backgroundColor).padding(padding), horizontalAlignment = Alignment.CenterHorizontally) {
                // Main content Column
                Column(Modifier.fillMaxHeight().width(mainContentColumnWidth).verticalScroll(rememberScrollState()), Arrangement.SpaceBetween) {
                    // Title Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        for (teamIndex in 0..<teams.getCount()) {
                            val team = teams.getTeam(teamIndex)

                            Text("${team.getName()} - ${team.getScore()}", color = textColor, fontSize = 60.sp)
                        }
                    }

                    // Next Team/Player Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(nextCurrentTeam.getName(), color = textColor, fontSize = 24.sp)
                        Text(nextCurrentPlayer.getName(), color = textColor, fontSize = 24.sp)
                        Text("Now it's your move.", color = textColor, fontSize = 28.sp)
                    }

                    Utility.Spacer(0, 2)

                    // Continue Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        val onContinue: () -> Unit = {
                            teams.getCurrentTeam().switchToNextCurrentPlayer()
                            teams.switchToNextCurrentTeam()
                            timeAndScore.resetCurrentRoundTime()
                            timeAndScore.resetCurrentRoundScore()
                            getNavController().getNavigator("Game")()
                        }

                        Button(onContinue, Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(buttonColor), shape = buttonShape) {
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
