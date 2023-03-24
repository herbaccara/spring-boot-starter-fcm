package herbaccara.fcm.form

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.toasttab.ksp.builder.annotations.GenerateBuilder
import herbaccara.fcm.form.payload.Payload

// https://firebase.google.com/docs/cloud-messaging/http-server-ref?hl=ko#downstream-http-messages-json
@JsonInclude(JsonInclude.Include.NON_NULL)
@GenerateBuilder
data class FCMForm @JvmOverloads constructor(
    val to: String? = null,
    @field:JsonProperty("registration_ids") val registrationIds: List<String>? = null, // max 1,000
    val condition: Boolean? = null,
    @field:JsonProperty("collapse_key") val collapseKey: String? = null,
    val priority: Priority? = null,
    @field:JsonProperty("content_available") val contentAvailable: Boolean? = null,
    @field:JsonProperty("mutable_content") val mutableContent: Boolean? = null,
    @field:JsonProperty("time_to_live") val timeToLive: Int? = null,
    @field:JsonProperty("restricted_package_name") val restrictedPackageName: String? = null,
    @field:JsonProperty("dry_run") val dryRun: Boolean? = null,
    val data: Payload
) {

    companion object {
        @JvmStatic
        fun builder(): FCMFormBuilder = FCMFormBuilder()
    }
}
