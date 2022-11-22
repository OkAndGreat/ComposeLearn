package com.redrock.composelearn.learn.animate

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.keyframes
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
 * Date on 2022/11/22 17:42.
 *
 */

@Composable
fun KeyframeSpecLearn() {
    var big by remember { mutableStateOf(false) }
    val size = remember(big) { if (big) 96.dp else 48.dp }

    val anim = remember { Animatable(size, Dp.VectorConverter) }

    LaunchedEffect(big) {
        anim.animateTo(size, keyframes {
            durationMillis = 450
            delayMillis = 100
            //表示在150ms时变到144dp 同时使用with中缀函数指定速度曲线 若不填则默认是线性变化
            144.dp at 150 with FastOutSlowInEasing //一定要注意这里是150到300ms的速度曲线 而不是 0-150ms的
            //表示在300ms时变到20dp
            20.dp at 300
        })
    }

    Box(
        Modifier.size(anim.value)
            .background(Color.Green).clickable {
                big = !big
            }
    )
}