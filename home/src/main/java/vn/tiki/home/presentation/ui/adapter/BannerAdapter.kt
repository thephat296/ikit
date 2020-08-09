package vn.tiki.home.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_banner.view.*
import vn.tiki.home.R
import vn.tiki.home.presentation.ui.model.banner.BannerItem
import vn.tiki.home.presentation.ui.viewholder.HomeViewHolder

/**
 * Created by phatvt2 on 8/6/20
 */

class BannerAdapter : ListAdapter<BannerItem, HomeViewHolder<BannerItem>>(Companion) {
    companion object : DiffUtil.ItemCallback<BannerItem>() {
        override fun areItemsTheSame(oldItem: BannerItem, newItem: BannerItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BannerItem, newItem: BannerItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder<BannerItem> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder<BannerItem>, position: Int) =
        holder.bindView(getItem(position))

    private class BannerViewHolder(override val containerView: View) :
        HomeViewHolder<BannerItem>(containerView),
        LayoutContainer {
        override fun bindView(item: BannerItem) {
            containerView.imgBanner.setImageURI(item.mobileUrl)
        }
    }
}