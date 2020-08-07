package vn.tiki.appstartup

import android.content.Context
import androidx.startup.Initializer
import com.facebook.stetho.Stetho

/**
 * Created by phatvt2 on 8/7/20
 */

class StethoInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        Stetho.initializeWithDefaults(context)
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()
}