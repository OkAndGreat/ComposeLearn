package com.redrock.composelearn

import android.os.Bundle
import android.view.animation.Animation
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.redrock.composelearn.learn.animate.*
import com.redrock.composelearn.ui.theme.ComposeLearnTheme

class MainActivity2 : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearnTheme {
//                BasicWidget()
//                rememberLearn()
//                ReComposeScopeLearn()
//                DerivedState()
//                compositionLocal()
//                AnimateAsState()
//                AnimatableLearn()
//                TweenSpecLearn()
//                KeyframeSpecLearn()
//                SpringSpecLearn()
//                RepeatableSpecLearn()
                AnimationCancellation()
            }
        }
    }

}