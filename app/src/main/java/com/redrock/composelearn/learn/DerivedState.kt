package com.redrock.composelearn.learn

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


/**
 * Author by OkAndGreat
 * Date on 2022/11/20 21:01.
 *
 */

private const val TAG = "derivedState"

var ref: Any? = null
var ref1: Any? = null

@SuppressLint("UnrememberedMutableState")
@Composable
fun DerivedState() {
    //带参数的remember和derivedStateOf的区别在这里体现不出
//    var name by remember { mutableStateOf("okandgreat") }
//    val processedName by remember(name) { derivedStateOf { name.uppercase() } }
//    val processedNameWithoutDerivedState = remember(name) { name.uppercase() }
//    Text(processedNameWithoutDerivedState, Modifier.clickable { name = "greatandok" })

    val names = remember { mutableStateListOf("okandgreat", "okandgreat1") }
    //第一种写法监听不到names的变化
    //而第二种写法又可以
//    val processedNames = remember(names) {  names.map { it.uppercase() } }
    val processedNames by remember() { derivedStateOf { names.map { it.uppercase() } } }
    Column {
        for (name in processedNames) {
            Text(name, Modifier.clickable {
                names.add("okandgreat2")
            })
        }
    }

    val useRem = remember { mutableStateOf("UseRemember") }
    UseRemember(useRem) { useRem.value = "Changed UseRemember" }

}

@Composable
private fun UseRemember(value: State<String>, onClick: () -> Unit) {
    val derivedValue by remember { derivedStateOf { value.value.uppercase() } }
//    val rememberValue = remember(value) { value.uppercase() }

    Text(derivedValue, Modifier.padding(100.dp).clickable { onClick.invoke() })
}

@Composable
private fun UseDerive(value: List<String>) {
    val processedValue = remember(value) { derivedStateOf { value.map { it.uppercase() } } }
}

/**
 * Use derivedStateOf when a certain state is calculated or derived from other state objects.
 * Using this function guarantees that the calculation will only occur whenever one of the states used in the calculation changes.
 */
//@Composable
//fun TodoList(highPriorityKeywords: List<String> = listOf("Review", "Unblock", "Compose")) {
//
//    val todoTasks = remember { mutableStateListOf<String>() }
//
//    // Calculate high priority tasks only when the todoTasks or highPriorityKeywords
//    // change, not on every recomposition
//
//    val highPriorityTasks by remember(highPriorityKeywords) {
//        derivedStateOf { todoTasks.filter { it.containsWord(highPriorityKeywords) } }
//    }
//
//    Box(Modifier.fillMaxSize()) {
//        LazyColumn {
//            items(highPriorityTasks) { /* ... */ }
//            items(todoTasks) { /* ... */ }
//        }
//        /* Rest of the UI where users can add elements to the list */
//    }
//}