package com.aliasit.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Player(private val playerIndex: Int) {
    fun getIndex() = playerIndex

    fun getName() = mName

    fun setName(name: String) {
        assert(name.isNotEmpty())

        mName = name
    }

    private var mName by mutableStateOf("Player $playerIndex")
}
