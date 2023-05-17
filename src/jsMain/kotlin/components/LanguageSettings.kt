package components

import androidx.compose.runtime.*
import lib.Language
import lib.languages
import org.jetbrains.compose.web.attributes.Draggable
import org.jetbrains.compose.web.dom.*

@Composable
fun LanguageSettings(addShortcut: AddShortcut, currentLanguage: Language, setLanguage: (Language) -> Unit) {
    var open by remember { mutableStateOf(false) }

    addShortcut("*", Shortcut("l", 76) { open = !open })

    Div({
        classes("language-settings")
    }) {
        Button({
            classes("language-settings-toggle")
            onClick { open = !open }
        }) {
            Img("/icons/${currentLanguage.icon}", "${currentLanguage.name} flag") {
                classes("language-flag")
                draggable(Draggable.False)
            }
            P({
                classes("language-name")
            }) {
                Text(currentLanguage.short[0].uppercase() + currentLanguage.short.substring(1))
            }
        }

        Div({
            classes("language-dropdown")
            if (open)
                classes("active")
        }) {
            languages.forEach { language ->
                if (language.name == currentLanguage.name)
                    return@forEach

                Button({
                    classes("language-dropdown-item")
                    onClick { setLanguage(language) }
                }) {
                    Img("/icons/${language.icon}", "${language.name} flag") {
                        classes("language-flag")
                    }
                    P({
                        classes("language-name")
                    }) {
                        Text(language.short[0].uppercase() + language.short.substring(1))
                    }
                }
            }
        }
    }
}
