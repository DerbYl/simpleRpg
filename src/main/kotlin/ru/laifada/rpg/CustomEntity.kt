package ru.laifada.rpg

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Damageable
import org.bukkit.entity.EntityType
import java.util.UUID

enum class CustomEntity(
    val entityName: String,
    val entityType: EntityType,
    val health: Double,
) {
    BIG_ZOMBIE("Большой зомби", EntityType.ZOMBIE, 50.0),
    SUPER_ZOMBIE("Супер зомби", EntityType.ZOMBIE, 140.0);

    fun spawn(uuid: UUID, loc: Location) {
        val entity = Bukkit.getWorld("world").spawnEntity(loc, this.entityType)
        entity.customName = entityName
        (entity as Damageable).let {
            it.maxHealth = this.health
            it.health = this.health
        }
    }
}