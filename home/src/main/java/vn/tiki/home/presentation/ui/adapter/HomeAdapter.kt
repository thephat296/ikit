package vn.tiki.home.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import vn.tiki.home.presentation.ui.factory.HomeViewHolderFactory
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.viewholder.HomeViewHolder

/**
 * Created by phatvt2 on 8/5/20
 */

class HomeAdapter(
    private val viewHolderFactory: HomeViewHolderFactory
) : ListAdapter<HomeItem, HomeViewHolder<HomeItem>>(Companion) {
    companion object : DiffUtil.ItemCallback<HomeItem>() {
        override fun areItemsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
            return false //todo
        }

        override fun areContentsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
            return false //todo
        }
    }

    override fun onBindViewHolder(holder: HomeViewHolder<HomeItem>, position: Int) = holder.bindView(getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder<HomeItem> {
        val layout = viewHolderFactory.getLayoutId(viewType)
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return viewHolderFactory.getViewHolder(viewType, view)
    }

    override fun getItemViewType(position: Int): Int = getItem(position).viewType
}
