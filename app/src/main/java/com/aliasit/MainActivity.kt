package com.aliasit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aliasit.ui.theme.AliasITTheme
import com.aliasit.viewmodels.TeamsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AliasITTheme {
                mTeamsViewModel = viewModel()
                mNavController = NavController(rememberNavController())

                NavHost(mNavController.getNavHostController(), "Home") {
                    composable("Home") { HomePage() }
                    composable("Teams") { TeamsPage() }
                    composable("Game") { GamePage() }
                    composable("Options") { OptionsPage() }
                }
            }
        }
    }

    fun getNavController(): NavController {
        return mNavController
    }

    fun getTeamsViewModel(): TeamsViewModel {
        return mTeamsViewModel
    }

    private lateinit var mNavController: NavController
    private lateinit var mTeamsViewModel: TeamsViewModel
}
