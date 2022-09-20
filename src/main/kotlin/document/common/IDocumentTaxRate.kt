package document.common

import common.ITaxRate
import java.math.BigDecimal


interface IDocumentTaxRate : ITaxRate, IRow {

    fun setTurnoverSum(turnoverSum: BigDecimal)
    fun getTurnoverSum(): BigDecimal

    fun setSourceSum(sourceSum: BigDecimal?)
    fun getSourceSum(): BigDecimal?

    fun setSum(sum: BigDecimal)
    fun getSum(): BigDecimal
}
