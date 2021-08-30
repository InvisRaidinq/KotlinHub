package xyz.invisraidinq.kotlinhub.utils

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

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

    fun setEnchanted() : ItemFactory {
        val itemMeta = this.itemStack.itemMeta;
        this.itemStack.addUnsafeEnchantment(Enchantment.LURE, 1)
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
        this.itemStack.itemMeta = itemMeta;
        return this;
    }

    fun build() : ItemStack {
        return this.itemStack
    }
}
