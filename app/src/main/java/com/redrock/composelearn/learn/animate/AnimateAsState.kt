package com.redrock.composelearn.learn.animate

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Author by OkAndGreat
 * Date on 2022/11/22 8:26.
 *
 */

private object SizeState {
    val SMALL_SIZE = 46.dp
    val MIDDLE_SIZE = 96.dp
    val LARGE_SIZE = 142.dp
}

@Composable
fun AnimateAsState() {

    var size by remember { mutableStateOf(SizeState.SMALL_SIZE) }
    val sizeAnim = animateDpAsState(size)

    Box(Modifier.size(sizeAnim.value).clickable {
        if (size == SizeState.SMALL_SIZE) {
            size = SizeState.MIDDLE_SIZE
        } else if (size == SizeState.MIDDLE_SIZE) {
            size = SizeState.LARGE_SIZE
        } else if (size == SizeState.LARGE_SIZE) {
            size = SizeState.SMALL_SIZE
        }
    }.background(Color.Green)) {

    }
}