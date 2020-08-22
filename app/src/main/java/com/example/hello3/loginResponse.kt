package ke.co.hello

import com.example.hello3.SerializedName
import com.example.hello3.SerializedName


.gson.annotations.SerializedName


data class LoginResponse(
    @SerializedName("access_token") var accessToken: String,
    @SerializedName("message") var message: String
)
