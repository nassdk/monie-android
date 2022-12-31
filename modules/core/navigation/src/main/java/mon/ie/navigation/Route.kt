package mon.ie.navigation

sealed interface Route {
    val name: String
    val deepLinks: List<String>
    val arguments: List<Extra>
}