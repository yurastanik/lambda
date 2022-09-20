package view.xml.impl.report

import document.report.IReportPayForm
import view.xml.impl.document.XmlDocumentPayForm
import view.xml.impl.types.Decimal2
import org.simpleframework.xml.Element
import org.simpleframework.xml.Order
import org.simpleframework.xml.Root
import java.math.BigDecimal

@Root(name = "ROW")
@Order(elements = ["PAYFORMCD", "PAYFORMNM", "SUM"])
open class XmlReportPayForm : IReportPayForm, XmlDocumentPayForm() {

    @field:Element(name="SUM")
    private var mSum: Decimal2 = Decimal2()

    override fun setSum(sum: BigDecimal) {
        mSum.setValue(sum)
    }

    override fun getSum(): BigDecimal {
        return mSum.getValue()
    }
}
