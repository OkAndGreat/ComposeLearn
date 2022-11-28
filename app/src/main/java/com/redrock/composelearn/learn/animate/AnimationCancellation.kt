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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Author by OkAndGreat
 * Date on 2022/11/27 20:20.
 *
 */
@Composable
fun AnimationCancellation() {
    val anim = remember { Animatable(0.dp, Dp.VectorConverter) }
    anim.updateBounds(0.dp, 100.dp)
    val padding = remember { mutableStateOf(0.dp) }
    val decay = rememberSplineBasedDecay<Dp>()
    LaunchedEffect(Unit) {
//        delay(1000)
        anim.animateDecay(2000.dp, decay) {
            padding.value = value
        }
    }


//    LaunchedEffect(Unit) {
//        delay(1100)
//        anim.stop()
//    }

    Box(
        Modifier
            .padding(0.dp, padding.value, 0.dp, 0.dp)
            .size(100.dp)
            .background(Color.Green)
    )
}