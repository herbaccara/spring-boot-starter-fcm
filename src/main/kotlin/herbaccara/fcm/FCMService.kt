package herbaccara.fcm

import herbaccara.boot.autoconfigure.fcm.FCMProperties
import herbaccara.fcm.form.FCMForm
import herbaccara.fcm.model.FCMResult
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForObject

class FCMService(
    private val restTemplate: RestTemplate,
    private val properties: FCMProperties
) {
    fun send(request: FCMForm): FCMResult {
        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
            add("Authorization", "key=" + properties.serverKey)
        }

        val httpEntity = HttpEntity<FCMForm>(request, headers)
        return restTemplate.postForObject(properties.url, httpEntity)
    }
}
