package ru.kcenter.navigation.command

import com.github.terrakok.cicerone.Command
import ru.kcenter.navigation.screen.DialogScreen

/**
 * Команда для показа диалогов
 */
data class ShowDialog(val screen: DialogScreen) : Command