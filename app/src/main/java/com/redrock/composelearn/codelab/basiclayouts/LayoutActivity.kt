package com.redrock.composelearn.codelab.basiclayouts

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redrock.composelearn.BaseComposeActivity
import com.redrock.composelearn.codelab.basiclayouts.ui.HomeScreen
import com.redrock.composelearn.codelab.basiclayouts.ui.SootheBottomNavigation
import com.redrock.composelearn.ui.theme.ComposeLearnTheme

/**
 * Author by OkAndGreat
 * Date on 2022/11/24 11:07.
 *
 */
class LayoutActivity : BaseComposeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { myApp() }
    }

    @Composable
    fun myApp() {
        ComposeLearnTheme {
            Scaffold(bottomBar = { SootheBottomNavigation() }) { paddingValues ->
                HomeScreen(Modifier.padding(paddingValues))
            }
        }
    }
}