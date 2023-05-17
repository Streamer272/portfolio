package components

import androidx.compose.runtime.*
import lib.NavbarTranslationTable
import lib.Route
import org.jetbrains.compose.web.attributes.Draggable
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text

@Composable
fun Navbar(R: NavbarTranslationTable, addShortcut: AddShortcut, route: Route, setRoute: (Route) -> Unit) {
    var active: Boolean by remember { mutableStateOf(true) }

    fun next(coefficient: Short): Route? {
        val currentIndex = Route.values().indexOf(route)
        if (currentIndex == 0 && coefficient < 0)
            return null
        if (currentIndex == Route.values().size - 1 && coefficient > 0)
            return null

        return Route.values()[currentIndex + coefficient]
    }

    addShortcut("*", Shortcut("ArrowRight", 39) { next(+1)?.let(setRoute) })
    addShortcut("*", Shortcut("ArrowLeft", 37) { next(-1)?.let(setRoute) })
    addShortcut("*", Shortcut(" ", 32) { active = !active })

    addShortcut("*", Shortcut("1", 49) { setRoute(Route.HOME) })
    addShortcut("*", Shortcut("2", 50) { setRoute(Route.ABOUT) })
    addShortcut("*", Shortcut("3", 51) { setRoute(Route.SKILLS) })
    addShortcut("*", Shortcut("4", 52) { setRoute(Route.PROJECTS) })
    addShortcut("*", Shortcut("5", 53) { setRoute(Route.CONTACT) })

    Div({
        classes("navbar-toggle-container")
        if (active)
            classes("active")
    }) {
        Button({
            classes("navbar-toggle")
            onClick { active = !active }
        }) {
            Img("/icons/arrow_down.svg", "Open Navbar") {
                draggable(Draggable.False)
            }
        }
    }

    Div({
        classes("navbar-container")
        if (active)
            classes("active")
    }) {
        Div({
            classes("navbar")
        }) {
            for (linkRoute in Route.values()) {
                R.pages[linkRoute.toString().lowercase()]?.let { linkName ->
                    Button({
                        classes("navbar-item")
                        if (linkRoute == route)
                            classes("selected")
                        onClick { setRoute(linkRoute) }
                    }) {
                        Text(linkName)
                    }
                }
            }
        }
    }

    Div({
        classes("navbar-buttons")
    }) {
        Button({
            classes("navbar-button", "previous")
            if (Route.values().indexOf(route) == 0) {
                classes("disabled")
                disabled()
            }
            onClick { next(-1)?.let(setRoute) }
        }) {
            Text(R.previous)
            Img("/icons/arrow_right.svg", "Previous") {
                classes("navbar-button-icon")
            }
        }

        Button({
            classes("navbar-button", "next")
            if (Route.values().indexOf(route) == Route.values().size - 1) {
                classes("disabled")
                disabled()
            }
            onClick { next(+1)?.let(setRoute) }
        }) {
            Text(R.next)
            Img("/icons/arrow_right.svg", "Next") {
                classes("navbar-button-icon")
            }
        }
    }
}
