package view.xml.impl.receipt

import document.receipt.IExciseLabel
import view.xml.impl.document.XmlBaseRow
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "ROW")
class XmlExciseLabel : IExciseLabel, XmlBaseRow() {

    @field:Element(name="EXCISELABEL", required = false)
    private var mLabel: String = ""

    override fun getLabel(): String {
        return mLabel
    }

    override fun setLabel(label: String) {
        mLabel = label
    }
}
