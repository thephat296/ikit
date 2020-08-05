package vn.tiki.home.presentation.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.tiki.di.scope.FeatureScope
import vn.tiki.home.data.api.HomeApiService
import vn.tiki.home.data.repository.HomeRepositoryImpl
import vn.tiki.home.domain.repository.HomeRepository
import javax.inject.Named

/**
 * Created by phatvt2 on 8/5/20
 */

@Module
abstract class HomeModule {

    @Binds
    @FeatureScope
    abstract fun bindHomeRepository(repositoryImpl: HomeRepositoryImpl): HomeRepository

    @Module
    companion object {
        private const val BASE_URL = "https://api.tiki.vn/"

        @Provides
        @FeatureScope
        @JvmStatic
        @Named("HomeRetrofit")
        fun provideHomeRetrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        @Provides
        @FeatureScope
        @JvmStatic
        fun provideHomeApiService(@Named("HomeRetrofit") retrofit: Retrofit): HomeApiService =
            retrofit.create(HomeApiService::class.java)
    }
}