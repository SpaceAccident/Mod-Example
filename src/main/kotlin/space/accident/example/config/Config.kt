package space.accident.example.config

import net.minecraftforge.common.config.Configuration
import java.io.File

object Config {

    private inline fun onPostCreate(configFile: File?, crossinline action: (Configuration) -> Unit) {
        Configuration(configFile).let { config ->
            config.load()
            action(config)
            if (config.hasChanged()) {
                config.save()
            }
        }
    }

    fun createConfig(configFile: File?) {
        val config = File(File(configFile, "SpaceAccident"), "Example.cfg")
        onPostCreate(config) { cfg ->

        }
    }
}