package vn.tiki.home.presentation.ui.processor

import androidx.lifecycle.LiveData
import vn.tiki.home.presentation.ui.model.HomeItem

/**
 * Created by phatvt2 on 8/9/20
 */

interface HomeItemFetcher {
    val source: LiveData<List<HomeItem>>

    suspend fun fetch()
}