package com.aliasit

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
fun MainActivity.HomePage() {
    Scaffold { padding ->
        Column(Modifier.fillMaxSize().padding(padding), Arrangement.Top, Alignment.End) {
            Button(getNavController().getNavigator("Options"), Modifier.size(60.dp, 60.dp)) {
                Text("*", fontSize = 32.sp)
            }
        }
        Column(Modifier.fillMaxSize().padding(padding), Arrangement.Center, Alignment.CenterHorizontally) {
            Text("Alias IT", fontSize = 58.sp)
            Spacer(Modifier.size(250.dp))
        }
        Column(Modifier.fillMaxSize().padding(padding), Arrangement.Bottom, Alignment.CenterHorizontally) {
            Button(getNavController().getNavigator("Teams"), Modifier.size(250.dp, 60.dp)) {
                Text("Play", fontSize = 22.sp)
            }
            Spacer(Modifier.size(20.dp))
        }
    }
}
