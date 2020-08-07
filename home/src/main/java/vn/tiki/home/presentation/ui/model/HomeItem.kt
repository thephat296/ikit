package vn.tiki.home.presentation.ui.model

import vn.tiki.home.presentation.ui.type.HomeItemViewType

/**
 * Created by phatvt2 on 8/5/20
 */

interface HomeItem {
    @HomeItemViewType
    val viewType: Int
}