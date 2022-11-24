package com.redrock.composelearn.codelab.statelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Author by OkAndGreat
 * Date on 2022/11/24 17:50.
 * 本Activity旨在说明Compose中重组可能导致的状态丢失以及如果解决这个问题
 */
class StateLostActivity : ComponentActivity() {

    lateinit var viewModel: StateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel = viewModel()
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                WellnessScreen()
            }
        }
    }

    @Composable
    fun WellnessScreen(modifier: Modifier = Modifier) {
        WaterCounter(modifier)
    }


    /**
     * 优秀实践是为所有可组合函数提供默认的 Modifier，从而提高可重用性。
     * 它应作为第一个可选参数显示在参数列表中，位于所有必需参数之后。
     */
    @Composable
    fun WaterCounter(modifier: Modifier = Modifier) {
        Column(modifier = modifier.padding(16.dp)) {
            var count by remember { mutableStateOf(0) }
            if (count > 0) {

                val showTask = viewModel.showTask
                if (showTask) {
                    WellnessTaskItem(
                        onClose = { viewModel.notShowTask() },
                        taskName = "Have you taken your 15 minute walk today?"
                    )
                }
                Text("You've had $count glasses.")
            }

            Row(Modifier.padding(top = 8.dp)) {
                Button(onClick = { count++ }, enabled = count < 10) {
                    Text("Add one")
                }
                Button(onClick = { count = 0 }, Modifier.padding(start = 8.dp)) {
                    Text("Clear water count")
                }
            }
        }
    }

    @Composable
    fun WellnessTaskItem(
        taskName: String,
        onClose: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier, verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f).padding(start = 16.dp),
                text = taskName
            )
            IconButton(onClick = onClose) {
                Icon(Icons.Filled.Close, contentDescription = "Close")
            }
        }
    }
}