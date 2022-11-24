package com.redrock.composelearn.codelab.basiclayouts

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Author by OkAndGreat
 * Date on 2022/11/24 14:09.
 *
 */
data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)
