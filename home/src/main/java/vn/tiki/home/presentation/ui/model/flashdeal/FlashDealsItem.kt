package vn.tiki.home.presentation.ui.model.flashdeal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import vn.tiki.home.presentation.ui.model.HomeItem
import vn.tiki.home.presentation.ui.type.HomeItemViewType

/**
 * Created by phatvt2 on 8/9/20
 */

@Parcelize
data class FlashDealsItem(
    val flashDeals: List<FlashDealItem>
) : HomeItem, Parcelable {
    override val viewType: Int
        get() = HomeItemViewType.FLASH_DEALS
}