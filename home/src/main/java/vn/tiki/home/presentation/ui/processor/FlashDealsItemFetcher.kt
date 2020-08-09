package vn.tiki.home.presentation.ui.processor

import androidx.lifecycle.LiveData
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

    private val _source = HomeItemLiveData()

    override val source: LiveData<List<HomeItem>>
        get() = _source

    override suspend fun fetch() {
        val loadingItem = LoadingItem(HomeItemViewType.FLASH_DEALS)
        _source.set(loadingItem)
        val flashDealsResult = getFlashDealsUseCase()
        _source.remove(loadingItem)

        when (flashDealsResult) {
            is Result.Success -> {
                val flashDealItems = flashDealsResult.data.map(FlashDealDomainModel::toFlashDealItem)
                val flashDealsItem = FlashDealsItem(flashDealItems)
                _source.add(flashDealsItem)
            }
            is Result.Error -> Timber.d(flashDealsResult.exception)
        }.exhaustive
    }
}