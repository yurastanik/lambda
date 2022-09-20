package utils

import document.common.DocumentType
import document.common.IDocumentHeader

object DocumentNameUtil {

    fun getDocumentName(documentType: DocumentType, documentHeader: IDocumentHeader): String
    {
        if(documentType == DocumentType.BeginOffline || documentType == DocumentType.FinishOffline) return documentType.value

        var offlinePrefixName = ""
        documentHeader.isOffline()?.let {
            if(it) offlinePrefixName = "Offline"
        }
        return "$offlinePrefixName${documentType.value}"
    }
}