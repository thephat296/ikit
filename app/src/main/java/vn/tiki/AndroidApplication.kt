package vn.tiki

import com.google.android.play.core.splitcompat.SplitCompatApplication
import vn.tiki.di.component.AppComponent

/**
 * Created by phatvt2 on 8/4/20
 */

class AndroidApplication : SplitCompatApplication() {
    lateinit var appComponent: AppComponent
        private set

    init {
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.create(this)
    }

    companion object {
        lateinit var INSTANCE: AndroidApplication
            private set
    }
}