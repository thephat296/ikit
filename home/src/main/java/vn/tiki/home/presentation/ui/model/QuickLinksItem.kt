package vn.tiki.home.presentation.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import vn.tiki.home.presentation.ui.type.HomeItemViewType

/**
 * Created by phatvt2 on 8/8/20
 */

@Parcelize
data class QuickLinksItem(
    val quickLinks: List<List<QuickLinkItem>>
) : HomeItem, Parcelable {
    override val viewType: Int
        get() = HomeItemViewType.QUICK_LINKS
}