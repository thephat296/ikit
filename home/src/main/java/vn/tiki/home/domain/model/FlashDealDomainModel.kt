package vn.tiki.home.domain.model

/**
 * Created by phatvt2 on 8/8/20
 */

data class FlashDealDomainModel(
    val status: String,
    val url: String,
    val tags: String,
    val discountPercent: Float,
    val specialPrice: Long,
    val specialFromDate: Long,
    val fromDate: String,
    val specialToDate: Long
)