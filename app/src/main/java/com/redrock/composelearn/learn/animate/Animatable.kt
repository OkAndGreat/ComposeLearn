package com.redrock.composelearn.learn.animate

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Author by OkAndGreat
 * Date on 2022/11/22 10:01.
 *
 */

@Composable
fun AnimatableLearn() {
    var big by remember { mutableStateOf(false) }
    var size = remember(big) { if (big) 96.dp else 48.dp }

    val anim = remember { Animatable(size, Dp.VectorConverter) }

    //不会重复执行
    LaunchedEffect(big) {
        anim.snapTo(if(big) 192.dp else 0.dp)
        anim.animateTo(size)
    }

    Box(
        Modifier.size(anim.value)
            .background(Color.Green).clickable {
                big = !big
            }
    )
}