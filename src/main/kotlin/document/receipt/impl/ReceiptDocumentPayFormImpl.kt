package document.receipt.impl

import document.receipt.IPaymentDetails
import document.receipt.IReceiptPayForm
import document.report.impl.ReportDocumentPayFormImpl
import utils.DocumentCopyUtil
import java.math.BigDecimal

class ReceiptDocumentPayFormImpl(
) : IReceiptPayForm, ReportDocumentPayFormImpl(){

    private var mProvidedSum: BigDecimal? = null
    private var mSumOfRemain: BigDecimal? = null
    private var mPaymentDetails: IPaymentDetails? = null


    override fun setProvidedSum(providedSum: BigDecimal?) {
        mProvidedSum = providedSum
    }

    override fun getProvidedSum(): BigDecimal? {
        return mProvidedSum
    }

    override fun setSumOfRemain(sumOfRemain: BigDecimal?) {
        mSumOfRemain = sumOfRemain
    }

    override fun getSumOfRemain(): BigDecimal? {
        return mSumOfRemain
    }

    override fun getPaymentDetails(): IPaymentDetails? {
        return mPaymentDetails
    }

    override fun setPaymentDetails(paymentDetails: IPaymentDetails?) {
        mPaymentDetails = DocumentCopyUtil.copyObject(IPaymentDetails::class.java, paymentDetails){
            PaymentDetailsImpl()
        }
    }
}
