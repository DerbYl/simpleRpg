package ru.laifada.rpg.quest.goal

open class Goal {

    open var count = 0
    open val needCount = 0

    open fun addGoal() : Boolean {
        count += 1
        return count == needCount
    }
}