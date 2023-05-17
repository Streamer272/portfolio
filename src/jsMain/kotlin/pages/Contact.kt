package pages

import androidx.compose.runtime.*
import androidx.compose.web.events.SyntheticMouseEvent
import components.AddShortcut
import components.Popup
import components.PopupMetadata
import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import lib.ContactTranslationTable
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.events.SyntheticSubmitEvent

@Composable
fun Contact(R: ContactTranslationTable, addShortcut: AddShortcut) {
    var subject: String by remember { mutableStateOf("") }
    var message: String by remember { mutableStateOf("") }
    var popupMetadata: PopupMetadata by remember { mutableStateOf(PopupMetadata.default()) }
    val coroutineScope = rememberCoroutineScope()

    fun onSubmit(event: SyntheticSubmitEvent) {
        event.preventDefault()
        event.stopPropagation()
        window.open("mailto:daniel@svitan.dev?subject=${subject}&body=${message}", "_blank")
    }

    @Composable
    fun popupContent() {
        Text(R.copied)
    }

    fun popupDisable() {
        popupMetadata = PopupMetadata(
            popupMetadata.position,
            false,
            disable = ::popupDisable,
        ) {
            popupContent()
        }
    }

    fun copyAdditionalInfo(event: SyntheticMouseEvent, additionalInfo: String) {
        window.navigator.clipboard.writeText(additionalInfo)
        coroutineScope.launch {
            popupMetadata = PopupMetadata(
                Pair(event.clientX.px, event.clientY.px),
                true,
                ::popupDisable
            ) {
                popupContent()
            }
            delay(1500L)
            popupDisable()
        }
    }

    Popup(popupMetadata, addShortcut)

    Div({
        classes("contact")
    }) {
        H1 {
            Text(R.title)
        }
        Hr()

        Div({
            classes("contact-options")
        }) {
            Form(null, {
                classes("contact-form")
                onSubmit(::onSubmit)
            }) {
                H3({
                    classes("subtitle")
                }) {
                    Text(R.emailSubtitle)
                }

                Input(InputType.Text) {
                    classes("contact-form-input")
                    classes("contact-form-subject")
                    placeholder(R.subject)
                    onChange { subject = it.value }
                }
                TextArea {
                    classes("contact-form-input")
                    classes("contact-form-message")
                    placeholder(R.message)
                    onChange { message = it.value }
                }

                Button({
                    type(ButtonType.Submit)
                    classes("contact-form-submit")
                }) {
                    Text(R.send)
                }
            }

            Div({
                classes("contact-social-media-container")
            }) {
                H3({
                    classes("subtitle")
                }) {
                    Text(R.socialMediaSubtitle)
                }

                Ul({
                    classes("contact-social-media-list")
                }) {
                    R.socialMedia.forEach { socialMedia ->
                        Li({
                            classes("contact-social-media")
                        }) {
                            A(socialMedia.url, {
                                target(ATarget.Blank)
                                classes("contact-social-media-link")
                            }) {
                                Img("/icons/${socialMedia.icon}", socialMedia.name) {
                                    classes("contact-social-media-icon")
                                }
                                P({
                                    classes("contact-social-media-name")
                                }) {
                                    Text(socialMedia.name)
                                }
                            }
                            socialMedia.additionalInfo?.let { additionalInfo ->
                                Button({
                                    classes("contact-social-media-additional-info")
                                    onClick { copyAdditionalInfo(it, additionalInfo) }
                                }) {
                                    Text(additionalInfo)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
