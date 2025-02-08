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
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.aliasit.data.playersMaxCount
import com.aliasit.data.playersMinCount
import com.aliasit.data.teamsMaxCount
import com.aliasit.data.teamsMinCount
import com.aliasit.ui.dialog.RenameDialog

@Composable
fun MainActivity.TeamsPage() {
    val teams = getTeamsViewModel().getStateFlow().collectAsState().value

    Scaffold { padding ->
        BoxWithConstraints {
            val mainContentColumnWidth = maxWidth * 0.9f
            val teamTitleWidth = mainContentColumnWidth * 0.8f
            val teamPlayerWidth = mainContentColumnWidth * 0.6f

            // Main Column
            Column(Modifier.fillMaxSize().background(backgroundColor).padding(padding), horizontalAlignment = Alignment.CenterHorizontally) {
                // Main content Column
                Column(Modifier.fillMaxHeight().width(mainContentColumnWidth).verticalScroll(rememberScrollState()), Arrangement.SpaceBetween) {
                    // Title Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Teams", color = textColor, fontSize = 60.sp)
                    }

                    // Teams Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        for (teamIndex in 0..<teams.getCount()) {
                            val team = teams.getTeam(teamIndex)

                            // Team Column
                            Column(Modifier.fillMaxWidth()) {
                                Row {
                                    val renameDialog = RenameDialog("Team")
                                    renameDialog.Init(team.getName(), { name -> if (name.isNotEmpty()) team.setName(name) })

                                    Button({ renameDialog.show() }, Modifier.width(teamTitleWidth), colors = ButtonDefaults.buttonColors(buttonColor), shape = buttonShape) {
                                        Text(team.getName(), color = textColor, fontSize = 32.sp)
                                    }
                                    if (teams.getCount() > teamsMinCount()) {
                                        Button({ teams.removeTeam(teamIndex) }, colors = ButtonDefaults.buttonColors(backgroundColor)) {
                                            Icon(Icons.Default.Clear, contentDescription = null, tint = textColor)
                                        }
                                    }
                                }

                                Utility.Spacer(4)

                                for (playerIndex in 0..<team.getPlayersCount()) {
                                    val player = team.getPlayer(playerIndex)

                                    Row {
                                        val renameDialog = RenameDialog("Player")
                                        renameDialog.Init(player.getName(), { name -> if (name.isNotEmpty()) player.setName(name) })

                                        Button({ renameDialog.show() }, Modifier.width(teamPlayerWidth), colors = ButtonDefaults.buttonColors(buttonColor), shape = buttonShape) {
                                            Text(player.getName(), color = textColor, fontSize = 28.sp)
                                        }
                                        if (team.getPlayersCount() > playersMinCount()) {
                                            Button({ team.removePlayer(playerIndex) }, colors = ButtonDefaults.buttonColors(backgroundColor)) {
                                                Icon(Icons.Default.Clear, contentDescription = null, tint = textColor)
                                            }
                                        }
                                    }

                                    Utility.Spacer(4)
                                }

                                if (team.getPlayersCount() < playersMaxCount()) {
                                    Button({ team.addPlayer() }, Modifier.width(teamPlayerWidth), colors = ButtonDefaults.buttonColors(buttonColor), shape = buttonShape) {
                                        Text("Add Player", color = textColor, fontSize = 28.sp)
                                    }

                                    Utility.Spacer(4)
                                }
                            }
                        }

                        if (teams.getCount() < teamsMaxCount()) {
                            Button({ teams.addTeam() }, Modifier.width(teamPlayerWidth), colors = ButtonDefaults.buttonColors(buttonColor), shape = buttonShape) {
                                Text("Add Team", color = textColor, fontSize = 28.sp)
                            }
                        }

                        Utility.Spacer(20)
                    }

                    Utility.Spacer(0, 2)

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
