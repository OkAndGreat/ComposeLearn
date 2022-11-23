package com.redrock.composelearn.codelab.basiccodelab

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redrock.composelearn.ui.theme.ComposeLearnTheme

class BasicActivity : ComponentActivity() {
    companion object {
        const val TAG = "BasicActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //修改状态栏
            //需要导库
            //implementation "com.google.accompanist:accompanist-systemuicontroller:0.18.0"
            val systemUiController = rememberSystemUiController()
            systemUiController.setStatusBarColor(
                Color.Transparent, darkIcons = MaterialTheme.colors.isLight
            )

            ComposeLearnTheme {
                MyApp()
            }
        }
    }

    @Composable
    fun MyApp() {
        var shouldShowOnBoardingScreen by rememberSaveable { mutableStateOf(true) }
        Log.d(TAG, "MyApp: $shouldShowOnBoardingScreen")
        Surface(Modifier.fillMaxSize()) {
            if (shouldShowOnBoardingScreen) {
                OnBoardingScreen(onClick = {
                    shouldShowOnBoardingScreen = false
                })
            } else {
                RealContentScreen { index, names ->
                    names[index].expanded = !names[index].expanded
                }
            }
        }
    }
}