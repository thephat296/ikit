package vn.tiki.home.presentation.ui.model.quicklink

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.type.HomeItemViewType

/**
 * Created by phatvt2 on 8/8/20
 */

@Parcelize
data class QuickLinksItem(
    val quickLinks: List<QuickLinkItem>,
    val spanCount: Int
) : HomeItem, Parcelable {
    override val viewType: Int
        get() = HomeItemViewType.QUICK_LINKS
}