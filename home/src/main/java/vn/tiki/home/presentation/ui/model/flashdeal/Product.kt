package vn.tiki.home.presentation.ui.model.flashdeal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by phatvt2 on 8/9/20
 */

@Parcelize
data class Product(
    val id: Long,
    val name: String,
    val urlPath: String,
    val price: String,
    val discount: Long,
    val thumbnailUrl: String
) : Parcelable