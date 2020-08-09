package vn.tiki.home.presentation.ui.processor

import androidx.lifecycle.LiveData
import timber.log.Timber
import vn.tiki.domain.model.Result
import vn.tiki.extensions.exhaustive
import vn.tiki.home.domain.model.QuickLinkDomainModel
import vn.tiki.home.domain.usecase.GetQuickLinksUseCase
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.model.LoadingItem
import vn.tiki.home.presentation.ui.model.QuickLinksItem
import vn.tiki.home.presentation.ui.type.HomeItemViewType
import javax.inject.Inject

/**
 * Created by phatvt2 on 8/9/20
 */

class QuickLinksItemFetcher @Inject constructor(
    private val getQuickLinksUseCase: GetQuickLinksUseCase
) : HomeItemFetcher {

    private val _source = HomeItemLiveData()

    override val source: LiveData<List<HomeItem>>
        get() = _source

    override suspend fun fetch() {
        val loadingItem = LoadingItem(HomeItemViewType.QUICK_LINKS)
        _source.set(loadingItem)
        val quickLinksResult = getQuickLinksUseCase()
        _source.remove(loadingItem)
        when (quickLinksResult) {
            is Result.Success -> {
                val quickLinkItems = quickLinksResult.data.map {
                    it.map(QuickLinkDomainModel::toQuickLinkItem)
                }
                val quickLinksItem = QuickLinksItem(quickLinkItems)
                _source.add(quickLinksItem)
            }
            is Result.Error -> Timber.d(quickLinksResult.exception)
        }.exhaustive
    }

}