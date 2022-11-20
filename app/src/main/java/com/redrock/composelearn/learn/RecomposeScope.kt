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

@Composable
fun ReComposeScopeLearn() {

    var name by remember { mutableStateOf("okandgreat") }


    Log.d(TAG, "ReComposeScopeLearn: 1")

    var user1 = User("")
    var user2 = User("")
    var user = User("okandgreat")

    Column {
        Log.d(TAG, "ReComposeScopeLearn: 2")
        Text(name, Modifier.clickable {
            name = "greatandok"
        })
        Scope1()
        Scope2(name)
        Scope3(user)
    }
}

@Composable
fun Scope1() {
    Text("scope1")
    Log.d(TAG, "ReComposeScopeLearn: 3")
}

@Composable
fun Scope2(name: String) {
    Text("scope2 $name")
    Log.d(TAG, "ReComposeScopeLearn: 4")
}

@Composable
fun Scope3(user: User) {
    Text("scope3 ${user.name}")
    Log.d(TAG, "ReComposeScopeLearn: 5")
}

//class User(name: String) {
//    val name by mutableStateOf(name)
//}

@Immutable
class User(var name: String) {}