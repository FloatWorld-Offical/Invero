package cc.trixey.invero.core.serialize.hocon

import taboolib.module.configuration.Configuration
import taboolib.module.configuration.Type
import java.io.File

/**
 * Invero
 * cc.trixey.invero.core.serialize.hocon.HoconLoader
 *
 * @author Arasple
 * @since 2023/1/14 21:05
 */
object HoconLoader {

    fun loadFromFile(file: File, patchIncluder: Boolean = true): Configuration {
        val type = Configuration.getTypeFromExtension(file.extension)
        if (type != Type.HOCON) error("Not a valid hocon file")

        return if (!patchIncluder) {
            Configuration.loadFromFile(file)
        } else {
            val content = PatchIncluder.patchHoconFile(file)
            val config = Configuration.loadFromString(content, type)
            config.file = file

            config
        }
    }

}