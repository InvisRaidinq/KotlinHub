package xyz.invisraidinq.kotlinhub.commands

import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import xyz.invisraidinq.kotlinhub.utils.CC

class SetSpawnCommand : CommandExecutor {

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender !is Player) {
            sender.sendMessage(CC.colour("&cThis is a player command only!"))
            return false
        }

        val player: Player = sender;
        if (!player.hasPermission("kotlinhub.admin")) {
            player.sendMessage(CC.colour("&cNo Permission"))
            return false
        }

        val location: Location = player.location;
        location.world.setSpawnLocation(location.blockX, location.blockY, location.blockZ)
        player.sendMessage(CC.colour("&aYou have updated the spawn location!"))
        return true
    }
}