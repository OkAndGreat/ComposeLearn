package com.redrock.composelearn.learn.Transition

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Author by OkAndGreat
 * Date on 2022/11/27 21:31.
 *
 */
@Composable
fun TransitionSquare() {
    var big by remember { mutableStateOf(false) }
    val transition = updateTransition(big, label = "big")
    val size by transition.animateDp({
        when {
            //根据状态选择不同的AnimationSpec
            false isTransitioningTo true -> spring()
            else -> tween()
        }
    }, label = "size") { if (it) 96.dp else 48.dp }
    val corner by transition.animateDp(label = "corner") { if (it) 0.dp else 18.dp }
//    val size by animateDpAsState(if (big) 96.dp else 58.dp)
//    val corner by animateDpAsState(if (big) 0.dp else 18.dp)


    Box(
        Modifier
            .size(size)
            .clip(RoundedCornerShape(corner))
            .background(Color.Green)
            .clickable {
                big = !big
            }
    )
}