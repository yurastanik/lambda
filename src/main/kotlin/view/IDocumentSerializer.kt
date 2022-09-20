package view

import document.common.IDocument

interface IDocumentSerializer<T> {
    fun serialize(document: IDocument, args: Map<String, Any>? = null): T
}
