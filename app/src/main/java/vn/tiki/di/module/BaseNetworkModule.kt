package vn.tiki.di.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * Created by phatvt2 on 8/7/20
 */

@Module
class BaseNetworkModule {
    @Singleton
    @Provides
    fun provideBaseOkHttpclient(): OkHttpClient =
        OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()
}