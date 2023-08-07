package digitalfleet.android.ktorsample

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.encodedPath
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class Network {
    val httpClient = HttpClient {
        expectSuccess = true
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
        defaultRequest {
            // todo make dynamic
            url {
                protocol = URLProtocol.HTTPS
                host = "www.boredapi.com"
                encodedPath = "/api$encodedPath"
            }

            contentType(ContentType.Application.Json)
        }
    }

    suspend fun callApi(): BoredResponse {
        val override = "api/activity"
        return httpClient.get("activity") {

        }.body()
    }
}