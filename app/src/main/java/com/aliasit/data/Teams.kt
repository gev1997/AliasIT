package com.aliasit.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue

class Teams {
    fun getTeam(index: Int): Team {
        assert(index < getCount())

        return mTeamsList[index]
    }

    fun addTeam() {
        if (getCount() < teamsMaxCount())
            mTeamsList.add(Team(getCount() + 1))
    }

    fun removeTeam(index: Int) {
        if (getCount() > teamsMinCount())
            mTeamsList.removeAt(index)
    }

    fun getCurrentTeam(): Team {
        return getTeam(mCurrentIndex)
    }

    fun getNextCurrentTeam(): Team {
        val nextCurrentIndex = calculateNextCurrentTeamIndex()

        return getTeam(nextCurrentIndex)
    }

    fun switchToNextCurrentTeam() {
        mCurrentIndex = calculateNextCurrentTeamIndex()
    }

    fun getCount() = mTeamsList.count()

    private fun calculateNextCurrentTeamIndex(): Int {
        assert(mCurrentIndex < getCount())
        val nextCurrentIndex = if (mCurrentIndex == getCount() - 1) { 0 } else { mCurrentIndex + 1 }
        assert(nextCurrentIndex < getCount())

        return nextCurrentIndex
    }

    private val mTeamsList = mutableStateListOf(Team(1), Team(2))
    private var mCurrentIndex by mutableIntStateOf(0)
}
