package view.xml.impl.report

import document.common.IDocumentTaxRate
import document.report.IReportPayForm
import document.report.IReportTotal
import utils.DocumentCopyUtil
import view.xml.impl.document.XmlDocumentTaxRate
import view.xml.impl.types.Decimal2
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Order
import java.math.BigDecimal
@Order(elements = ["SUM","PWNSUMISSUED","PWNSUMRECEIVED"/*,"RNDSUM","NORNDSUM"*/,"ORDERSCNT"/*,"TOTALCURRENCYCOST","TOTALCURRENCYSUM","TOTALCURRENCYCOMMISSION"*/,"PAYFORMS","TAXES"])
class XmlReportTotal : IReportTotal {

    @field:Element(name="SUM")
    private var mSum = Decimal2()

    @field:Element(name="ORDERSCNT")
    private var mNumberOfReceipts: Int = 0

    @field:Element(name="PWNSUMISSUED", required = false)
    private var mPawnSumIssued: BigDecimal? = null

    @field:Element(name="PWNSUMRECEIVED", required = false)
    private var mPawnSumReceived: BigDecimal? = null

    @field:ElementList(name = "PAYFORMS", required = false, type = XmlReportPayForm::class)
    var mPayForms: ArrayList<IReportPayForm>? = null

    @field:ElementList(name = "TAXES", required = false, type = XmlDocumentTaxRate::class)
    var mTaxRates: ArrayList<IDocumentTaxRate>? = null

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

    override fun getPawnSumIssued(): BigDecimal? {
        return mPawnSumIssued
    }

    override fun setPawnSumIssued(pawnSumIssued: BigDecimal?) {
        mPawnSumIssued = pawnSumIssued
    }

    override fun getPawnSumReceived(): BigDecimal? {
        return mPawnSumReceived
    }

    override fun setPawnSumReceived(pawnSumReceived: BigDecimal?) {
        mPawnSumReceived = pawnSumReceived
    }

    override fun setPayForms(payForms: List<IReportPayForm>?) {

        mPayForms = DocumentCopyUtil.copyArrayList(IReportPayForm::class.java, payForms){
            XmlReportPayForm()
        }

    }

    override fun getPayForms(): List<IReportPayForm>? {
        return mPayForms
    }

    override fun setTaxRates(taxRates: List<IDocumentTaxRate>?) {

        mTaxRates = DocumentCopyUtil.copyArrayList(IDocumentTaxRate::class.java, taxRates){
            XmlDocumentTaxRate()
        }

    }

    override fun getTaxRates(): List<IDocumentTaxRate>? {
        return mTaxRates
    }
}
