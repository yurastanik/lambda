package view.xml.impl.document

import document.common.IRow
import org.simpleframework.xml.Attribute

open class XmlBaseRow : IRow {

    @field:Attribute(name="ROWNUM")
    private var mRow: Int = 1

    override fun setRow(row: Int){
        mRow = row
    }

    override fun getRow() = mRow
}