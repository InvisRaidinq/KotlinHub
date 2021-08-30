package xyz.invisraidinq.kotlinhub.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import xyz.invisraidinq.kotlinhub.HubPlugin
import xyz.invisraidinq.kotlinhub.utils.CC

class PlayerJoinListener(private val plugin: HubPlugin) : Listener {

    val speedEffect = PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3)

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        event.joinMessage = CC.colour(this.plugin.config.getString("on-join.join-message")
            .replace("%player%", player.name))

        player.teleport(player.world.spawnLocation)

        for (line in this.plugin.config.getStringList("on-join.welcome-message")) {
            player.sendMessage(CC.colour(line.replace("%player%", player.name)))
        }

        player.inventory.clear()
        player.inventory.setItem(this.plugin.config.getInt("selector.slot"), this.plugin.selectorManager.serverSelectorItem)

        for (effect in player.activePotionEffects) {
            player.removePotionEffect(effect.type)
        }

        player.addPotionEffect(speedEffect)
    }
}
