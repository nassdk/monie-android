package ru.kcenter.navigation.command

import com.github.terrakok.cicerone.Command
import mon.ie.navigation.bundle.MessageBundle

/**
 * Команда для показа сообщений
 */
data class ShowMessage(val messageBundle: MessageBundle) : Command
