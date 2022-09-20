package document.receipt

import document.common.IDocumentHeader
import document.common.InternalDocumentSubType
import document.common.InternalDocumentType


interface IReceiptHeader : IDocumentHeader {

    fun setInternalDocumentType(internalDocumentType: InternalDocumentType?)
    fun getInternalDocumentType(): InternalDocumentType?

    fun setInternalDocumentSubType(internalDocumentSubType: InternalDocumentSubType?)
    fun getInternalDocumentSubType(): InternalDocumentSubType?

    fun setFiscalNumberForReturn(fiscalNumberForReturn: String?)
    fun getFiscalNumberForReturn(): String?

    fun setFiscalNumberForCancel(fiscalNumberForCancel: String?)
    fun getFiscalNumberForCancel(): String?

    fun setRevokedLastOnlineDocument(revokeLastOnlineDocument: Boolean?)
    fun isRevokedLastOnlineDocument(): Boolean?

    fun setLogoUrl(logoUrl: String?)
    fun getLogoUrl(): String?

    fun setComment(comment: String?)
    fun getComment(): String?

    fun setCanceled(canceled: Boolean?)
    fun isCanceled(): Boolean?

    fun getOperationTypeName(): String?
    fun setOperationTypeName(operationTypeName: String?)

    fun getVehicleRegistrationNumber(): String?
    fun setVehicleRegistrationNumber(vehicleRegistrationNumber: String?)


//    fun copyTo(target: IReceiptHeader){
//        target.setInternalDocumentType(getInternalDocumentType())
//        target.setInternalDocumentSubType(getInternalDocumentSubType())
//        target.setUid(getUid())
//        target.setSellerId(getSellerId())
//        target.setVatNumber(getVatNumber())
//        target.setCompanyName(getCompanyName())
//        target.setPointName(getPointName())
//        target.setPointAddress(getPointAddress())
//        target.setDate(getDate())
//        target.setTime(getTime())
//    }
}
