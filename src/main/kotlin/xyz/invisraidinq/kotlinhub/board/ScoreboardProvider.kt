package xyz.invisraidinq.kotlinhub.board

import io.github.thatkawaiisam.assemble.AssembleAdapter
import me.joeleoli.portal.shared.queue.Queue
import org.bukkit.entity.Player
import xyz.invisraidinq.kotlinhub.HubPlugin
import xyz.invisraidinq.kotlinhub.utils.CC
import xyz.invisraidinq.queryapi.QueryAPI

class ScoreboardProvider(private val plugin: HubPlugin) : AssembleAdapter {

    private val queryAPI = QueryAPI.getInstance()

    override fun getTitle(player: Player): String {
        return CC.colour(this.plugin.config.getString("scoreboard.title"))
    }

    override fun getLines(player: Player): MutableList<String> {
        val lines = mutableListOf<String>()
        val queue = Queue.getByPlayer(player.uniqueId)

        if (queue != null) {
            for (line in this.plugin.config.getStringList("scoreboard.lines.in-queue")) {
                lines.add(CC.colour(
                    line.replace("%player%", player.name)
                        .replace("%online_players%", this.queryAPI.onlinePlayers.toString())
                        .replace("%queue_name%", queue.name)
                        .replace("%queue_position%", queue.getPosition(player.uniqueId).toString())
                        .replace("%queue_size%", queue.players.size.toString())
                ))
            }
        } else {
            for (line in this.plugin.config.getStringList("scoreboard.lines.no-queue")) {
                lines.add(
                    CC.colour(
                        line.replace("%player%", player.name)
                            .replace("%online_players%", this.queryAPI.onlinePlayers.toString())
                    )
                )
            }
        }

        return lines
    }

}
