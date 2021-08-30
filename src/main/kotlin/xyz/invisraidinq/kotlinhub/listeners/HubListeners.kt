package xyz.invisraidinq.kotlinhub.listeners

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.inventory.InventoryMoveItemEvent
import xyz.invisraidinq.kotlinhub.HubPlugin
import xyz.invisraidinq.kotlinhub.utils.CC

class HubListeners(private val plugin: HubPlugin) : Listener {

    @EventHandler
    fun onBlockPlace(event: BlockPlaceEvent) {
        val player: Player = event.player
        if (!player.hasPermission("kotlinhub.admin")) {
            event.isCancelled = true
            player.sendMessage(CC.colour(this.plugin.config.getString("messages.cannot-place-block")))
        }
    }

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        val player: Player = event.player
        if (!player.hasPermission("kotlinhub.admin")) {
            event.isCancelled = true
            player.sendMessage(CC.colour(this.plugin.config.getString("messages.cannot-break-block")))
        }
    }

    @EventHandler
    fun onInventoryMove(event: InventoryMoveItemEvent) {
        event.isCancelled = true
    }

    @EventHandler
    fun onPlayerHit(event: EntityDamageEvent) {
        if (event.entity is Player) {
            event.isCancelled = true
        }
    }
}