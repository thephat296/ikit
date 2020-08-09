package vn.tiki.home.presentation.ui.factory

import android.view.View
import vn.tiki.home.R
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.type.HomeItemViewType
import vn.tiki.home.presentation.ui.viewholder.BannersViewHolder
import vn.tiki.home.presentation.ui.viewholder.FlashDealsViewHolder
import vn.tiki.home.presentation.ui.viewholder.HomeViewHolder
import vn.tiki.home.presentation.ui.viewholder.QuickLinksViewHolder
import javax.inject.Inject

/**
 * Created by phatvt2 on 8/6/20
 */

class HomeViewHolderFactoryImpl @Inject constructor() : HomeViewHolderFactory {
    override fun getLayoutId(type: Int): Int = when (type) {
        HomeItemViewType.BANNERS -> R.layout.item_banners
        HomeItemViewType.QUICK_LINKS -> R.layout.item_quicklinks
        HomeItemViewType.FLASH_DEALS -> R.layout.item_flashdeals
        else -> throw IllegalArgumentException()
    }

    override fun getViewHolder(type: Int, view: View): HomeViewHolder<HomeItem> = when (type) {
        HomeItemViewType.BANNERS -> BannersViewHolder(view)
        HomeItemViewType.QUICK_LINKS -> QuickLinksViewHolder(view)
        HomeItemViewType.FLASH_DEALS -> FlashDealsViewHolder(view)
        else -> throw IllegalArgumentException()
    }
}