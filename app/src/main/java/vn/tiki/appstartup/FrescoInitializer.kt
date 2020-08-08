package vn.tiki.appstartup

import android.content.Context
import androidx.startup.Initializer
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by phatvt2 on 8/8/20
 */

class FrescoInitializer : Initializer<Unit> {
    override fun create(context: Context) = Fresco.initialize(context)

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()
}