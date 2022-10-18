package document.common.impl

import document.common.IDocumentPayForm

open class DocumentPayFormImpl : IDocumentPayForm, BaseRowImpl() {

    private lateinit var mCode: String
    private lateinit var mName: String

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