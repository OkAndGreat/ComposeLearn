package com.redrock.composelearn.codelab.basiccodelab

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.redrock.composelearn.BaseComposeActivity
import com.redrock.composelearn.codelab.basiccodelab.ui.RealContentScreen
import com.redrock.composelearn.ui.theme.ComposeLearnTheme

class BasicActivity : BaseComposeActivity() {
    companion object {
        const val TAG = "BasicActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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