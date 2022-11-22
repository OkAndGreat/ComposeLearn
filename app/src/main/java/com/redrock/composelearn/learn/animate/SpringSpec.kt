package com.redrock.composelearn.learn.animate

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Spring.StiffnessLow
import androidx.compose.animation.core.Spring.StiffnessMedium
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.spring
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
 * Date on 2022/11/22 18:45.
 *
 */

@Composable
fun SpringSpecLearn() {
    var big by remember { mutableStateOf(false) }
    val size = remember(big) { if (big) 96.dp else 48.dp }

    val anim = remember { Animatable(size, Dp.VectorConverter) }

    LaunchedEffect(big) {
        anim.animateTo(size, spring(Spring.DampingRatioHighBouncy, StiffnessLow))

        //炸弹效果
        anim.animateTo(48.dp, spring(Spring.DampingRatioHighBouncy, StiffnessMedium), 2000.dp)
    }

    Box(
        Modifier.size(anim.value)
            .background(Color.Green).clickable {
                big = !big
            }
    )
}