import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import components.*
import kotlinx.browser.localStorage
import kotlinx.browser.window
import lib.*
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.url.URLSearchParams
import pages.*

suspend fun main() {
    try {
        fetchLanguages()
    } catch (it: Exception) {
        println(it.message)
        // TODO: show error
        return
    }

    var route: Route by mutableStateOf(Route.HOME)
    var nextRoute: Route by mutableStateOf(Route.HOME)
    var pageTransition: PageTransition by mutableStateOf(PageTransition.NONE)
    var currentLanguage: Language? by mutableStateOf(null)

    fun setRoute(it: Route) {
        if (it == route)
            return

        nextRoute = it
        if (Route.values().indexOf(route) < Route.values().indexOf(nextRoute))
            pageTransition = PageTransition.FROM_RIGHT
        if (Route.values().indexOf(route) > Route.values().indexOf(nextRoute))
            pageTransition = PageTransition.FROM_LEFT
    }

    fun setLanguage(language: Language) {
        currentLanguage = language
        localStorage.setItem("language", language.short)
    }
    loadLanguage(::setLanguage)

    val searchParams = URLSearchParams(window.location.search.substring(1))

    val loadSearchLanguage = { lang: String ->
        languages.firstOrNull { it.short.lowercase() == lang.lowercase() || it.name.lowercase() == lang.lowercase() }
            ?.let(::setLanguage)
    }
    searchParams.get("l")?.let(loadSearchLanguage)
    searchParams.get("language")?.let(loadSearchLanguage)

    val loadSearchRoute = { searchRoute: String ->
        Route.values().firstOrNull { it.toString().lowercase() == searchRoute.lowercase() }
            ?.let { route = it }
    }
    searchParams.get("r")?.let(loadSearchRoute)
    searchParams.get("route")?.let(loadSearchRoute)

    renderComposable(rootElementId = "root") {
        val addShortcut = ShortcutsProvider(route)

        PageTransition(pageTransition, { route = nextRoute }) {
            pageTransition = PageTransition.NONE
        }
        Navbar(currentLanguage!!.translations.navbar, addShortcut, route, ::setRoute)
        LanguageSettings(addShortcut, currentLanguage!!, ::setLanguage)

        Content {
            when (route) {
                Route.HOME -> Home(currentLanguage!!.translations.home, ::setRoute)
                Route.ABOUT -> About(currentLanguage!!.translations.about)
                Route.SKILLS -> Skills(currentLanguage!!.translations.skills)
                Route.PROJECTS -> Projects(currentLanguage!!.translations.projects)
                Route.CONTACT -> Contact(currentLanguage!!.translations.contact, addShortcut)
            }
        }
    }
}
