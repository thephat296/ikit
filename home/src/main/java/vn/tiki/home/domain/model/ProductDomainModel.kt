package vn.tiki.home.domain.model

import vn.tiki.extensions.formatCurrency
import vn.tiki.home.presentation.ui.model.flashdeal.Product

/**
 * Created by phatvt2 on 8/9/20
 */

data class ProductDomainModel(
    val id: Long,
    val name: String,
    val urlPath: String,
    val price: Long,
    val discount: Long,
    val thumbnailUrl: String
) {
    fun toProduct() = Product(id, name, urlPath, price.toDouble().formatCurrency(), discount, thumbnailUrl)
}