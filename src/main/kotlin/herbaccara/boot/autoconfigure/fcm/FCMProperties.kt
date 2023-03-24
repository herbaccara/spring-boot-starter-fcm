package herbaccara.boot.autoconfigure.fcm

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "fcm")
@ConstructorBinding
data class FCMProperties(
    val enabled: Boolean = true,
    val url: String = "https://fcm.googleapis.com/fcm/send",
    val serverKey: String
)
