package ru.laifada.rpg.quest.goal

import org.bukkit.entity.EntityType

data class QuestClickGoal(
    val entityType: EntityType
) : Goal() {
    override val needCount: Int = 1
}
