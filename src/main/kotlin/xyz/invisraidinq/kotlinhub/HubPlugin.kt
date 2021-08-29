package xyz.invisraidinq.kotlinhub

import io.github.thatkawaiisam.assemble.Assemble
import io.github.thatkawaiisam.assemble.AssembleStyle
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import xyz.invisraidinq.kotlinhub.board.ScoreboardProvider
import xyz.invisraidinq.kotlinhub.listeners.HubListeners
import xyz.invisraidinq.kotlinhub.listeners.PlayerJoinListener
import xyz.invisraidinq.kotlinhub.listeners.PlayerQuitListener
import xyz.invisraidinq.kotlinhub.selector.SelectorClickListener
import xyz.invisraidinq.kotlinhub.selector.SelectorManager
import xyz.invisraidinq.kotlinhub.tasks.AutoBroadcastTask
import xyz.invisraidinq.kotlinhub.utils.CC

class HubPlugin : JavaPlugin() {

    val selectorManager: SelectorManager = SelectorManager(this)
    private lateinit var assemble: Assemble

    override fun onEnable() {
        CC.log("&6Enabling KotlinHub v" + this.description.version)

        this.saveDefaultConfig()

        this.assemble = Assemble(this, ScoreboardProvider(this))
        this.assemble.ticks = 20L
        this.assemble.assembleStyle = AssembleStyle.MODERN
        CC.log("&6Set up and enabled the scoreboard")

        listOf(
            PlayerJoinListener(this),
            PlayerQuitListener(this),
            SelectorClickListener(this),
            HubListeners(this)
        ).forEach {
            Bukkit.getPluginManager().registerEvents(it, this)
        }

        AutoBroadcastTask(this).runTaskTimerAsynchronously(this, 0L, 20 * 60)

        CC.log("&6Successfully enabled KotlinHub v" + this.description.version)
    }

    override fun onDisable() {
        this.assemble.cleanup()
    }

}