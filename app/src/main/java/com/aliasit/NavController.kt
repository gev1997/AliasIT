package com.aliasit

import androidx.navigation.NavHostController

class NavController(navHostController: NavHostController) {
    private val mNavHostController = navHostController

    fun getNavigator(route: String): () -> Unit {
        when (route) {
            "Home" -> return { mNavHostController.navigate("Home") }
            "Teams" -> return { mNavHostController.navigate("Teams") }
            "Game" -> return { mNavHostController.navigate("Game") }
            "Options" -> return { mNavHostController.navigate("Options") }
        }

        return {}
    }
}
