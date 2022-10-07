package ru.kcenter.navigation.command

import com.github.terrakok.cicerone.Command

/**
 * Команда для смены таба
 */
data class SwitchTab(val position: Int) : Command
