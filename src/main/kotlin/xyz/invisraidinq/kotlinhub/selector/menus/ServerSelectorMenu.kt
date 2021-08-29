package xyz.invisraidinq.kotlinhub.selector.menus

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import xyz.invisraidinq.kotlinhub.HubPlugin
import xyz.invisraidinq.kotlinhub.utils.CC
import xyz.invisraidinq.kotlinhub.utils.ItemFactory

class ServerSelectorMenu constructor(private val plugin: HubPlugin, private val player: Player) {

    fun openMenu() {
        val inventory: Inventory = Bukkit.createInventory(null,
            this.plugin.config.getInt("selector.menu-size"),
            CC.colour(this.plugin.config.getString("selector.menu-name")))

        for (key in this.plugin.config.getConfigurationSection("selector.items").getKeys(false)) {
            val path = "selector.items.$key."
            val item: ItemStack = ItemFactory(Material.getMaterial(this.plugin.config.getString(path + "material")))
                .setName(this.plugin.config.getString(path + "name"))
                .setLore(this.plugin.config.getStringList(path + "lore"))
                .build()

            inventory.setItem(this.plugin.config.getInt(path + "slot"), item)
        }

        player.openInventory(inventory)
    }

}