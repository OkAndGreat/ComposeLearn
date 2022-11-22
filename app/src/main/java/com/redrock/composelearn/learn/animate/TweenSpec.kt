package com.redrock.composelearn.learn.animate

import androidx.compose.animation.core.*
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
 * Date on 2022/11/22 14:39.
 *
 */

@Composable
fun TweenSpecLearn() {
    var big by remember { mutableStateOf(false) }
    val size = remember(big) { if (big) 96.dp else 48.dp }

    val anim = remember { Animatable(size, Dp.VectorConverter) }

    LaunchedEffect(big) {
//        anim.animateTo(size, TweenSpec(1000, 0, LinearEasing))
//        anim.animateTo(size, tween(1000, 0, LinearEasing))
        anim.animateTo(size, SnapSpec(1000))
    }

    Box(
        Modifier.size(anim.value)
            .background(Color.Green).clickable {
                big = !big
            }
    )
}