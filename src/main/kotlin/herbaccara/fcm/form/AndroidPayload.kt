package herbaccara.fcm.form

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.toasttab.ksp.builder.annotations.GenerateBuilder

@JsonInclude(JsonInclude.Include.NON_NULL)
@GenerateBuilder
data class AndroidPayload(
    override val title: String,
    override val body: String,
    @field:JsonProperty("android_channel_id") val androidChannelId: String? = null,
    val icon: String? = null,
    val sound: String? = null,
    val tag: String? = null,
    val color: String? = null,
    @field:JsonProperty("click_action") val clickAction: String? = null,
    @field:JsonProperty("body_loc_key") val bodyLocKey: String? = null,
    @field:JsonProperty("body_loc_args") val bodyLocArgs: List<String>? = null,
    @field:JsonProperty("title_loc_key") val titleLocKey: String? = null,
    @field:JsonProperty("title_loc_args") val titleLocArgs: List<String>? = null,
    @get:JsonAnyGetter val attrs: Map<String, Any>? = null
) : Payload {

    companion object {
        @JvmStatic
        fun builder(): AndroidPayloadBuilder = AndroidPayloadBuilder()
    }
}
