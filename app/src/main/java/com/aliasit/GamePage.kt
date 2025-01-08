package com.aliasit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun MainActivity.GamePage() {
    Scaffold { padding ->
        Column(Modifier.fillMaxSize().padding(padding), Arrangement.Center, Alignment.CenterHorizontally) {
            Text("Game Page", fontSize = 32.sp)
        }
    }
}
