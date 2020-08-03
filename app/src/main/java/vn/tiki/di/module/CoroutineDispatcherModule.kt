package vn.tiki.di.module

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import vn.tiki.coroutines.CoroutinesDispatcherProvider
import javax.inject.Singleton

@Module
class CoroutineDispatcherModule {
    @Provides
    @Singleton
    fun provideCoroutineDispatcherProvider(): CoroutinesDispatcherProvider = CoroutinesDispatcherProvider(
        Dispatchers.Main,
        Dispatchers.Default,
        Dispatchers.IO
    )
}
