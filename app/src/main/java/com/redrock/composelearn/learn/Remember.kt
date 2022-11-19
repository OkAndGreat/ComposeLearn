package com.redrock.composelearn.learn

import androidx.compose.material.Text
import androidx.compose.runtime.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Author by OkAndGreat
 * Date on 2022/11/19 15:54.
 *  Composition scope & remember() Learn
 */
const val TAG = "Remember"


@Composable
fun rememberLearn() {

    var name by remember { mutableStateOf("okandgreat") }

    Text(name)

    GlobalScope.launch {
        delay(2000)
        name = "greatandok"
    }
}

fun rememberWithParam(value: String) {
    val lengthWithoutLength = value.length
    val lengthWithLength = remember(value.hashCode()) { value.length }
    val lengthWithLengthArgs = remember(value, value) { value + value }

    Text("Length is $lengthWithoutLength")
}