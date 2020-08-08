package vn.tiki.home.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import timber.log.Timber
import vn.tiki.coroutines.CoroutinesDispatcherProvider
import vn.tiki.domain.model.Result
import vn.tiki.extensions.exhaustive
import vn.tiki.home.domain.model.BannerDomainModel
import vn.tiki.home.domain.usecase.GetBannersUseCase
import vn.tiki.home.domain.usecase.GetQuickLinksUseCase
import vn.tiki.home.presentation.ui.model.BannersItem
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.model.LoadingItem

/**
 * Created by phatvt2 on 8/5/20
 */

class HomeViewModel(
    private val dispatcherProvider: CoroutinesDispatcherProvider,
    private val getBannersUseCase: GetBannersUseCase,
    private val getQuickLinksUseCase: GetQuickLinksUseCase
) : ViewModel() {

    fun getHomeItems(): LiveData<List<HomeItem>> = liveData(viewModelScope.coroutineContext + dispatcherProvider.io) {
        val resultItems = mutableListOf<HomeItem>()

        val bannersLoadingItem = LoadingItem()
        resultItems.add(bannersLoadingItem)
        emit(resultItems.toList())
        val bannersResult = getBannersUseCase()
        resultItems.remove(bannersLoadingItem)
        when (bannersResult) {
            is Result.Success -> {
                val bannerItems = bannersResult.data.map(BannerDomainModel::toBannerItem)
                val bannersItem = BannersItem(bannerItems)
                resultItems.add(bannersItem)
                emit(resultItems.toList())
            }
            is Result.Error -> Timber.d(bannersResult.exception)
        }.exhaustive
    }
}