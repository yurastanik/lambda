package document.receipt

import document.report.IReportPayForm
import java.math.BigDecimal

interface IReceiptPayForm : IReportPayForm {

    fun setProvidedSum(providedSum: BigDecimal?)
    fun getProvidedSum(): BigDecimal?

    fun setSumOfRemain(sumOfRemain: BigDecimal?)
    fun getSumOfRemain(): BigDecimal?

    fun getPaymentDetails(): IPaymentDetails?
    fun setPaymentDetails(paymentDetails: IPaymentDetails?)
}
