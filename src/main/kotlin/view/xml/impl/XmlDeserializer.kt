package view.xml.impl

import document.common.IDocument
import document.receipt.IReceiptDocument
import document.receipt.impl.ReceiptDocumentImpl
import document.report.IReportDocument
import document.report.impl.ReportDocumentImpl
import utils.CopyObjectUtil
import view.IDocumentDeserializer
import view.xml.impl.receipt.XmlReceiptDocument
import view.xml.impl.report.XmlReportDocument
import view.xml.impl.utils.XmlMapperUtil
import java.io.ByteArrayInputStream
import java.lang.IllegalArgumentException

class XmlDeserializer : IDocumentDeserializer<ByteArray> {

    override fun deserialize(data: ByteArray): IDocument {

        if(isReceiptDocument(data)) return deserializeReceiptDocument(data)
        else if(isReportDocument(data)) return deserializeReportDocument(data)

        throw IllegalArgumentException("Data is not valid")
    }

    private fun deserializeReportDocument(data: ByteArray): IReportDocument
    {
        val reportDocument: IReportDocument = ByteArrayInputStream(data).use {
            XmlMapperUtil().fromXML(XmlReportDocument::class.java, it)
        }

        return ReportDocumentImpl().apply {
            CopyObjectUtil.copyByInterface(IReportDocument::class.java, reportDocument, this)
        }
    }

    private fun deserializeReceiptDocument(data: ByteArray): IReceiptDocument
    {
        val receiptDocument: IReceiptDocument = ByteArrayInputStream(data).use {
            XmlMapperUtil().fromXML(XmlReceiptDocument::class.java, it)
        }

        return ReceiptDocumentImpl().apply {
            CopyObjectUtil.copyByInterface(IReceiptDocument::class.java, receiptDocument, this)
        }
    }

    fun isReportDocument(data: ByteArray): Boolean
    {
        if(isTooSmall(data)) return false
        return isContains(data, "<ZREP")
    }

    fun isReceiptDocument(data: ByteArray): Boolean
    {
        if(isTooSmall(data)) return false
        return isContains(data, "<CHECK")
    }

    fun isContains(data: ByteArray, key: String): Boolean
    {
        return data.decodeToString(0, 100)
            .indexOf(key, 0, true) != -1
    }

    fun isTooSmall(data: ByteArray): Boolean
    {
        return data.size < 100
    }
}