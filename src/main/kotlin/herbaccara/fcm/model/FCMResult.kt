package herbaccara.fcm.model

import com.fasterxml.jackson.annotation.JsonProperty

// https://firebase.google.com/docs/cloud-messaging/http-server-ref?hl=ko#interpret-downstream
data class FCMResult(
    // 원 데이터는 long 타입이긴한데... 머지 않아 long 의 범위를 넘어 설 수 있기 때문에 문자열로 맵핑 처리
    // dry_run 이 true 인 경우 -1 로 리턴 된다.
    @field:JsonProperty("multicast_id") val multicastId: String,
    val success: Int,
    val failure: Int,
//    @field:JsonProperty("canonical_ids") val canonicalIds: Int,
    val results: List<Result>
) {
    data class Result(
        @JsonProperty("message_id") val messageId: String? = null,
        val error: String? = null
    )
}
