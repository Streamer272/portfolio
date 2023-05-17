package components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.Div

enum class PageTransition {
    NONE,
    FROM_LEFT,
    FROM_RIGHT;
}

@Composable
fun PageTransition(pageTransition: PageTransition, middleCallback: () -> Unit, endCallback: () -> Unit) {
    val coroutineScope = rememberCoroutineScope()

    if (pageTransition != PageTransition.NONE) {
        coroutineScope.launch {
            delay(300)
            middleCallback()
        }
        coroutineScope.launch {
            delay(600)
            endCallback()
        }
    }

    Div({
        classes("page-transition")
        if (pageTransition == PageTransition.FROM_LEFT)
            classes("from-left")
        if (pageTransition == PageTransition.FROM_RIGHT)
            classes("from-right")
    })
}
