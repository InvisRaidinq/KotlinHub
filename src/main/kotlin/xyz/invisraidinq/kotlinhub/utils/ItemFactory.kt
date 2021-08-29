package xyz.invisraidinq.kotlinhub.utils

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

class ItemFactory(private val material: Material) {

    private val itemStack: ItemStack = ItemStack(this.material)

    fun setName(name: String) : ItemFactory {
        val itemMeta = this.itemStack.itemMeta
        itemMeta.displayName = CC.colour(name)
        this.itemStack.itemMeta = itemMeta
        return this
    }

    fun setLore(lore: List<String>) : ItemFactory {
        val itemMeta = this.itemStack.itemMeta
        itemMeta.lore = CC.colour(lore)
        this.itemStack.itemMeta = itemMeta
        return this
    }

    fun build() : ItemStack {
        return this.itemStack
    }
}
