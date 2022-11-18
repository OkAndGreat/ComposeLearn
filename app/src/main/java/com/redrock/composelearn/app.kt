package com.redrock.composelearn

import android.app.Application
import android.content.Context

/**
 * Author by OkAndGreat
 * Date on 2022/11/18 18:10.
 *
 */
class app : Application() {

    companion object {

        @JvmStatic
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}