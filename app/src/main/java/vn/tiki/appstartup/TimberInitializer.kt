package vn.tiki.appstartup

import android.content.Context
import androidx.startup.Initializer
import timber.log.Timber
import timber.log.Timber.DebugTree
import vn.tiki.BuildConfig


/**
 * Created by phatvt2 on 8/7/20
 */

class TimberInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()

}