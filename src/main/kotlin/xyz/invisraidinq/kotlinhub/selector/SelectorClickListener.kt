package xyz.invisraidinq.kotlinhub.selector

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent
import xyz.invisraidinq.kotlinhub.HubPlugin
import xyz.invisraidinq.kotlinhub.selector.menus.ServerSelectorMenu
import xyz.invisraidinq.kotlinhub.utils.CC

class SelectorClickListener(private val plugin: HubPlugin) : Listener {

    @EventHandler
    fun onSelectorClick(event: PlayerInteractEvent) {
        val player = event.player

        if (event.item == null) {
            return
        }

        if (event.item.itemMeta == null) {
            return
        }

        if (!event.item.isSimilar(this.plugin.selectorManager.serverSelectorItem)) {
            return
        }

        ServerSelectorMenu(this.plugin, player).openMenu()
    }

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        val player = event.whoClicked as Player

        if (player.openInventory == null) {
            return
        }

        if (!event.inventory.name.equals(CC.colour(this.plugin.config.getString("selector.menu-name")))) {
            return
        }

        event.isCancelled = true

        for (key in this.plugin.config.getConfigurationSection("selector.items").getKeys(false)) {
            val path = "selector.items.$key."

            if (event.slot == this.plugin.config.getInt(path + "slot")) {
                player.performCommand(this.plugin.config.getString(path + "command"))
            }
        }
    }

}
