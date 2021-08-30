package xyz.invisraidinq.kotlinhub.listeners

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent
import xyz.invisraidinq.kotlinhub.HubPlugin
import xyz.invisraidinq.kotlinhub.utils.CC

class PlayerQuitListener(private val plugin: HubPlugin) : Listener {

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        val player: Player = event.player
        event.quitMessage = CC.colour(this.plugin.config.getString("on-quit.quit-message")
            .replace("%player%", player.name))
    }
}
