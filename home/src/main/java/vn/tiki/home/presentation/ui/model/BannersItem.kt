package vn.tiki.home.presentation.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import vn.tiki.home.presentation.ui.type.HomeItemViewType

/**
 * Created by phatvt2 on 8/5/20
 */

@Parcelize
data class BannersItem(
    val banners: List<BannerItem>
) : HomeItem, Parcelable {
    override val viewType: Int
        get() = HomeItemViewType.BANNERS
}