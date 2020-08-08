package vn.tiki.home.presentation.ui.model

import vn.tiki.home.presentation.ui.type.HomeItemViewType

/**
 * Created by phatvt2 on 8/7/20
 */

class LoadingItem : HomeItem {
    override val viewType: Int
        get() = HomeItemViewType.LOADING
}