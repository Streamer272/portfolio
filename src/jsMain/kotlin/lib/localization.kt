package lib

import kotlinx.browser.localStorage
import kotlinx.browser.window
import kotlinx.serialization.Serializable

@Serializable
class TranslationTable(
    val home: HomeTranslationTable,
    val about: AboutTranslationTable,
    val skills: SkillsTranslationTable,
    val projects: ProjectsTranslationTable,
    val contact: ContactTranslationTable,
    val navbar: NavbarTranslationTable
)

@Serializable
class HomeTranslationTable(
    val title1: String,
    val title2: String,
    val title3: String,
    val lookAt: String,
    val or: String,
    val about: String,
    val contact: String,
    val period: String,
    val shortcuts: String
)

@Serializable
class AboutTranslationTable(
    val title: String,
    val nameAndAge: List<AboutText>,
    val education: List<AboutText>,
    val hobbies: List<AboutText>,
    val spokenLanguages: List<AboutText>
)

@Serializable
class AboutText(
    var value: String,
    val format: Boolean = false,
    val special: Boolean = false
)

@Serializable
class SkillsTranslationTable(
    val title: String,
    val subtitle: String,
    val frontendTitle: String,
    val frontendSkills: List<Skill>,
    val backendTitle: String,
    val backendSkills: List<Skill>,
    val databaseTitle: String,
    val databaseSkills: List<Skill>,
    val otherTitle: String,
    val otherSkills: List<Skill>
)

@Serializable
class Skill(
    val name: String,
    val golden: Boolean = false
)

@Serializable
class ProjectsTranslationTable(
    val title: String,
    val proprietary: String,
    val planning: String,
    val development: String,
    val production: String,
    val deprecated: String,
    val projects: List<Project>
)

@Serializable
class Project(
    val name: String,
    val description: String? = null,
    val url: String? = null,
    val sources: List<ProjectSource>?,
    val phase: ProjectPhase
)

@Serializable
class ProjectSource(
    val name: String,
    val href: String
)

@Serializable
enum class ProjectPhase {
    PLANNING,
    DEVELOPMENT,
    PRODUCTION,
    DEPRECATED
}

@Serializable
class ContactTranslationTable(
    val title: String,
    val emailSubtitle: String,
    val socialMediaSubtitle: String,
    val socialMedia: List<SocialMedia>,
    val subject: String,
    val message: String,
    val send: String,
    val copied: String,
)

@Serializable
class SocialMedia(
    val name: String,
    val icon: String,
    val url: String,
    val additionalInfo: String? = null
)

@Serializable
class NavbarTranslationTable(
    val previous: String,
    val next: String,
    val pages: HashMap<String, String>
)

@Serializable
class Language(val name: String, val short: String, val icon: String, val translations: TranslationTable)

var languages: Array<Language> = arrayOf()
private val languageFiles: List<String> = listOf("en", "sk")

suspend fun fetchLanguages() {
    for (languageFile in languageFiles) {
        val language = fetch<Language>(
            "${window.location.origin}/localization/$languageFile.json"
        ) ?: continue
        languages += language
    }
}

fun loadLanguage(setLanguage: (Language) -> Unit) {
    fun checkLanguage(short: String) {
        languages.firstOrNull { it.short == short }?.let {
            setLanguage(it)
        } ?: run {
            setLanguage(languages[0])
            println("Language (${window.navigator.language}) isn't supported yet, defaulting to ${languages[0].name}")
        }
    }

    localStorage.getItem("language")?.let {
        checkLanguage(it)
    } ?: run {
        checkLanguage(window.navigator.language.split("-")[0])
    }
}
