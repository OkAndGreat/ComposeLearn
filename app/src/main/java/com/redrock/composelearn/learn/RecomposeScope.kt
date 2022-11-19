package com.redrock.composelearn.learn

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

/**
 * Author by OkAndGreat
 * Date on 2022/11/19 23:29.
 * 重组的性能风险和智能优化
 */

private const val TAG = "Remember"

private val mName = mutableStateOf("s okandgreat")

@Composable
fun ReComposeScopeLearn() {

    var name by remember { mutableStateOf("okandgreat") }

    Log.d(TAG, "ReComposeScopeLearn: 1")

    Column {
        Log.d(TAG, "ReComposeScopeLearn: 2")
        Text(name, Modifier.clickable {
            name = "greatandok"
        })
        scope1()
        scope2(name)
    }
}

@Composable
fun scope1() {
    Text("scope1")
    Log.d(TAG, "ReComposeScopeLearn: 3")
}

@Composable
fun scope2(name: String) {
    Text("scope1 $name")
    Log.d(TAG, "ReComposeScopeLearn: 4")
}

@Composable
fun scope3(name: String) {

}

