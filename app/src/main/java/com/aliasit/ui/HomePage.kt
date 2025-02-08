package com.aliasit.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainActivity.HomePage() {
    Scaffold { padding ->
        BoxWithConstraints {
            val mainContentColumnWidth = maxWidth * 0.9f

            // Main Column
            Column(Modifier.fillMaxSize().background(backgroundColor).padding(padding), horizontalAlignment = Alignment.CenterHorizontally) {
                // Main content Column
                Column(Modifier.fillMaxHeight().width(mainContentColumnWidth), Arrangement.SpaceBetween) {
                    // Options Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                        Button(getNavController().getNavigator("Options"), Modifier.size(100.dp, 100.dp), colors = ButtonDefaults.buttonColors(backgroundColor)) {
                            Icon(Icons.Default.Settings, contentDescription = null, Modifier.fillMaxSize(), tint = textColor)
                        }
                    }

                    // Title Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Alias IT", color = textColor, fontSize = 60.sp)
                    }

                    Utility.Spacer(0, 2)

                    // Play Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Button(getNavController().getNavigator("Teams"), Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(buttonColor), shape = buttonShape) {
                            Text("Play", color = textColor, fontSize = 28.sp)
                        }

                        Utility.Spacer(10)
                    }
                }
            }
        }
    }
}
