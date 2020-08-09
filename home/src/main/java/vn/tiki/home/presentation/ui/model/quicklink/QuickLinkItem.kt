package vn.tiki.home.presentation.ui.model.quicklink

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by phatvt2 on 8/8/20
 */

@Parcelize
data class QuickLinkItem(
    val title: String,
    val url: String,
    val imageUrl: String
) : Parcelable