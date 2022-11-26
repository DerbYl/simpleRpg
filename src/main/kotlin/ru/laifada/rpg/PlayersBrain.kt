package ru.laifada.rpg

import ru.laifada.rpg.quest.Quest
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

object PlayersBrain {

    val money : HashMap<UUID, Int> = hashMapOf()
    val items : HashMap<UUID, ArrayList<Items>> = hashMapOf()
    val mobs : HashMap<UUID, ArrayList<CustomEntity>> = hashMapOf()
    val quest : HashMap<UUID, Quest?> = hashMapOf()

    fun takeMoney(uuid: UUID, count: Int) : Boolean {
        if (money.keys.contains(uuid) && money[uuid]!! >= count) {
            money[uuid] = money[uuid]?.minus(count) ?: 0
            return true
        }

        return false
    }

    fun giveMoney(uuid: UUID, count: Int) {
        if (money.keys.contains(uuid)) {
            money[uuid]!!.plus(count)
            return
        }
        money[uuid] = count
    }
}