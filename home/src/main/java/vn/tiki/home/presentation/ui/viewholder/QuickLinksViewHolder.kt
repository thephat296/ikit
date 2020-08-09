package vn.tiki.home.presentation.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_quicklinks.view.*
import vn.tiki.extensions.setShow
import vn.tiki.home.presentation.ui.adapter.QuickLinkAdapter
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.model.LoadingItem
import vn.tiki.home.presentation.ui.model.quicklink.QuickLinkItem
import vn.tiki.home.presentation.ui.model.quicklink.QuickLinksItem

/**
 * Created by phatvt2 on 8/8/20
 */

class QuickLinksViewHolder(override val containerView: View) :
    HomeViewHolder<HomeItem>(containerView),
    LayoutContainer {

    override fun bindView(item: HomeItem) {
        containerView.progressBar.setShow(item is LoadingItem)
        containerView.rvQuickLink.setShow(item is QuickLinksItem)
        (item as? QuickLinksItem)?.let {
            bindQuickLinksView(it.quickLinks, it.spanCount)
        }
    }

    private fun bindQuickLinksView(quickLinks: List<QuickLinkItem>, spanCount: Int) {
        with(containerView.rvQuickLink) {
            setHasFixedSize(true)
            layoutManager =
                GridLayoutManager(containerView.context, spanCount, GridLayoutManager.HORIZONTAL, false)
            adapter = QuickLinkAdapter().apply {
                submitList(quickLinks)
            }
        }
    }
}