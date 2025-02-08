package com.aliasit.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Utility {
    companion object {
        @Composable
        fun Spacer(size: Int, count: Int = 1) {
            assert(size >= 0)
            assert(count > 0)

            for (i in 0..<count)
                Spacer(Modifier.size(size.dp))
        }
    }
}
