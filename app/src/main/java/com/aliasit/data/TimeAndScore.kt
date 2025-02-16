package com.aliasit.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

class TimeAndScore() {
    fun getRoundTime() = mRoundTime

    fun addRoundTime() {
        if (mRoundTime < roundMaxTime()) {
            mRoundTime += 5
            resetCurrentRoundTime()
        }
    }

    fun removeRoundTime() {
        if (mRoundTime > roundMinTime()) {
            mRoundTime -= 5
            resetCurrentRoundTime()
        }
    }

    fun getCurrentRoundTime() = mCurrentRoundTime

    fun resetCurrentRoundTime() {
        mCurrentRoundTime = mRoundTime
    }

    fun increaseCurrentRoundTime(): Boolean {
        --mCurrentRoundTime

        assert(mCurrentRoundTime >= 0)

        return mCurrentRoundTime != 0
    }

    fun getCurrentRoundScore() = mCurrentRoundScore

    fun resetCurrentRoundScore() {
        mCurrentRoundScore = 0
    }

    fun addCurrentRoundScore() {
        ++mCurrentRoundScore
    }

    fun removeCurrentRoundScore() {
        assert(mCurrentRoundScore > 0)

        --mCurrentRoundScore
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
    private var mCurrentRoundTime by mutableIntStateOf(mRoundTime)
    private var mCurrentRoundScore by mutableIntStateOf(0)
    private var mWinScore by mutableIntStateOf(40)
}
