package digitalfleet.android.ktorsample

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BoredResponse(
    @SerialName("activity") val activity: String,
)