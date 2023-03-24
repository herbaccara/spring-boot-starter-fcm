package herbaccara.fcm.form.payload

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.toasttab.ksp.builder.annotations.GenerateBuilder
import herbaccara.fcm.form.IOSPayloadBuilder

@JsonInclude(JsonInclude.Include.NON_NULL)
@GenerateBuilder
data class IOSPayload @JvmOverloads constructor(
    override val title: String,
    override val body: String,
    val sound: String? = null,
    val badge: String? = null,
    @field:JsonProperty("click_action") val clickAction: String? = null,
    val subtitle: String? = null,
    @field:JsonProperty("body_loc_key") val bodyLocKey: String? = null,
    @field:JsonProperty("body_loc_args") val bodyLocArgs: List<String>? = null,
    @field:JsonProperty("title_loc_key") val titleLocKey: String? = null,
    @field:JsonProperty("title_loc_args") val titleLocArgs: List<String>? = null,
    @get:JsonAnyGetter val attrs: Map<String, Any>? = null
) : Payload {

    companion object {
        @JvmStatic
        fun builder(): IOSPayloadBuilder = IOSPayloadBuilder()
    }
}
