package com.example.hello.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hello.R
import com.example.hello.models.RegistrationResponse
import com.example.hello.api.ApiClient
import com.example.hello.api.ApiInterface
import com.example.hello3.ApiClient
import com.example.hello3.ApiInterface
import com.example.hello3.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_registration2.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.telecom.Call as Call1
import com.example.hello3.RegistrationResponse as RegistrationResponse1
import javax.security.auth.callback.Callback as Callback1

class RegistrationActivity<RequestBody> : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration2)

        btnRegister.setOnClickListener {
            val firstName = tvFirstName.text.toString()
            var lastName = tvLastName.text.toString()
            val email = tvEmail.text.toString()
            val phoneNumber = tvPhoneNumber.text.toString()
            val password = tvForgotPassword.text.toString()

            var requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("first_name", firstName)
                .addFormDataPart("last_name", lastName)
                .addFormDataPart("email", email)
                .addFormDataPart("phone_number", phoneNumber)
                .addFormDataPart("password", password)
                .build()

            signUpUser(requestBody)

        }
    }

    private fun signUpUser(requestBody: RequestBody) {

        var apiClient = ApiClient.buildService(ApiInterface::class.java)
        var registrationCall = apiClient.registerStudent(requestBody)


        val enqueue = registrationCall.enqueue(object : Callback1<RegistrationResponse1> {
            override fun onFailure(call: Call1<RegistrationResponse1>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            fun onResponse(call: Call1<RegistrationResponse1>, response: RegistrationResponse1<RegistrationResponse1>) {
                if (response.isSuccessful) {
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    startActivity(Intent(baseContext, Login::class.java))
                } else {
                    Toast.makeText(baseContext, response.message().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
}

class MultipartBody {
    object FORM {

    }

    class Builder {
        fun setType(form: Any): Any {

        }

    }

}

class Login {

}
