package com.redrock.composelearn.learn

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Author by OkAndGreat
 * Date on 2022/11/21 16:22.
 *
 */

val localName = compositionLocalOf<String> { error("No default value provided") }
val localActivity = compositionLocalOf<Activity> { error("No default value provided") }
val localBackground = compositionLocalOf<Color> { error("No default value provided") }

@Composable
fun compositionLocal() {
    Column {
        CompositionLocalProvider(localBackground provides Color.Green) {
            Widget1()
            CompositionLocalProvider(localBackground provides Color.Cyan) {
                Widget1()
            }
        }

        CompositionLocalProvider(localName provides "okandgreat"){
            TextWidget()
        }

    }
}

@Composable
fun TextWidget() {
    Text(localName.current)
}


@Composable
fun Widget1() {
    Column(Modifier.fillMaxWidth()) {
        Widget2()
    }
}

@Composable
fun Widget2() {
    Button(onClick = {}, Modifier.background(localBackground.current), content = {
        Text("button")
    })
}


