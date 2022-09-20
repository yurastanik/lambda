package document.common

import utils.DocumentNameUtil
import utils.DocumentTypeUtil
import java.math.BigDecimal

interface IDocument {

    fun getDocumentHeader(): IDocumentHeader
    fun setDocumentHeader(documentHeader: IDocumentHeader)

    fun getRegisters(): Map<String, BigDecimal>? = null

    fun getDocumentName(): String {
        return DocumentNameUtil.getDocumentName(getDocumentType(), getDocumentHeader())
    }

    fun getDocumentType(): DocumentType {
        return DocumentTypeUtil.detectDocumentTypeByHeader(getDocumentHeader())
    }

    fun isOfflineDocument(): Boolean {
        return getDocumentHeader().isOffline() ?: false
    }
}
