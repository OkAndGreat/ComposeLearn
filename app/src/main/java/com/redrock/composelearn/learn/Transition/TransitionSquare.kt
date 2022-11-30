package com.redrock.composelearn.learn.Transition

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

/**
 * Author by OkAndGreat
 * Date on 2022/11/27 21:31.
 *
 */


@Preview
@Composable
fun TransitionSquare() {
    var big by remember { mutableStateOf(false) }
    val transition =
        updateTransition(MutableTransitionState(big).apply { targetState = true }, label = "big")
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedVisibilityColumn() {
    Card(Modifier.fillMaxSize()) {
        var expanded by remember { mutableStateOf(false) }
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AnimatedVisibility(expanded, enter = fadeIn(tween(durationMillis = 5000), 0.3f)) {
                TransitionSquare()
            }
            AnimatedVisibility(
                expanded,
                enter = slideIn(
                    tween(durationMillis = 5000),
                    initialOffset = { fullSize: IntSize ->
                        //fullSize是动画元素的宽高
                        IntOffset(
                            -fullSize.width,
                            -fullSize.height
                        )
                    })
            ) {
                TransitionSquare()
            }
            AnimatedVisibility(
                expanded,
                enter = scaleIn(
                    tween(durationMillis = 5000),
                    //从x = 0 y = 0 开始伸缩
                    transformOrigin = TransformOrigin(0f, 0f)
                )
            ) {
                TransitionSquare()
            }
            AnimatedVisibility(
                expanded,
                // expandFrom可以控制从哪里开始裁切
                enter = expandIn(tween(durationMillis = 5000), expandFrom = Alignment.TopCenter)
            ) {
                TransitionSquare()
            }
            Button(onClick = { expanded = !expanded }) {
                Text("start")
            }
        }
    }
}

@Composable
fun CrossFadeLearn() {
    Column {
        var expanded by remember { mutableStateOf(true) }
        Crossfade(expanded) {
            //必须要使用it 而不能使用expanded
            if (it) {
                TransitionSquare()
            } else {
                Box(Modifier.size(24.dp).background(Color.Red))
            }
        }
        Button(onClick = { expanded = !expanded }) {
            Text("start")
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentLearn() {
    Column {
        var expanded by remember { mutableStateOf(true) }
        AnimatedContent(expanded) {
            //必须要使用it 而不能使用expanded
            if (it) {
                TransitionSquare()
            } else {
                Box(Modifier.size(24.dp).background(Color.Red))
            }
        }
        Button(onClick = { expanded = !expanded }) {
            Text("start")
        }
    }
}