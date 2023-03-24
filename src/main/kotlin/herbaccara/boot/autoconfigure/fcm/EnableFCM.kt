package herbaccara.boot.autoconfigure.fcm

import org.springframework.context.annotation.Import
import java.lang.annotation.*

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(FCMAutoConfiguration::class)
annotation class EnableFCM
