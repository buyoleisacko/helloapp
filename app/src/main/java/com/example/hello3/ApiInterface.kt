package com.example.hello3

import android.os.Parcel
import android.os.Parcelable
import android.telecom.Call

package com.example.hello.api

import com.example.hello.models.CoursesResponse
import com.example.hello.models.LoginResponse
import com.example.hello.models.RegisterCourse
import com.example.hello.models.RegistrationResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface() : Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    @POST("register")
    fun registerStudent(@Body requestBody: RequestBody): Call<RegistrationResponse>

    @POST("login")
    fun loginStudent(@Body requestBody: RequestBody): Call<LoginResponse>


    @GET("courses")
    fun getCourses(@Header("Authorization") accessToken: String): Call<CoursesResponse>

    @POST("register-course")
    fun registerCourse(
        @Body requestBody: RequestBody,
        @Header("Authorization") accessToken: String
    ): Call<RegisterCourse>

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ApiInterface> {
        override fun createFromParcel(parcel: Parcel): ApiInterface {
            return ApiInterface(parcel)
        }

        override fun newArray(size: Int): Array<ApiInterface?> {
            return arrayOfNulls(size)
        }
    }

}

