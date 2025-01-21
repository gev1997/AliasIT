package com.aliasit.viewmodels

import androidx.lifecycle.ViewModel
import com.aliasit.data.Teams
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TeamsViewModel : ViewModel() {
    fun getStateFlow() = mStateFlow

    private val mMutableStateFlow = MutableStateFlow(Teams())
    private val mStateFlow = mMutableStateFlow.asStateFlow()
}
