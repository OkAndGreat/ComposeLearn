package com.redrock.composelearn.codelab.basiclayouts

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * @author:ztaiwang
 * @date:2023/7/30
 */
class BottomViewModel: ViewModel() {
    val bottomSelected = mutableStateOf(0)

}