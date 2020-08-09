package vn.tiki.home.presentation.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import vn.tiki.coroutines.CoroutinesDispatcherProvider
import vn.tiki.home.presentation.ui.processor.BannersItemFetcher
import vn.tiki.home.presentation.ui.processor.FlashDealsItemFetcher
import vn.tiki.home.presentation.ui.processor.QuickLinksItemFetcher
import vn.tiki.home.presentation.ui.viewmodel.HomeViewModel
import javax.inject.Inject

/**
 * Created by phatvt2 on 8/5/20
 */

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory @Inject constructor(
    private val dispatcherProvider: CoroutinesDispatcherProvider,
    private val bannersItemFetcher: BannersItemFetcher,
    private val quickLinksItemFetcher: QuickLinksItemFetcher,
    private val flashDealsItemFetcher: FlashDealsItemFetcher
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        require(modelClass == HomeViewModel::class.java) {
            "Invalid viewModel class: ${modelClass.simpleName}"
        }
        return HomeViewModel(dispatcherProvider, bannersItemFetcher, quickLinksItemFetcher, flashDealsItemFetcher) as T
    }
}