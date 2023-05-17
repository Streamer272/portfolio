package pages

import androidx.compose.runtime.Composable
import lib.HomeTranslationTable
import lib.Route
import org.jetbrains.compose.web.dom.*

@Composable
fun Home(R: HomeTranslationTable, setRoute: (Route) -> Unit) {
    // TODO: add shortcuts help

    Div({
        classes("home")
    }) {
        H2({
            classes("title")
            classes("t1")
        }) {
            Text(R.title1)
        }
        H1({
            classes("title")
            classes("t2")
        }) {
            Text(R.title2)
        }
        H2({
            classes("title")
            classes("t3")
        }) {
            Text(R.title3)
        }

        P({
            classes("description")
        }) {
            Text(R.lookAt)
        }

        A(null, {
            classes("description")
            classes("link")
            onClick {
                setRoute(Route.ABOUT)
            }
        }) {
            Text(R.about)
        }

        P({
            classes("description")
        }) {
            Text(R.or)
        }

        A(null, {
            classes("description")
            classes("link")
            onClick {
                setRoute(Route.CONTACT)
            }
        }) {
            Text(R.contact)
        }

        P({
            classes("description")
        }) {
            Text(R.period)
        }
    }
}
