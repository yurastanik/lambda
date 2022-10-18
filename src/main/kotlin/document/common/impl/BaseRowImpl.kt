package document.common.impl

import document.common.IRow

open class BaseRowImpl : IRow {

    private var mRow: Int = 1

    override fun setRow(row: Int){
        mRow = row
    }

    override fun getRow() = mRow
}