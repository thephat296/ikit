package vn.tiki.home.presentation.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_quicklinks.view.*
import vn.tiki.home.presentation.ui.adapter.QuickLinkAdapter
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.model.QuickLinksItem

/**
 * Created by phatvt2 on 8/8/20
 */

class QuickLinksViewHolder(override val containerView: View) :
    HomeViewHolder<HomeItem>(containerView),
    LayoutContainer {

    override fun bindView(item: HomeItem) {
        val quickLinks = (item as QuickLinksItem).quickLinks
        with(containerView.rvQuickLink) {
            layoutManager =
                GridLayoutManager(containerView.context, quickLinks.size, GridLayoutManager.HORIZONTAL, false)
            adapter = QuickLinkAdapter().apply {
                submitList(quickLinks.flatten())
            }
        }
    }
}