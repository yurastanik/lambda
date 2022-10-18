package utils

import document.common.DocumentType
import document.common.IDocumentHeader
import document.common.InternalDocumentSubType
import document.common.InternalDocumentType
import document.receipt.IReceiptHeader
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

object DocumentTypeUtil {

    private data class PairOfTypes(
        val type: InternalDocumentType? = null,
        val subType: InternalDocumentSubType? = null
    )

    private val mapOfDocumentTypes = mapOf<PairOfTypes, DocumentType>(
//        PairOfTypes(null, null) to DocumentType.ZReport,
        PairOfTypes(InternalDocumentType.OPEN_SHIFT, null) to DocumentType.OpenShift,
        PairOfTypes(InternalDocumentType.CLOSE_SHIFT, null) to DocumentType.CloseShift,
        PairOfTypes(InternalDocumentType.BEGIN_OFFLINE_SESSION, null) to DocumentType.BeginOffline,
        PairOfTypes(InternalDocumentType.FINISH_OFFLINE_SESSION, null) to DocumentType.FinishOffline,
        PairOfTypes(InternalDocumentType.SALE, InternalDocumentSubType.SALE) to DocumentType.Sale,
        PairOfTypes(InternalDocumentType.SALE, InternalDocumentSubType.RETURN) to DocumentType.Return,
        PairOfTypes(InternalDocumentType.SALE, InternalDocumentSubType.CANCEL) to DocumentType.Cancel,
        PairOfTypes(InternalDocumentType.SALE, InternalDocumentSubType.ADDITIONAL_DEPOSIT) to DocumentType.AdditionalInput,
        PairOfTypes(InternalDocumentType.SALE, InternalDocumentSubType.SERVICE_DEPOSIT) to DocumentType.ServiceInput,
        PairOfTypes(InternalDocumentType.SALE, InternalDocumentSubType.SERVICE_ISSUE) to DocumentType.ServiceOutput,
        PairOfTypes(InternalDocumentType.CASH_WITHDRAWAL, InternalDocumentSubType.SALE) to DocumentType.CashWithdrawal,
        PairOfTypes(InternalDocumentType.PAWN, InternalDocumentSubType.SALE) to DocumentType.Pawn,
        PairOfTypes(InternalDocumentType.CURRENCY_EXCHANGE, InternalDocumentSubType.SALE) to DocumentType.CurrencyExchange,
        PairOfTypes(InternalDocumentType.CURRENCY_EXCHANGE, InternalDocumentSubType.SERVICE_DEPOSIT) to DocumentType.CurrencyInput,
        PairOfTypes(InternalDocumentType.CURRENCY_EXCHANGE, InternalDocumentSubType.SERVICE_ISSUE) to DocumentType.CurrencyOutput,
        PairOfTypes(InternalDocumentType.CURRENCY_EXCHANGE, InternalDocumentSubType.ADDITIONAL_DEPOSIT) to DocumentType.CurrencyAdditionalInput,
    )

    fun detectDocumentTypeByHeader(documentHeader: IDocumentHeader): DocumentType
    {
        if (documentHeader is IReceiptHeader) {
            documentHeader.let {
                return mapOfDocumentTypes[PairOfTypes(it.getInternalDocumentType(), it.getInternalDocumentSubType())]
                    ?: throw IllegalArgumentException("Document type cannot be detected")
            }
        }

        return DocumentType.ZReport
    }

    fun fillDocumentHeaderByDocumentType(documentHeader: IDocumentHeader, documentType: DocumentType)
    {
        if(documentType == DocumentType.ZReport) return

        mapOfDocumentTypes.forEach { (pair, type) ->
            if(type == documentType)
            { if(documentHeader is IReceiptHeader) {
                    documentHeader.setInternalDocumentType(pair.type)
                    documentHeader.setInternalDocumentSubType(pair.subType)
                }
                return
            }
        }
        throw IllegalStateException("Document type is unknown")
    }
}
