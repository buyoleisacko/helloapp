package com.example.hello3

data class RegistrationResponse(
    @SerializedName("message") var message: String,
    @SerializedName("student") var student: Student
)

class Student {

}

annotation class SerializedName(val value: String)
