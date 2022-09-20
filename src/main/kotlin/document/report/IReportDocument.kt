package document.report

import document.common.IDocument
import java.math.BigDecimal

interface IReportDocument : IDocument {

    fun setTotalsBySale(totals: IReportTotal?)
    fun getTotalsBySale(): IReportTotal?

    fun setTotalsByReturn(totals: IReportTotal?)
    fun getTotalsByReturn(): IReportTotal?

    fun setServiceInputSum(sum: BigDecimal?)
    fun getServiceInputSum(): BigDecimal?

    fun setServiceOutputSum(sum: BigDecimal?)
    fun getServiceOutputSum(): BigDecimal?

    fun setTotalsByCash(totals: IReportCashTotal?)
    fun getTotalsByCash(): IReportCashTotal?
}
