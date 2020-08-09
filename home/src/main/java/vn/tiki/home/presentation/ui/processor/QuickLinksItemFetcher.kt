package vn.tiki.home.presentation.ui.processor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import timber.log.Timber
import vn.tiki.domain.model.Result
import vn.tiki.extensions.exhaustive
import vn.tiki.home.domain.model.QuickLinkDomainModel
import vn.tiki.home.domain.usecase.GetQuickLinksUseCase
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.model.LoadingItem
import vn.tiki.home.presentation.ui.model.quicklink.QuickLinksItem
import vn.tiki.home.presentation.ui.type.HomeItemViewType
import javax.inject.Inject

/**
 * Created by phatvt2 on 8/9/20
 */

class QuickLinksItemFetcher @Inject constructor(
    private val getQuickLinksUseCase: GetQuickLinksUseCase
) : HomeItemFetcher {

    private val _source = MutableLiveData<HomeItem>()

    override val source: LiveData<HomeItem>
        get() = _source

    override suspend fun fetch() {
        val loadingItem = LoadingItem(HomeItemViewType.QUICK_LINKS)
        _source.postValue(loadingItem)
        when (val result = getQuickLinksUseCase()) {
            is Result.Success -> {
                val quickLinksItem = QuickLinksItem(
                    result.data.map {
                        it.map(QuickLinkDomainModel::toQuickLinkItem)
                    }
                )
                _source.postValue(quickLinksItem)
            }
            is Result.Error -> {
                Timber.d(result.exception)
                _source.postValue(null)
            }
        }.exhaustive
    }
}