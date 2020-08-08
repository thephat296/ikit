package vn.tiki.home.presentation.ui.viewholder

import android.view.View
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_banners.view.*
import vn.tiki.home.presentation.ui.adapter.BannerAdapter
import vn.tiki.home.presentation.ui.model.BannersItem
import vn.tiki.home.presentation.ui.model.HomeItem

/**
 * Created by phatvt2 on 8/6/20
 */

class BannersViewHolder(override val containerView: View) :
    HomeViewHolder<HomeItem>(containerView),
    LayoutContainer {

    override fun bindView(item: HomeItem) {
        containerView.rvBanner.adapter = BannerAdapter().apply {
            submitList((item as BannersItem).banners)
        }
    }
}