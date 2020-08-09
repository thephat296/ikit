package vn.tiki.home.presentation.ui.model.banner

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by phatvt2 on 8/6/20
 */

@Parcelize
data class BannerItem(
    val id: Long,
    val url: String,
    val mobileUrl: String,
    val ratio: Float
) : Parcelable