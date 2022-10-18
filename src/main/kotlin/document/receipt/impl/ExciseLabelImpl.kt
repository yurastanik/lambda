package document.receipt.impl

import document.receipt.IExciseLabel
import document.common.impl.BaseRowImpl


class ExciseLabelImpl : IExciseLabel, BaseRowImpl() {

    private var mLabel: String = ""

    override fun getLabel(): String {
        return mLabel
    }

    override fun setLabel(label: String) {
        mLabel = label
    }
}