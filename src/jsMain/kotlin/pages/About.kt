package pages

import androidx.compose.runtime.Composable
import lib.AboutText
import lib.AboutTranslationTable
import org.jetbrains.compose.web.dom.*
import kotlin.js.Date

@Composable
fun About(R: AboutTranslationTable) {
    val currentDate = Date()
    val hadBirthday =
        (currentDate.getMonth() + 1 > 8) || (currentDate.getMonth() + 1 == 8 && currentDate.getDate() >= 23)
    val yearsOld = (currentDate.getFullYear() - 2006) - (if (hadBirthday) 0 else 1)
    val englishYears = currentDate.getFullYear() - 2014
    val germanYears = currentDate.getFullYear() - 2017

    for (line in R.nameAndAge.filter { it.format }) {
        line.value = line.value.replace("%yo%", yearsOld.toString())
    }

    for (line in R.spokenLanguages.filter { it.format }) {
        line.value = line.value.replace("%ey%", englishYears.toString()).replace("%gy%", germanYears.toString())
    }

    Div({
        classes("about")
    }) {
        H1 {
            Text(R.title)
        }

        Hr()

        P({
            classes("paragraph")
        }) {
            SpecialText(R.nameAndAge)
        }

        P({
            classes("paragraph")
        }) {
            SpecialText(R.education)
        }

        P({
            classes("paragraph")
        }) {
            SpecialText(R.hobbies)
        }

        P({
            classes("paragraph")
        }) {
            SpecialText(R.spokenLanguages)
        }
    }
}

@Composable
fun SpecialText(text: List<AboutText>) {
    var specialCharIndex = 0
    for (line in text) {
        for (char in line.value) {
            Span({
                if (line.special)
                    classes("special-char-${specialCharIndex++}")
            }) {
                Text(char.toString())
            }
        }
    }
}
