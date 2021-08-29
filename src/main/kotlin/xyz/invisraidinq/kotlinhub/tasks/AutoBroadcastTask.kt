package xyz.invisraidinq.kotlinhub.tasks

import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable
import xyz.invisraidinq.kotlinhub.HubPlugin
import xyz.invisraidinq.kotlinhub.utils.CC
import java.util.concurrent.ThreadLocalRandom

class AutoBroadcastTask constructor(private val plugin: HubPlugin) : BukkitRunnable() {

    private val broadcasts: List<String> = this.plugin.config.getStringList("broadcasts")

    override fun run() {
        Bukkit.broadcastMessage(CC.colour(this.broadcasts[ThreadLocalRandom.current().nextInt(this.broadcasts.size)]));
    }
}