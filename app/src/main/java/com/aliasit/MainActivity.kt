package com.aliasit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aliasit.ui.theme.AliasITTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        setContent {
            AliasITTheme {
                val navHostController = rememberNavController()
                mNavController = NavController(navHostController)

                NavHost(navHostController, "Home") {
                    composable("Home") { HomePage() }
                    composable("Teams") { TeamsPage() }
                    composable("Game") { GamePage() }
                    composable("Options") { OptionsPage() }
                }
            }
        }
    }

    private lateinit var mNavController: NavController
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
