package ru.laifada.rpg

import org.bukkit.Bukkit
import org.bukkit.command.CommandExecutor
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import ru.laifada.rpg.quest.Quest

class Rpg : JavaPlugin() {

    override fun onEnable() {

        Bukkit.getPluginManager().registerEvents(DefaultListener, this)

        this.getCommand("item").executor = CommandExecutor { sender, _, _, _ ->
            if (sender !is Player) return@CommandExecutor false

            if (!PlayersBrain.takeMoney(sender.uniqueId, 5)) {
                sender.sendMessage("У вас не достаточно монет")
                return@CommandExecutor true
            }

            val item = Items.values().random()
            item.give(sender.uniqueId)
            sender.sendMessage("""
                Вы получили: ${item.itemName}
                Ваши предметы: ${PlayersBrain.items[sender.uniqueId].toString()}
                Ваш баланс = ${PlayersBrain.money[sender.uniqueId]}
            """.trimIndent())
            return@CommandExecutor true
        }

        this.getCommand("spawn").executor = CommandExecutor { sender, _, _, _ ->
            if (sender !is Player) return@CommandExecutor false

            val entity = CustomEntity.values().random()
            entity.spawn(sender.uniqueId, sender.location)
            if (!PlayersBrain.mobs.keys.contains(sender.uniqueId)) PlayersBrain.mobs[sender.uniqueId] = arrayListOf()
            PlayersBrain.mobs[sender.uniqueId]?.add(entity)

            sender.sendMessage("Вы заспавнили: ${PlayersBrain.mobs[sender.uniqueId].toString()}")
            return@CommandExecutor true
        }

        this.getCommand("quest").executor = CommandExecutor { sender, _, _, _ ->
            if (sender !is Player) return@CommandExecutor false

            if (PlayersBrain.quest[sender.uniqueId] == null) {
                val quest = Quest.values().random()
                PlayersBrain.quest[sender.uniqueId] = quest
                sender.sendMessage("Вы получили квест: ${quest.nameQuest}")
                quest.goal.forEach {
                    sender.sendMessage("Вам необходимо $it")
                }
                return@CommandExecutor true
            }
            sender.sendMessage("У вас уже есть активынй квест")


            return@CommandExecutor true
        }
    }

}