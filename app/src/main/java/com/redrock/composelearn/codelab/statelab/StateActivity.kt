package com.redrock.composelearn.codelab.statelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Author by OkAndGreat
 * Date on 2022/11/24 19:49.
 *
 */
class StateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                WellnessScreen()
            }
        }
    }

    @Composable
    fun WellnessScreen(
        modifier: Modifier = Modifier,
        wellnessViewModel: StateViewModel = viewModel()
    ) {
        Column(modifier = modifier) {
            StatefulCounter()

            WellnessTasksList(
                list = wellnessViewModel.tasks,
                onCheckedTask = { task, checked ->
                    wellnessViewModel.changeTaskChecked(task, checked)
                },
                onCloseTask = { task ->
                    wellnessViewModel.remove(task)
                }
            )
        }
    }

    @Composable
    fun WellnessTasksList(
        list: List<WellnessTask>,
        onCheckedTask: (WellnessTask, Boolean) -> Unit,
        onCloseTask: (WellnessTask) -> Unit,
        modifier: Modifier = Modifier
    ) {
        LazyColumn(
            modifier = modifier
        ) {
            items(
                items = list,
                /**
                 * Use key param to define unique keys representing the items in a mutable list,
                 * instead of using the default key (list position). This prevents unnecessary
                 * recompositions.
                 */
                /**
                 * Use key param to define unique keys representing the items in a mutable list,
                 * instead of using the default key (list position). This prevents unnecessary
                 * recompositions.
                 */
                key = { task -> task.id }
            ) { task ->
                WellnessTaskItem(
                    taskName = task.label,
                    checked = task.checked,
                    onCheckedChange = { checked -> onCheckedTask(task, checked) },
                    onClose = { onCloseTask(task) }
                )
            }
        }
    }

    @Composable
    fun WellnessTaskItem(
        taskName: String,
        checked: Boolean,
        onCheckedChange: (Boolean) -> Unit,
        onClose: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                text = taskName
            )
            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange
            )
            IconButton(onClick = onClose) {
                Icon(Icons.Filled.Close, contentDescription = "Close")
            }
        }
    }

}