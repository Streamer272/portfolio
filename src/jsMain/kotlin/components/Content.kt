package components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div

@Composable
fun Content(content: @Composable() () -> Unit) {
    Div({
        classes("content")
    }) {
        content()
    }
}
