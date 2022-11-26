package ru.laifada.rpg

import java.util.UUID

enum class Items(
    val itemName : String,
    val description: String,
) {
    SWORD("Экскалибур", "Алмазный меч."),
    TELEPORT("Телепорт", "Отправляет вас в случайную точку на карте"),;

    fun give(uuid: UUID) {
        if (PlayersBrain.items.isEmpty()) {
            PlayersBrain.items[uuid] = arrayListOf(this)
        } else {
            PlayersBrain.items[uuid]?.add(this)
        }
    }
}