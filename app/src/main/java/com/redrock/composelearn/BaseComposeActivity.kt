package com.redrock.composelearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * Author by OkAndGreat
 * Date on 2022/11/23 23:19.
 *
 */
open class BaseComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //修改状态栏
        //需要导库
        //implementation "com.google.accompanist:accompanist-systemuicontroller:0.18.0"
        val systemUiController = rememberSystemUiController()
        systemUiController.setStatusBarColor(
            Color.Transparent, darkIcons = MaterialTheme.colors.isLight
        )
    }

}