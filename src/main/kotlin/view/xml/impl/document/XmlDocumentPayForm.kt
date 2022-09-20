package view.xml.impl.document

import document.common.IDocumentPayForm
import org.simpleframework.xml.Element
import view.xml.impl.document.XmlBaseRow

open class XmlDocumentPayForm : IDocumentPayForm, XmlBaseRow() {

    @field:Element(name="PAYFORMCD")
    private var mCode: String = ""

    @field:Element(name="PAYFORMNM")
    private var mName: String = ""

    override fun setCode(code: String) {
        mCode = code
    }

    override fun getCode(): String {
        return mCode
    }

    override fun setName(name: String) {
        mName = name
    }

    override fun getName(): String {
        return mName
    }
}
