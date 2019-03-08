package com.epam.drill.plugin.api.processing

import com.epam.drill.common.PluginBean
import com.epam.drill.plugin.api.DrillPlugin
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Optional

expect abstract class AgentPart<T>() : DrillPlugin, Switchable, Lifecycle {
    var np: NativePart<T>?


    abstract var enabled: Boolean
    abstract var confSerializer: KSerializer<T>

    open fun init(nativePluginPartPath: String)

    fun load(onImmediately: Boolean)
    fun unload(reason: Reason)


    abstract override fun initPlugin()
    abstract override fun destroyPlugin(reason: Reason)

    //    external fun nativePart(): NativePart
    abstract override fun on()

    abstract override fun off()
    fun rawConfig(): String
}


interface Switchable {
    fun on()
    fun off()
}

interface Lifecycle {
    fun initPlugin()
    fun destroyPlugin(reason: Reason)
}

expect abstract class NativePart<T> {
    actual abstract val confSerializer: KSerializer<T>
    fun updateRawConfig(someText: PluginBean)
}


enum class Reason {
    ACTION_FROM_ADMIN

}

abstract class DConf() {
    @Optional
    abstract val id: String
    @Optional
    abstract  val enabled: Boolean
}