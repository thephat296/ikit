package vn.tiki.home.presentation.ui.model.quicklink

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by phatvt2 on 8/8/20
 */

@Parcelize
data class QuickLinkItem(
    val title: String,
    val content: String,
    val url: String,
    val authentication: Boolean,
    val webUrl: String,
    val imageUrl: String
) : Parcelable