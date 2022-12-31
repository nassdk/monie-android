package mon.ie.uikit.helpers.nodes

data class ButtonNode(
  val title: TextNode,
  val onClick: () -> Unit
) {
  constructor(title: String, onClick: () -> Unit) : this(
    title = title.toNode(),
    onClick = onClick
  )
}