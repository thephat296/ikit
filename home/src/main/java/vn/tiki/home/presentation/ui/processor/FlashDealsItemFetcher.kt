package vn.tiki.home.presentation.ui.processor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import timber.log.Timber
import vn.tiki.domain.model.Result
import vn.tiki.extensions.exhaustive
import vn.tiki.home.domain.model.FlashDealDomainModel
import vn.tiki.home.domain.usecase.GetFlashDealsUseCase
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.model.LoadingItem
import vn.tiki.home.presentation.ui.model.flashdeal.FlashDealsItem
import vn.tiki.home.presentation.ui.type.HomeItemViewType
import javax.inject.Inject

/**
 * Created by phatvt2 on 8/9/20
 */

class FlashDealsItemFetcher @Inject constructor(
    private val getFlashDealsUseCase: GetFlashDealsUseCase
) : HomeItemFetcher {

    private val _source = MutableLiveData<HomeItem>()

    override val source: LiveData<HomeItem>
        get() = _source

    override suspend fun fetch() {
        _source.postValue(LoadingItem(HomeItemViewType.FLASH_DEALS))
        when (val result = getFlashDealsUseCase()) {
            is Result.Success -> {
                val flashDealsItem = FlashDealsItem(
                    result.data.map(FlashDealDomainModel::toFlashDealItem)
                )
                _source.postValue(flashDealsItem)
            }
            is Result.Error -> {
                Timber.d(result.exception)
                _source.postValue(null)
            }
        }.exhaustive
    }
}