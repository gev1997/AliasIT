package com.aliasit.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class Team(val index: Int) {
    companion object {
        fun playersMaxCount(): Int { return 4 }
        fun playersMinCount(): Int { return 2 }
    }

    fun getName() = mName

    fun setName(name: String) {
        assert(name.isNotEmpty())

        mName = name
    }

    fun getPlayerName(index: Int): String {
        assert(index < getPlayersCount())

        return mPlayers[index]
    }

    fun setPlayerName(index: Int, playerName: String) {
        assert(index < getPlayersCount())
        assert(playerName.isNotEmpty())

        mPlayers[index] = playerName
    }

    fun getPlayersCount() = mPlayers.count()

    fun addPlayer() {
        val playersCount = getPlayersCount()

        if (playersCount < playersMaxCount())
            mPlayers.add("Player ${playersCount + 1}")
    }

    fun removePlayer() {
        val playersCount = getPlayersCount()

        if (playersCount > playersMinCount())
            mPlayers.removeAt(playersCount - 1)
    }

    fun getScore() = mScore

    fun addScore() { ++mScore }

    fun removeScore() {
        assert(mScore > 0)

        --mScore
    }

    fun dropScore() { mScore = 0 }

    private var mName by mutableStateOf("Team $index")
    private var mPlayers = mutableStateListOf("Player 1", "Player 2")
    private var mScore by mutableIntStateOf(0)
}

class TeamsViewModel : ViewModel() {
    fun getTeam(index: Int): Team {
        assert(index < getTeamsCount())

        return mTeams[index]
    }

    fun getTeamsCount() = mTeams.count()

    private var mTeams = mutableStateListOf(Team(1), Team(2))
}
