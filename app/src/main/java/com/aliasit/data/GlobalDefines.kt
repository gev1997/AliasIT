package com.aliasit.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

// TODO:
fun playersMinCount(): Int { return 2 }
fun playersMaxCount(): Int { return 4 }
fun teamsMinCount(): Int { return 2 }
fun teamsMaxCount(): Int { return 3 }

// TODO: read/write in file
var mCppWords by mutableStateOf(mapOf(
    Pair("int", false),
    Pair("int", false),
    Pair("double", false),
    Pair("float", false),
    Pair("string", false),
    Pair("const", false),
    Pair("value", false),
    Pair("char", false),
    Pair("short", false),
    Pair("sort", false)))

var mGenericWords = mapOf(
    Pair("manager", false),
    Pair("day off", false),
    Pair("vacation", false),
    Pair("intern", false),
    Pair("Team Lead", false),
    Pair("QA", false))
