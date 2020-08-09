package vn.tiki.home.presentation.ui.model.flashdeal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by phatvt2 on 8/9/20
 */

@Parcelize
data class FlashDealItem(
    val discountPercent: String,
    val product: Product
) : Parcelable