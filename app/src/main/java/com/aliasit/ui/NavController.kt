package com.aliasit.ui

import androidx.navigation.NavHostController

class NavController(private val mNavHostController: NavHostController) {
    fun getNavHostController() = mNavHostController

    fun getNavigator(route: String): () -> Unit {
        when (route) {
            "Home" ->
                return {
                    mNavHostController.navigate("Home") {
                        launchSingleTop = true
                        popUpTo(0)
                    }
                }
            "Teams" ->
                return {
                    mNavHostController.navigate("Teams") {
                        launchSingleTop = true
                        popUpTo("Teams")
                    }
                }
            "TimeAndScore" ->
                return {
                    mNavHostController.navigate("TimeAndScore") {
                        launchSingleTop = true
                        popUpTo("TimeAndScore")
                    }
                }
            "Game" ->
                return {
                    mNavHostController.navigate("Game") {
                        launchSingleTop = true
                        popUpTo("Game")
                    }
                }
            "GameState" ->
                return {
                    mNavHostController.navigate("GameState") {
                        launchSingleTop = true
                        popUpTo("GameState")
                    }
                }
            "GameWin" ->
                return {
                    mNavHostController.navigate("GameWin") {
                        launchSingleTop = true
                        popUpTo("GameWin")
                    }
                }
            "Options" ->
                return {
                    mNavHostController.navigate("Options") {
                        launchSingleTop = true
                        popUpTo("Options")
                    }
                }
        }

        return {}
    }
}
