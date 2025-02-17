package com.aliasit.ui

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
import com.aliasit.viewmodels.TimeAndScoreViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AliasITTheme {
                mTeamsViewModel = viewModel()
                mTimeAndScoreViewModel = viewModel()
                mNavController = NavController(rememberNavController())

                NavHost(mNavController.getNavHostController(), "Home") {
                    composable("Home")         { HomePage()         }
                    composable("Teams")        { TeamsPage()        }
                    composable("TimeAndScore") { TimeAndScorePage() }
                    composable("Game")         { GamePage()         }
                    composable("GameState")    { GameStatePage()    }
                    composable("GameWin")      { GameWinPage()      }
                    composable("Options")      { OptionsPage()      }
                }
            }
        }
    }

    fun getNavController() = mNavController
    fun getTeamsViewModel() = mTeamsViewModel
    fun getTimeAndScoreViewModel() = mTimeAndScoreViewModel

    private lateinit var mNavController: NavController
    private lateinit var mTeamsViewModel: TeamsViewModel
    private lateinit var mTimeAndScoreViewModel: TimeAndScoreViewModel
}

fun MainActivity.backToHomeHandler() {
    getNavController().getNavigator("Home")()
    getTeamsViewModel().reset()
    getTimeAndScoreViewModel().reset()
}
