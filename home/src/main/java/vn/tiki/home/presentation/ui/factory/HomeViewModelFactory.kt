package vn.tiki.home.presentation.ui.factory

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import vn.tiki.coroutines.CoroutinesDispatcherProvider
import vn.tiki.home.domain.usecase.GetBannersUseCase
import vn.tiki.home.domain.usecase.GetQuickLinksUseCase
import vn.tiki.home.presentation.ui.viewmodel.HomeViewModel
import javax.inject.Inject

/**
 * Created by phatvt2 on 8/5/20
 */

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory @Inject constructor(
    activity: Activity,
    private val dispatcherProvider: CoroutinesDispatcherProvider,
    private val getBannersUseCase: GetBannersUseCase,
    private val getQuickLinksUseCase: GetQuickLinksUseCase
) : AbstractSavedStateViewModelFactory(activity as SavedStateRegistryOwner, Bundle.EMPTY) {
    override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        require(modelClass == HomeViewModel::class.java) {
            "Invalid viewModel class: ${modelClass.simpleName}"
        }
        return HomeViewModel(dispatcherProvider, getBannersUseCase, getQuickLinksUseCase) as T
    }
}