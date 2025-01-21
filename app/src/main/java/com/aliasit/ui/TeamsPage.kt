package com.aliasit.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainActivity.TeamsPage() {
    Scaffold { padding ->
        Column(Modifier.fillMaxSize().padding(padding), Arrangement.Top, Alignment.CenterHorizontally) {
            Text("Teams", fontSize = 58.sp)
        }
        Column(Modifier.fillMaxSize().padding(padding), Arrangement.Bottom, Alignment.CenterHorizontally) {
            Button(getNavController().getNavigator("Game"), Modifier.size(250.dp, 60.dp)) {
                Text("Start", fontSize = 22.sp)
            }
            Spacer(Modifier.size(20.dp))
        }
    }
}
