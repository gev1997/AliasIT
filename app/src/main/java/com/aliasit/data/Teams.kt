package com.aliasit.data

class Teams {
    fun getTeam(index: Int): Team {
        assert(index < getCount())

        return mTeamsList[index]
    }

    fun getCount() = mTeamsList.count()

    private val mTeamsList = MutableList(teamsMinCount()) { index -> Team(index + 1) }
}
