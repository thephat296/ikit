package vn.tiki.home.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import vn.tiki.coroutines.CoroutinesDispatcherProvider
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.model.LoadingItem
import vn.tiki.home.presentation.ui.processor.BannersItemFetcher
import vn.tiki.home.presentation.ui.processor.FlashDealsItemFetcher
import vn.tiki.home.presentation.ui.processor.QuickLinksItemFetcher

/**
 * Created by phatvt2 on 8/5/20
 */

class HomeViewModel(
    private val dispatcherProvider: CoroutinesDispatcherProvider,
    private val bannersItemFetcher: BannersItemFetcher,
    private val quickLinksItemFetcher: QuickLinksItemFetcher,
    private val flashDealsItemFetcher: FlashDealsItemFetcher
) : ViewModel() {

    private val sources = arrayListOf<LiveData<HomeItem>>()
    private val _homeItems = MediatorLiveData<List<HomeItem>>()
    val homeItems: LiveData<List<HomeItem>> = _homeItems

    init {
        addItemSource(bannersItemFetcher.source)
        addItemSource(quickLinksItemFetcher.source)
        addItemSource(flashDealsItemFetcher.source)
        fetchHomeItems()
    }

    private fun addItemSource(source: LiveData<HomeItem>) {
        sources.add(source)
        _homeItems.addSource(source) {
            updateItems()
        }
    }

    private fun updateItems() {
        val items = arrayListOf<HomeItem>()
        for (source in sources) {
            source.value?.let(items::add)
            if (items.lastOrNull() is LoadingItem) {
                break
            }
        }
        _homeItems.value = items
    }

    fun fetchHomeItems() {
        viewModelScope.launch {
            val bannersDeferred = async(dispatcherProvider.io) {
                bannersItemFetcher.fetch()
            }
            val quickLinksDeferred = async(dispatcherProvider.io) {
                quickLinksItemFetcher.fetch()
            }
            bannersDeferred.await()
            quickLinksDeferred.await()
            withContext(dispatcherProvider.io) {
                flashDealsItemFetcher.fetch()
            }
        }
    }
}