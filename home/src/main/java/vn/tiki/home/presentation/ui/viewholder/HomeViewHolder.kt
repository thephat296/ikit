package vn.tiki.home.presentation.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by phatvt2 on 8/5/20
 */

abstract class HomeViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bindView(item: T)
}
