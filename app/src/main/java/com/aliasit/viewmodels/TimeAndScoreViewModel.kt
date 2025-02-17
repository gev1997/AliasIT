package com.aliasit.viewmodels

import androidx.lifecycle.ViewModel
import com.aliasit.data.TimeAndScore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TimeAndScoreViewModel : ViewModel() {
    fun getStateFlow() = mStateFlow

    fun reset() {
        mMutableStateFlow.value = TimeAndScore()
    }

    private val mMutableStateFlow = MutableStateFlow(TimeAndScore())
    private val mStateFlow = mMutableStateFlow.asStateFlow()
}
