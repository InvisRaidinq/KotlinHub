package xyz.invisraidinq.kotlinhub.selector

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import xyz.invisraidinq.kotlinhub.HubPlugin
import xyz.invisraidinq.kotlinhub.utils.ItemFactory

class SelectorManager constructor(private val plugin: HubPlugin) {

    val serverSelectorItem: ItemStack = ItemFactory(Material.getMaterial(this.plugin.config.getString("selector.item.material")))
        .setName(this.plugin.config.getString("selector.item.name"))
        .setLore(this.plugin.config.getStringList("selector.item.lore"))
        .build()

}