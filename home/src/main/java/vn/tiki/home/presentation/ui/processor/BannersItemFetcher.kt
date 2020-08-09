package vn.tiki.home.presentation.ui.processor

import androidx.lifecycle.LiveData
import timber.log.Timber
import vn.tiki.domain.model.Result
import vn.tiki.extensions.exhaustive
import vn.tiki.home.domain.model.BannerDomainModel
import vn.tiki.home.domain.usecase.GetBannersUseCase
import vn.tiki.home.presentation.ui.model.BannersItem
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.model.LoadingItem
import vn.tiki.home.presentation.ui.type.HomeItemViewType
import javax.inject.Inject

/**
 * Created by phatvt2 on 8/9/20
 */

class BannersItemFetcher @Inject constructor(
    private val getBannersUseCase: GetBannersUseCase
) : HomeItemFetcher {

    private val _source = HomeItemLiveData()

    override val source: LiveData<List<HomeItem>>
        get() = _source

    override suspend fun fetch() {
        val loadingItem = LoadingItem(HomeItemViewType.BANNERS)
        _source.set(loadingItem)
        val bannersResult = getBannersUseCase()
        _source.remove(loadingItem)
        when (bannersResult) {
            is Result.Success -> {
                val bannerItems = bannersResult.data.map(BannerDomainModel::toBannerItem)
                val bannersItem = BannersItem(bannerItems)
                _source.add(bannersItem)
            }
            is Result.Error -> Timber.d(bannersResult.exception)
        }.exhaustive
    }
}