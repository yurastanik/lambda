package view.xml.impl.transforms


import document.common.InternalDocumentType
import org.simpleframework.xml.transform.Transform

class InternalDocumentTypeTransform : Transform<InternalDocumentType> {
    override fun read(value: String): InternalDocumentType {
        return InternalDocumentType.byInternalValue(value)
    }

    override fun write(value: InternalDocumentType): String {
        return value.value
    }
}