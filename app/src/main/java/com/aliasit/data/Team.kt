package com.aliasit.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Team(private val teamIndex: Int) {
    fun getIndex() = teamIndex

    fun getName() = mName

    fun setName(name: String) {
        assert(name.isNotEmpty())

        mName = name
    }

    fun getPlayersCount() = mPlayersList.count()

    fun getPlayer(index: Int): Player {
        assert(index < getPlayersCount())

        return mPlayersList[index]
    }

    fun addPlayer() {
        if (getPlayersCount() < playersMaxCount())
            mPlayersList.add(Player(getPlayersCount() + 1))
    }

    fun removePlayer(index: Int) {
        if (getPlayersCount() > playersMinCount())
            mPlayersList.removeAt(index)
    }

    fun getCurrentPlayer(): Player {
        return getPlayer(mCurrentIndex)
    }

    fun switchToNextCurrentPlayer() {
        mCurrentIndex = calculateNextCurrentPlayerIndex()
    }

    fun getScore() = mScore

    fun addScore(score: Int) {
        assert(score >= 0)

        mScore += score
    }

    private fun calculateNextCurrentPlayerIndex(): Int {
        assert(mCurrentIndex < getPlayersCount())
        val nextCurrentIndex = if (mCurrentIndex == getPlayersCount() - 1) { 0 } else { mCurrentIndex + 1 }
        assert(nextCurrentIndex < getPlayersCount())

        return nextCurrentIndex
    }

    private var mName by mutableStateOf("Team $teamIndex")
    private val mPlayersList = mutableStateListOf(Player(1), Player(2))
    private var mScore by mutableIntStateOf(0)
    private var mCurrentIndex by mutableIntStateOf(0)
}
