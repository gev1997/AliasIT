package com.aliasit.ui

import androidx.navigation.NavHostController

class NavController(private val mNavHostController: NavHostController) {
    fun getNavHostController() = mNavHostController

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
