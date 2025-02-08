package com.aliasit.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

class TimeAndScore() {
    fun getRoundTime() = mRoundTime

    fun addRoundTime() {
        if (mRoundTime < roundMaxTime())
            mRoundTime += 5
    }

    fun removeRoundTime() {
        if (mRoundTime > roundMinTime())
            mRoundTime -= 5
    }

    fun getWinScore() = mWinScore

    fun addWinScore() {
        if (mWinScore < winScroeMaxCount())
            mWinScore += 5
    }

    fun removeWinScore() {
        if (mWinScore > winScroeMinCount())
            mWinScore -= 5
    }

    private var mRoundTime by mutableIntStateOf(40)
    private var mWinScore by mutableIntStateOf(40)
}
