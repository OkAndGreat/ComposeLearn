package com.redrock.composelearn.learn

import android.util.Log
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

@Composable
fun derivedState() {
    var name by remember { mutableStateOf("okandgreat") }
    val processedName by remember(name) { derivedStateOf { name.uppercase() } }
    val procrssedNameWithoutDerivedState = remember(name) { name.uppercase() }
    Text(processedName, Modifier.clickable { name = "greatandok" })


//    val names = remember { mutableStateListOf("okandgreat", "okandgreat1") }
    val names by remember { derivedStateOf { mutableStateListOf("okandgreat", "okandgreat1") } }
    ref?.let {
        Log.d(
            TAG,
            "derivedState: oldnames == newnames -> ${ref == names} oldnames === newnames -> ${ref === names}"
        )
    }
    ref = names
    val processedNames = remember(names) { names.map { it.uppercase() } }
    Column {
        for (name in processedNames) {
            Text(name, Modifier.clickable {
                names.add("greatandok")
            })
        }
    }


    var string by remember { mutableStateOf("okandgreat") }
    ref1?.let {
        Log.d(
            TAG,
            "derivedState: oldnames == newnames -> ${ref == names} oldnames === newnames -> ${ref === names}"
        )
    }
    ref1 = string
    Column {
        Text(string, Modifier.clickable {
            string = "greatandok"
        }.padding(100.dp))
    }
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