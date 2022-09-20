package view.xml.impl.report

import document.report.IReportCashTotal
import view.xml.impl.types.Decimal2
import view.xml.impl.utils.DecimalUtil
import org.simpleframework.xml.Element
import org.simpleframework.xml.Order
import java.math.BigDecimal


@Order(elements = ["SUM", "COMMISSION", "ORDERSCNT"])
class XmlReportCashTotal : IReportCashTotal {

    @field:Element(name="SUM")
    private var mSum = Decimal2()

    @field:Element(name="COMMISSION", required = false)
    private var mSumOfCommission: Decimal2? = null

    @field:Element(name="ORDERSCNT")
    private var mNumberOfReceipts: Int = 0


    override fun setSum(sum: BigDecimal) {
        mSum.setValue(sum)
    }

    override fun getSum(): BigDecimal {
        return mSum.getValue()
    }

    override fun setNumberOfReceipts(numberOfReceipts: Int) {
        mNumberOfReceipts = numberOfReceipts
    }

    override fun getNumberOfReceipts(): Int {
        return mNumberOfReceipts
    }

    override fun setSumOfCommission(sumOfCommission: BigDecimal?) {
        mSumOfCommission = DecimalUtil.create(sumOfCommission)
    }

    override fun getSumOfCommission(): BigDecimal? {
        return DecimalUtil.getValue(mSumOfCommission)
    }
}
