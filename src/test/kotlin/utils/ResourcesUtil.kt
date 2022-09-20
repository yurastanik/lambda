package utils

import java.io.File


class ResourcesUtil {

    private val rootDir = "src/test/resources"

    fun readBytes(fileName: String): ByteArray
    {
        println(File(rootDir, fileName).absolutePath)
        return getResource(fileName).readBytes()
    }

    fun getResource(fileName: String): File{
        return File(rootDir, fileName)
    }
}
