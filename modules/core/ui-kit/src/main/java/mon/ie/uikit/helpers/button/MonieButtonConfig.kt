package mon.ie.uikit.helpers.button

class MonieButtonConfig(val items: List<MonieButtonItem>) {

  val hasStartIcon: Boolean
    get() = items.any { it is MonieButtonItem.StartIcon }

  val hasEndIcon: Boolean
    get() = items.any { it is MonieButtonItem.EndIcon }
}