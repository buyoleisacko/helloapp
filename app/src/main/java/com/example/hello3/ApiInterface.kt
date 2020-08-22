package com.example.hello3

import android.os.Parcel
import android.os.Parcelable
import android.telecom.Call
import OkHttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import com.example.hello3.LoginResponse as Hello3LoginResponse


interface ApiInterface() {

    @POST("register")
    fun registerStudent(@Body requestBody: RequestBody): Call<RegistrationResponse>
    @POST("login")
    fun loginStudent(@Body requestBody: RequestBody): Call<Hello3LoginResponse>

}

class
LoginResponse {

}
