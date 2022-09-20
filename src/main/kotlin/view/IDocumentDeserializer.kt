package view

import document.common.IDocument

interface IDocumentDeserializer<T> {
    fun deserialize(data: T): IDocument
}
