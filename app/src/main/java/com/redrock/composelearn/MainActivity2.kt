package com.redrock.composelearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import com.redrock.composelearn.learn.*
import com.redrock.composelearn.ui.theme.ComposeLearnTheme

class MainActivity2 : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearnTheme {
//                BasicWidget()
//                rememberLearn()
//                ReComposeScopeLearn()
                DerivedState()
            }
        }
    }

}