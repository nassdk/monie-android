package ru.kcenter.navigation.permissions

sealed class PermissionStatus {
    object Granted : PermissionStatus()
    data class Denied(val permissionName: String) : PermissionStatus()
    data class ShowRationale(val permissionName: String) : PermissionStatus()
}