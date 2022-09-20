package view.xml.impl.transforms

import document.common.InternalDocumentSubType
import org.simpleframework.xml.transform.Transform

class InternalDocumentSubTypeTransform : Transform<InternalDocumentSubType> {
    override fun read(value: String): InternalDocumentSubType {
        return InternalDocumentSubType.byInternalValue(value)
    }

    override fun write(value: InternalDocumentSubType): String {
        return value.value
    }
}