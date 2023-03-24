package herbaccara.boot.autoconfigure.fcm

import herbaccara.fcm.FCMService
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.util.StringUtils
import org.springframework.web.client.RestTemplate
import java.util.*

@AutoConfiguration
@EnableConfigurationProperties(FCMProperties::class)
@ConditionalOnProperty(prefix = "fcm", value = ["enabled"], havingValue = "true", matchIfMissing = true)
class FCMAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun fcmService(restTemplate: RestTemplate, properties: FCMProperties): FCMService {
        if (!StringUtils.hasText(properties.url)) {
            throw NullPointerException()
        }
        if (!StringUtils.hasText(properties.serverKey)) {
            throw NullPointerException()
        }
        return FCMService(restTemplate, properties)
    }
}
