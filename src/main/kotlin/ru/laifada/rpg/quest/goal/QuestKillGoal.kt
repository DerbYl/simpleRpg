package ru.laifada.rpg.quest.goal

import org.bukkit.entity.EntityType

data class QuestKillGoal(
    val entityType: EntityType,
    val needKills: Int
) : Goal() {
    override val needCount: Int = needKills
}
