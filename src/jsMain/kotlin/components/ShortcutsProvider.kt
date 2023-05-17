package components

import androidx.compose.runtime.*
import kotlinx.browser.document
import lib.Route
import org.w3c.dom.events.Event
import org.w3c.dom.events.KeyboardEvent

@Composable
fun ShortcutsProvider(route: Route): AddShortcut {
    var shortcuts: Array<Pair<String, Shortcut>> by remember { mutableStateOf(arrayOf()) }
    var controlPressed: Boolean by remember { mutableStateOf(false) }

    document.addEventListener("keydown", { event: Event ->
        val keyboardEvent = event as KeyboardEvent
        if (keyboardEvent.key == "Control" || keyboardEvent.keyCode == 17) {
            controlPressed = true
            return@addEventListener
        }

        if (!controlPressed)
            return@addEventListener

        for (shortcut in shortcuts) {
            if (shortcut.first != "*" && shortcut.first != route.toString().lowercase())
                continue

            if (keyboardEvent.key == shortcut.second.key || keyboardEvent.keyCode == shortcut.second.keyCode) {
                event.preventDefault()
                event.stopPropagation()
                event.stopImmediatePropagation()
                shortcut.second.callback()
            }
        }

        println("Pressed '${keyboardEvent.key}' (${keyboardEvent.keyCode})")
    })

    document.addEventListener("keyup", { event: Event ->
        val keyboardEvent = event as KeyboardEvent
        if (keyboardEvent.key == "Control" || keyboardEvent.keyCode == 17)
            controlPressed = false
    })

    return { page, shortcut ->
        shortcuts += Pair(page, shortcut)
    }
}

typealias AddShortcut = (String, Shortcut) -> Unit

data class Shortcut(val key: String, val keyCode: Int, val callback: () -> Unit)
