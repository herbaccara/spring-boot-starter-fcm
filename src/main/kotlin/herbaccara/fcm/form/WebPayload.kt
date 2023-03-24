package herbaccara.fcm.form

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.toasttab.ksp.builder.annotations.GenerateBuilder

@JsonInclude(JsonInclude.Include.NON_NULL)
@GenerateBuilder
data class WebPayload(
    override val title: String,
    override val body: String,
    val icon: String? = null,
    @field:JsonProperty("click_action") val clickAction: String? = null,
    @get:JsonAnyGetter val attrs: Map<String, Any>? = null
) : Payload {

    companion object {
        @JvmStatic
        fun builder(): WebPayloadBuilder = WebPayloadBuilder()
    }
}
