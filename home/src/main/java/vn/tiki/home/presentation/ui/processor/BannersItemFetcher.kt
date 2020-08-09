package vn.tiki.home.presentation.ui.processor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import timber.log.Timber
import vn.tiki.domain.model.Result
import vn.tiki.extensions.exhaustive
import vn.tiki.home.domain.model.BannerDomainModel
import vn.tiki.home.domain.usecase.GetBannersUseCase
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.model.LoadingItem
import vn.tiki.home.presentation.ui.model.banner.BannersItem
import vn.tiki.home.presentation.ui.type.HomeItemViewType
import javax.inject.Inject

/**
 * Created by phatvt2 on 8/9/20
 */

class BannersItemFetcher @Inject constructor(
    private val getBannersUseCase: GetBannersUseCase
) : HomeItemFetcher {

    private val _source = MutableLiveData<HomeItem>()

    override val source: LiveData<HomeItem>
        get() = _source

    override suspend fun fetch() {
        _source.postValue(LoadingItem(HomeItemViewType.BANNERS))
        when (val result = getBannersUseCase()) {
            is Result.Success -> {
                val bannersItem = BannersItem(
                    result.data.map(BannerDomainModel::toBannerItem)
                )
                _source.postValue(bannersItem)
            }
            is Result.Error -> {
                Timber.d(result.exception)
                _source.postValue(null)
            }
        }.exhaustive
    }
}