package xyz.invisraidinq.kotlinhub.utils

import org.bukkit.Bukkit
import org.bukkit.ChatColor


object CC {

    fun colour(text: String) : String {
        return ChatColor.translateAlternateColorCodes('&', text)
    }

    fun colour(list: List<String>): List<String> {
        val translated: MutableList<String> = ArrayList()
        for (string in list) {
            translated.add(this.colour(string))
        }
        return translated
    }

    fun log(text: String) {
        Bukkit.getConsoleSender().sendMessage(this.colour("[Hub] $text"))
    }

}