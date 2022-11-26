package ru.laifada.rpg

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerJoinEvent

object DefaultListener : Listener {

    @EventHandler
    fun PlayerJoinEvent.handle() {
        PlayersBrain.giveMoney(player.uniqueId, 500)
    }

    fun EntityDamageByEntityEvent.handle() {
        if (damager !is Player) return
        val player = damager as Player

    }
}