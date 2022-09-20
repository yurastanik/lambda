package view.xml.impl

import document.common.IDocument
import document.receipt.IReceiptDocument
import document.report.IReportDocument
import utils.CopyObjectUtil
import view.xml.impl.utils.XmlMapperUtil
import view.IDocumentSerializer
import view.xml.impl.receipt.XmlReceiptDocument
import view.xml.impl.report.XmlReportDocument
import java.io.ByteArrayOutputStream
import java.lang.IllegalStateException

class XmlSerializer : IDocumentSerializer<ByteArray> {

    override fun serialize(document: IDocument, args: Map<String, Any>?): ByteArray {

        if(document is IReportDocument) return serializeReportDocument(document)
        else if(document is IReceiptDocument) return serializeReceiptDocument(document)

        throw IllegalStateException("Document is unknown")
    }

    private fun serializeReportDocument(reportDocument: IReportDocument): ByteArray
    {
        val xmlReportDocument = XmlReportDocument()
        CopyObjectUtil.copyByInterface(IReportDocument::class.java, reportDocument, xmlReportDocument)
        ByteArrayOutputStream().use {
            XmlMapperUtil().toXML(xmlReportDocument, it)
            return it.toByteArray()
        }
    }

    private fun serializeReceiptDocument(receiptDocument: IReceiptDocument): ByteArray
    {
        val xmlReceiptDocument = XmlReceiptDocument()
        CopyObjectUtil.copyByInterface(IReceiptDocument::class.java, receiptDocument, xmlReceiptDocument)
        ByteArrayOutputStream().use {
            XmlMapperUtil().toXML(xmlReceiptDocument, it)
            return it.toByteArray()
        }
    }
}
