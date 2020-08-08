package vn.tiki.home.presentation.ui.viewholder

import android.view.View
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_banners.view.*
import vn.tiki.extensions.hide
import vn.tiki.extensions.show
import vn.tiki.home.presentation.ui.adapter.BannerAdapter
import vn.tiki.home.presentation.ui.model.BannerItem
import vn.tiki.home.presentation.ui.model.BannersItem
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.model.LoadingItem

/**
 * Created by phatvt2 on 8/6/20
 */

class BannersViewHolder(override val containerView: View) :
    HomeViewHolder<HomeItem>(containerView),
    LayoutContainer {

    override fun bindView(item: HomeItem) {
        when (item) {
            is LoadingItem -> containerView.progressBar.show()
            is BannersItem -> bindBannersView(item.banners)
            else -> throw IllegalArgumentException()
        }
    }

    private fun bindBannersView(items: List<BannerItem>) {
        containerView.progressBar.hide()
        containerView.rvBanner.adapter = BannerAdapter().apply {
            submitList(items)
        }
    }
}