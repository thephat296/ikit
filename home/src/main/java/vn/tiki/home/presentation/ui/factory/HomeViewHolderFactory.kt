package vn.tiki.home.presentation.ui.factory

import android.view.View
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.viewholder.HomeViewHolder

/**
 * Created by phatvt2 on 8/6/20
 */

interface HomeViewHolderFactory {
    fun getLayoutId(type: Int): Int

    fun getViewHolder(type: Int, view: View): HomeViewHolder<HomeItem>
}