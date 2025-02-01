package com.aliasit.data

import androidx.compose.runtime.mutableStateListOf

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

    fun getCount() = mTeamsList.count()

    private val mTeamsList = mutableStateListOf(Team(1), Team(2))
}
