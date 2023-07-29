package com.redrock.composelearn.codelab.basiclayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redrock.composelearn.codelab.basiclayouts.ui.HomeScreen
import com.redrock.composelearn.codelab.basiclayouts.ui.SootheBottomNavigation
import com.redrock.composelearn.ui.theme.ComposeLearnTheme

/**
 * Author by OkAndGreat
 * Date on 2022/11/24 11:07.
 *
 */
class LayoutActivity : ComponentActivity() {

    private lateinit var bottomViewModel: BottomViewModel

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

            MyApp()
        }
    }

    @Composable
    fun MyApp() {
        ComposeLearnTheme {
            bottomViewModel = viewModel()
            Scaffold(bottomBar = {
                SootheBottomNavigation(select = bottomViewModel.bottomSelected.value, onBottomItemClicked =
                {
                bottomViewModel.bottomSelected.value = it
                })
            }) { paddingValues ->
                HomeScreen(Modifier.padding(paddingValues))
            }
        }
    }
}