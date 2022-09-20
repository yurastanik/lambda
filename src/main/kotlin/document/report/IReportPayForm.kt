package document.report

import document.common.IDocumentPayForm
import java.math.BigDecimal

interface IReportPayForm : IDocumentPayForm {

    fun setSum(sum: BigDecimal)
    fun getSum(): BigDecimal
}
