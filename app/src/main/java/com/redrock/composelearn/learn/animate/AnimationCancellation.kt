package com.redrock.composelearn.learn.animate

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

/**
 * Author by OkAndGreat
 * Date on 2022/11/27 20:20.
 *
 */
@Composable
fun AnimationCancellation() {
    val anim = remember { Animatable(0.dp, Dp.VectorConverter) }
    var padding = 0.dp
    val decay = rememberSplineBasedDecay<Dp>()
    LaunchedEffect(Unit) {
        delay(1000)
        anim.animateDecay(1000.dp, decay) {
            padding = value
        }
    }

    Box(
        Modifier
            .padding(0.dp, anim.value, 0.dp, 0.dp)
            .size(100.dp)
            .background(Color.Green)
    )
}