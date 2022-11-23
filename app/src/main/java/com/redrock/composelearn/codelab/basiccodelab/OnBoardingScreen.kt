package com.redrock.composelearn.codelab.basiccodelab

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Author by OkAndGreat
 * Date on 2022/11/23 21:41.
 */


@Composable
fun OnBoardingScreen(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Surface(Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("点击下方进入正式页面 👇")
            Spacer(Modifier.height(10.dp))
            Button(onClick = onClick) {
                Text("button")
            }
        }
    }
}

@Composable
@Preview
fun OnBoardingScreenPreview() {
    OnBoardingScreen(onClick = {})
}