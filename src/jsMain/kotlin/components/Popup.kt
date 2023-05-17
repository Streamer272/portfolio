package components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.CSSLengthOrPercentageValue
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.dom.Div

@Composable
fun Popup(metadata: PopupMetadata, addShortcut: AddShortcut) {
    addShortcut("*", Shortcut("Escape", 27) { metadata.disable() })

    Div({
        classes("popup-container")
    }) {
        Div({
            classes("popup")
            if (metadata.active)
                classes("active")
            style {
                left(metadata.position.first)
                top(metadata.position.second)
            }
        }) {
            metadata.content()
        }
    }
}

data class PopupMetadata(
    val position: Pair<CSSLengthOrPercentageValue, CSSLengthOrPercentageValue>,
    val active: Boolean,
    val disable: () -> Unit,
    val content: @Composable () -> Unit
) {
    companion object {
        fun default(): PopupMetadata = PopupMetadata(
            Pair(0.px, 0.px),
            false,
            {}
        ) {}
    }
}
