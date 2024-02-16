package data.network

import domain.ApiRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse


class ApiService(
    private val baseUrl: String,
    private val httpClient: HttpClient,
) {

    suspend fun sendRequest(apiRequest: ApiRequest): HttpResponse? {
        val httpResponse = try {
            httpClient.post("${baseUrl}chat/completions") {
                setBody(apiRequest)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
        return httpResponse
    }
}