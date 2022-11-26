package ru.laifada.rpg.quest

import org.bukkit.Material
import org.bukkit.entity.EntityType
import ru.laifada.rpg.quest.goal.Goal
import ru.laifada.rpg.quest.goal.QuestClickGoal
import ru.laifada.rpg.quest.goal.QuestItemGoal
import ru.laifada.rpg.quest.goal.QuestKillGoal

enum class Quest(
    val nameQuest: String,
    val difficulty: QuestDifficulty,
    val level: Int,
    val goal: Array<Goal>,
) {
    KILL_ZOMBIE("Зачистка", QuestDifficulty.EASY, 0, arrayOf(QuestKillGoal(EntityType.ZOMBIE, 5))),
    KILL_ZOMBIE2("Зачистка местности", QuestDifficulty.MEDIUM, 0, arrayOf(QuestKillGoal(EntityType.ZOMBIE, 15))),
    GIVE_ITEMS("Долг", QuestDifficulty.HARD, 0, arrayOf(
        QuestItemGoal(Material.DIAMOND, 5),
        QuestItemGoal(Material.GOLD_INGOT, 10)
    )),
    CLICK("Найди мне его!", QuestDifficulty.MEDIUM, 0, arrayOf(QuestClickGoal(EntityType.VILLAGER))),;
}