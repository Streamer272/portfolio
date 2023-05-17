package pages

import androidx.compose.runtime.Composable
import lib.Skill
import lib.SkillsTranslationTable
import org.jetbrains.compose.web.dom.*

@Composable
fun Skills(R: SkillsTranslationTable) {
    Div({
        classes("skills")
    }) {
        H1({
            classes("skills-title")
        }) {
            Text(R.title)
        }
        H3({
            classes("skills-subtitle")
        }) {
            Text(R.subtitle)
        }
        Hr {
            classes("skills-title-spacer")
        }

        SkillsList(R.frontendTitle, R.frontendSkills)
        SkillsList(R.backendTitle, R.backendSkills)
        SkillsList(R.databaseTitle, R.databaseSkills)
        SkillsList(R.otherTitle, R.otherSkills)
    }
}

@Composable
fun SkillsList(title: String, skills: List<Skill>) {
    H4({
        classes("skills-list-title")
    }) {
        Text(title)
    }
    Ul({
        classes("skills-list")
    }) {
        skills.forEach { skill ->
            Li({
                classes("skills-list-item")
            }) {
                P({
                    classes("skills-list-item-text")
                    if (skill.golden)
                        classes("golden")
                }) {
                    Text(skill.name)
                }
            }
        }
    }
}
