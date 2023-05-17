package lib

import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.fetch.RequestInit

enum class HttpMethod {
    GET,
    POST,
    PUT,
    PATCH,
    DELETE
}

suspend inline fun <reified T> fetch(url: String, method: HttpMethod = HttpMethod.GET, data: Serializable? = null): T? {
    val response = window.fetch(
        url,
        RequestInit(
            method.toString(),
            headers = mapOf("Content-Type" to "application/json"),
            body = if (data != null) Json.encodeToString(data) else null
        )
    ).await()
    if (!response.ok) {
        println("Failed to fetch $url with status code ${response.status}")
        return null
    }

    val text = response.text().await()
    return Json.decodeFromString<T>(text)
}
