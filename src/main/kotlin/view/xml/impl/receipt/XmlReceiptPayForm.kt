package view.xml.impl.receipt

import document.receipt.IPaymentDetails
import document.receipt.IReceiptPayForm
import utils.CopyObjectUtil
import view.xml.impl.report.XmlReportPayForm
import view.xml.impl.types.Decimal2
import view.xml.impl.utils.DecimalUtil
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Order
import org.simpleframework.xml.Root
import java.math.BigDecimal

@Root(name = "ROW")
@Order(elements = ["PAYFORMCD", "PAYFORMNM", "SUM", "PROVIDED", "REMAINS", "PAYSYS"])
class XmlReceiptPayForm : IReceiptPayForm, XmlReportPayForm() {

    @field:Element(name="PROVIDED", required = false)
    private var mProvidedSum: Decimal2? = null

    @field:Element(name="REMAINS", required = false)
    private var mSumOfRemain: Decimal2? = null

    @field:ElementList(name="PAYSYS", required = false, type = XmlPaymentDetails::class)
    private var mPaymentDetails: ArrayList<IPaymentDetails>? = null

    override fun setProvidedSum(providedSum: BigDecimal?) {
        mProvidedSum = DecimalUtil.create(providedSum)
    }

    override fun getProvidedSum(): BigDecimal? {
        return DecimalUtil.getValue(mProvidedSum)
    }

    override fun setSumOfRemain(sumOfRemain: BigDecimal?) {
        mSumOfRemain = DecimalUtil.create(sumOfRemain)
    }

    override fun getSumOfRemain(): BigDecimal? {
        return DecimalUtil.getValue(mSumOfRemain)
    }

    override fun getPaymentDetails(): IPaymentDetails? {
        val array = mPaymentDetails ?: return null
        if(array.isNotEmpty()) return array[0]
        return null
    }

    override fun setPaymentDetails(paymentDetails: IPaymentDetails?) {
        if(paymentDetails== null)
        {
            mPaymentDetails = paymentDetails
            return
        }
        if(mPaymentDetails?.isNotEmpty() == true)
        {
            mPaymentDetails = ArrayList<IPaymentDetails>().apply {
                add(
                    XmlPaymentDetails().apply {
                        CopyObjectUtil.copyByInterface(IPaymentDetails::class.java, paymentDetails, this)
                    }
                )
            }
        }

    }

}
