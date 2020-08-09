package vn.tiki.home.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_flashdeal.view.*
import vn.tiki.extensions.setShow
import vn.tiki.home.R
import vn.tiki.home.presentation.ui.model.flashdeal.FlashDealItem
import vn.tiki.home.presentation.ui.viewholder.HomeViewHolder

/**
 * Created by phatvt2 on 8/9/20
 */

class FlashDealAdapter : ListAdapter<FlashDealItem, HomeViewHolder<FlashDealItem>>(Companion) {
    companion object : DiffUtil.ItemCallback<FlashDealItem>() {
        override fun areItemsTheSame(oldItem: FlashDealItem, newItem: FlashDealItem): Boolean {
            return oldItem.product.id == newItem.product.id
        }

        override fun areContentsTheSame(oldItem: FlashDealItem, newItem: FlashDealItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder<FlashDealItem> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_flashdeal, parent, false)
        return FlashDealViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder<FlashDealItem>, position: Int) =
        holder.bindView(getItem(position))

    private class FlashDealViewHolder(override val containerView: View) :
        HomeViewHolder<FlashDealItem>(containerView),
        LayoutContainer {
        override fun bindView(item: FlashDealItem) {
            with(containerView) {
                imgProduct.setImageURI(item.product.thumbnailUrl)
                tvPrice.text = item.product.price
                tvDiscount.setShow(item.discountPercent.isNotEmpty())
                tvDiscount.text = item.discountPercent
            }
        }
    }
}