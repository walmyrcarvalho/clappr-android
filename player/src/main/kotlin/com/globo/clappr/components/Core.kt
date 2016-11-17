package com.globo.clappr.components

import com.globo.clappr.plugin.Loader
import com.globo.clappr.base.Options
import com.globo.clappr.base.UIObject
import com.globo.clappr.plugin.Plugin

open class Core(val loader: Loader, val options: Options) : UIObject() {
    val plugins: List<Plugin>

    var activeContainer: Container? = null
    val containers: MutableList<Container> = mutableListOf<Container>()

    init {
        plugins = loader.loadPlugins(this)

        var container = Container(loader, options)
        containers.add(container)
        activeContainer = containers.first()
    }
}