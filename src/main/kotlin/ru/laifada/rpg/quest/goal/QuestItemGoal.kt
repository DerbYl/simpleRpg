package ru.laifada.rpg.quest.goal

data class QuestItemGoal(
    val material: org.bukkit.Material,
    val countMaterial: Int,
) : Goal() {
    override val needCount: Int = countMaterial
}
