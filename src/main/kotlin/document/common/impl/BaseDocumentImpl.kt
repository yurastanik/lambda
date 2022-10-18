package document.common.impl

import document.common.IDocument
import document.common.IDocumentHeader
import utils.CopyObjectUtil

abstract class BaseDocumentImpl() : IDocument {

    private lateinit var mDocumentHeader: IDocumentHeader

    override fun getDocumentHeader(): IDocumentHeader {
        return mDocumentHeader
    }

    override fun setDocumentHeader(documentHeader: IDocumentHeader) {
        mDocumentHeader = DocumentHeaderImpl()
        CopyObjectUtil.copyByInterface(IDocumentHeader::class.java, documentHeader, mDocumentHeader)
    }

    override fun isOfflineDocument(): Boolean {
        return mDocumentHeader.isOffline() ?: false
    }
}
