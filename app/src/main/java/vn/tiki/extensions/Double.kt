package vn.tiki.extensions

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

/**
 * Created by phatvt2 on 8/9/20
 */

const val CURRENCY_UNIT = "đ"
val VIETNAMESE_LOCAL = Locale("vi", "VN")

fun Double.formatCurrency(): String {
    if (this <= 0) {
        return "0 $CURRENCY_UNIT"
    }
    val vnSymbols = DecimalFormatSymbols(VIETNAMESE_LOCAL).apply {
        decimalSeparator = ','
        groupingSeparator = '.'
    }
    val decimalFormat = DecimalFormat("#,###.##", vnSymbols).apply {
        maximumFractionDigits = 0
    }

    return "${decimalFormat.format(this)} $CURRENCY_UNIT"
}