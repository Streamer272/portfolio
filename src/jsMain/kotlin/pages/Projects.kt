package pages

import androidx.compose.runtime.Composable
import lib.ProjectPhase
import lib.ProjectsTranslationTable
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.*

@Composable
fun Projects(R: ProjectsTranslationTable) {
    Div({
        classes("projects")
    }) {
        H1 {
            Text(R.title)
        }

        Hr()

        R.projects.forEach { project ->
            Div({
                classes("project")
            }) {
                H3({
                    classes("title")
                }) {
                    if (project.url == null) {
                        Text(project.name)
                    } else {
                        A(project.url, {
                            classes("url")
                        }) {
                            Text(project.name)
                            Div({
                                classes("underline")
                            })
                        }
                    }
                    Div({
                        classes("status")
                        when (project.phase) {
                            ProjectPhase.PLANNING -> {
                                classes("planning")
                                title(R.planning)
                            }

                            ProjectPhase.DEVELOPMENT -> {
                                classes("development")
                                title(R.development)
                            }

                            ProjectPhase.PRODUCTION -> {
                                classes("production")
                                title(R.production)
                            }

                            ProjectPhase.DEPRECATED -> {
                                classes("deprecated")
                                title(R.deprecated)
                            }
                        }
                    })
                }

                project.description?.let {
                    P({
                        classes("description")
                    }) {
                        Text(it)
                    }
                }

                if (project.sources == null) {
                    P({
                        classes("proprietary")
                    }) {
                        Text(R.proprietary)
                    }
                } else {
                    Ul({
                        classes("sources")
                    }) {
                        project.sources.forEach { source ->
                            Li({
                                classes("source")
                            }) {
                                A(source.href, {
                                    target(ATarget.Blank)
                                }) {
                                    Text(source.name)
                                    Div({
                                        classes("underline")
                                    })
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
