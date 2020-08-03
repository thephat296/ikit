package vn.tiki.di.component

import android.app.Application
import dagger.Component
import vn.tiki.coroutines.CoroutinesDispatcherProvider
import vn.tiki.di.module.ApplicationModule
import vn.tiki.di.module.CoroutineDispatcherModule
import javax.inject.Singleton

/**
 * Created by phatvt2 on 8/4/20
 */

@Singleton
@Component(modules = [ApplicationModule::class, CoroutineDispatcherModule::class])
interface AppComponent {

    val dispatcherProvider: CoroutinesDispatcherProvider

    companion object {
        fun create(application: Application): AppComponent =
            DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(application))
                .build()
    }
}