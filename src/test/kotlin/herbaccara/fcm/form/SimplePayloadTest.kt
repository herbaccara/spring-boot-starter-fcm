package herbaccara.fcm.form

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import herbaccara.fcm.form.payload.SimplePayload
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SimplePayloadTest {

    @Test
    fun test() {
        val objectMapper = jacksonObjectMapper().apply {
            findAndRegisterModules()
        }

        val payload = SimplePayload.builder()
            .title("제목")
            .body("내용")
            .putAttrs("foo", "11111")
            .putAttrs("bar", 11111)
            .build()

        val json = objectMapper.writeValueAsString(payload)
        println(json)

        Assertions.assertEquals("{\"title\":\"제목\",\"body\":\"내용\",\"foo\":\"11111\",\"bar\":11111}", json)
    }
}
