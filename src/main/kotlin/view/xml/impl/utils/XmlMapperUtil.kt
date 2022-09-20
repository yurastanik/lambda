package view.xml.impl.utils

import document.common.InternalDocumentSubType
import document.common.InternalDocumentType
import document.receipt.PawnMoneyDirection
import view.xml.impl.types.Decimal2
import view.xml.impl.types.Decimal3
import view.xml.impl.types.Decimal8
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister
import org.simpleframework.xml.stream.Format
import org.simpleframework.xml.transform.Matcher
import view.xml.impl.transforms.*
import java.io.*
import java.nio.charset.Charset

class XmlMapperUtil {

    private val serializer: Serializer = Persister(Matcher { type ->
        val transform = when (type) {
            InternalDocumentType::class.java -> InternalDocumentTypeTransform()
            InternalDocumentSubType::class.java -> InternalDocumentSubTypeTransform()
            Decimal2::class.java -> Decimal2Transform()
            Decimal3::class.java -> Decimal3Transform()
            Decimal8::class.java -> Decimal8Transform()
            PawnMoneyDirection::class.java -> PawnMoneyDirectionTransform()
            else -> null
        }
        transform
    }, Format("<?xml version=\"1.0\" encoding=\"windows-1251\"?>"))


    fun toXML(source: Any, output: OutputStream) {
        serializer.write(source, OutputStreamWriter(output, Charset.forName("windows-1251")))
    }

    fun toXML(source: Any, output: File) {
        FileOutputStream(output).use {
            toXML(source, it)
        }
    }

    fun toXMLString(source: Any): String {

        ByteArrayOutputStream().use {
            toXML(source, it)
            return String(it.toByteArray(), Charset.forName("windows-1251"))
        }
    }

    fun <T> fromXML(type: Class<T>, source: String): T
    {
        return serializer.read(type, source, false)
    }

    fun <T> fromXML(type: Class<T>, source: InputStream): T
    {
        return serializer.read(type, source, false)
    }

    fun <T> fromXML(type: Class<T>, source: File): T
    {
        FileInputStream(source).use {
            return fromXML(type, it)
        }
    }
}
