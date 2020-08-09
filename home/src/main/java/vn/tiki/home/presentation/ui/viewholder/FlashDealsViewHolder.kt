package vn.tiki.home.presentation.ui.viewholder

import android.view.View
import android.widget.Toast
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_flashdeals.view.*
import vn.tiki.extensions.setShow
import vn.tiki.home.R
import vn.tiki.home.presentation.ui.adapter.FlashDealAdapter
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.model.LoadingItem
import vn.tiki.home.presentation.ui.model.flashdeal.FlashDealItem
import vn.tiki.home.presentation.ui.model.flashdeal.FlashDealsItem

/**
 * Created by phatvt2 on 8/9/20
 */

class FlashDealsViewHolder(override val containerView: View) :
    HomeViewHolder<HomeItem>(containerView),
    LayoutContainer {

    override fun bindView(item: HomeItem) {
        containerView.progressBar.setShow(item is LoadingItem)
        (item as? FlashDealsItem)?.let {
            bindFlashDealsView(it.flashDeals)
        }
        containerView.tvMore.setOnClickListener {
            Toast.makeText(containerView.context, R.string.not_available, Toast.LENGTH_SHORT).show()
        }
    }

    private fun bindFlashDealsView(items: List<FlashDealItem>) {
        with(containerView.rvFlashDeal) {
            setHasFixedSize(true)
            adapter = FlashDealAdapter().apply {
                submitList(items)
            }
        }
    }
}