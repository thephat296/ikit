package vn.tiki.home.presentation.di.component

import android.app.Activity
import dagger.BindsInstance
import dagger.Component
import vn.tiki.di.component.AppComponent
import vn.tiki.di.scope.FeatureScope
import vn.tiki.home.presentation.di.module.HomeModule
import vn.tiki.home.presentation.ui.fragment.HomeFragment

@Component(modules = [HomeModule::class], dependencies = [AppComponent::class])
@FeatureScope
interface HomeComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: Activity): Builder

        fun appComponent(appComponent: AppComponent): Builder

        fun build(): HomeComponent
    }

    fun inject(fragment: HomeFragment)

    companion object {
        fun create(activity: Activity, appComponent: AppComponent): HomeComponent =
            DaggerHomeComponent
                .builder()
                .activity(activity)
                .appComponent(appComponent)
                .build()
    }
}
