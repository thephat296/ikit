package vn.tiki.home.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_quicklink.view.*
import vn.tiki.home.R
import vn.tiki.home.presentation.ui.model.quicklink.QuickLinkItem
import vn.tiki.home.presentation.ui.viewholder.HomeViewHolder

/**
 * Created by phatvt2 on 8/8/20
 */

class QuickLinkAdapter : ListAdapter<QuickLinkItem, HomeViewHolder<QuickLinkItem>>(Companion) {
    companion object : DiffUtil.ItemCallback<QuickLinkItem>() {
        override fun areItemsTheSame(oldItem: QuickLinkItem, newItem: QuickLinkItem): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: QuickLinkItem, newItem: QuickLinkItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder<QuickLinkItem> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quicklink, parent, false)
        return QuickLinkViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder<QuickLinkItem>, position: Int) =
        holder.bindView(getItem(position))

    private class QuickLinkViewHolder(override val containerView: View) :
        HomeViewHolder<QuickLinkItem>(containerView),
        LayoutContainer {
        override fun bindView(item: QuickLinkItem) {
            containerView.imgQuickLink.setImageURI(item.imageUrl)
            containerView.tvTitle.text = item.title
        }
    }
}