package document.receipt

import document.common.IRow

interface IExciseLabel : IRow {

    fun getLabel(): String
    fun setLabel(label: String)
}