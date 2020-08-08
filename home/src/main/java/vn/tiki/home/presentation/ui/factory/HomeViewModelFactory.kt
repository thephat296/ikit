package vn.tiki.home.presentation.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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
    private val dispatcherProvider: CoroutinesDispatcherProvider,
    private val getBannersUseCase: GetBannersUseCase,
    private val getQuickLinksUseCase: GetQuickLinksUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        require(modelClass == HomeViewModel::class.java) {
            "Invalid viewModel class: ${modelClass.simpleName}"
        }
        return HomeViewModel(dispatcherProvider, getBannersUseCase, getQuickLinksUseCase) as T
    }
}