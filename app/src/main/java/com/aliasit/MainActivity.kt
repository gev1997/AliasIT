package com.aliasit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.aliasit.ui.theme.AliasITTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        setContent {
            AliasITTheme {
            }
        }
    }
}

@Composable
fun MainActivity.HomePage() {
}

@Composable
fun MainActivity.TeamsPage() {
}

@Composable
fun MainActivity.GamePage() {
}

@Composable
fun MainActivity.OptionsPage() {
}
