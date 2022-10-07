package ru.kcenter.navigation.command

import com.github.terrakok.cicerone.Command
import ru.kcenter.navigation.permissions.PermissionStatus

data class RequestPermissions(
    val permissions: Array<String>,
    val resultListener: (List<PermissionStatus>) -> Unit,
) : Command {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RequestPermissions

        if (!permissions.contentEquals(other.permissions)) return false

        return true
    }

    override fun hashCode(): Int {
        return permissions.contentHashCode()
    }
}