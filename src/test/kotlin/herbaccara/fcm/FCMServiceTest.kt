package herbaccara.fcm

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import herbaccara.boot.autoconfigure.fcm.FCMAutoConfiguration
import herbaccara.fcm.form.FCMForm
import herbaccara.fcm.form.payload.AndroidPayload
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

@SpringBootTest(
    classes = [
        FCMAutoConfiguration::class
    ]
)
@TestPropertySource(locations = ["classpath:application.yml"])
class FCMServiceTest {

    @Autowired
    lateinit var fcmService: FCMService

    @Test
    fun test() {
        val token =
            "feOGplt4RE6zLBVVMRx_ak:APA91bH87WpWmZ7LkcTUqy9spqBpjUXfLX5WXETfinl2mAU4qIyJCZESgnpBg9mA-QM6Z9yxGr3LgCGzXhUowMACuvY1PvL6gchshTbOju1il71VSJIbtGUTBs9X9qObt6LPPzRTXSXa"

        val fcmRequest = FCMForm.builder()
//            .to(token)
            .registrationIds(
                listOf(
                    token,
                    "asdfsadfsadf"
                )
            )
            .data(
                AndroidPayload.builder()
                    .title("제목오오오오")
                    .body("바디이이이이이")
                    .sound("사운드드드드")
                    .putAttrs("foo", "11")
                    .putAttrs("bar", 22)
                    .build()
            )
//            .dryRun(true)
            .build()

        val objectMapper = jacksonObjectMapper()
        val json = objectMapper.writeValueAsString(fcmRequest)
        println(json)

        val response = fcmService.send(fcmRequest)
        println(response)
    }
}
