package vn.tiki.home.domain.model

import vn.tiki.home.presentation.ui.model.flashdeal.FlashDealItem

/**
 * Created by phatvt2 on 8/8/20
 */

data class FlashDealDomainModel(
    val discountPercent: Float,
    val product: ProductDomainModel
) {
    fun toFlashDealItem(): FlashDealItem {
        val discount = if (discountPercent == 0f) "" else "-${discountPercent}%"
        return FlashDealItem(discount, product.toProduct())
    }
}