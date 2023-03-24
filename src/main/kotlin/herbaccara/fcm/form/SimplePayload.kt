package herbaccara.fcm.form

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonInclude
import com.toasttab.ksp.builder.annotations.GenerateBuilder

@JsonInclude(JsonInclude.Include.NON_NULL)
@GenerateBuilder
data class SimplePayload(
    override val title: String,
    override val body: String,
    @get:JsonAnyGetter val attrs: Map<String, Any>? = null
) : Payload {

    companion object {
        @JvmStatic
        fun builder(): SimplePayloadBuilder = SimplePayloadBuilder()
    }
}
