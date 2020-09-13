package com.example.hello3.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.telecom.Call
import android.widget.Toast
import com.example.hello.models.LoginResponse
import com.example.hello.R
import com.example.hello.activities.MultipartBody
import com.example.hello.api.ApiClient
import com.example.hello.api.ApiInterface
import com.example.hello3.ApiClient
import com.example.hello3.ApiInterface
import com.example.hello3.R
import ke.co.hello.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration2.*

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.security.auth.callback.Callback

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {

            val email = tvEmail.text.toString()
            val password = tvConfirmPassword.text.toString()

            var requestBody = MultipartBody.Builder()
                .setType(form = MultipartBody.FORM)
                .addFormDataPart("email", email)
                .addFormDataPart("password", password)
                .build().apply({

                    signInUser(this)
                })

        }
    }

    private fun signInUser(requestBody: requestBody) {

        var apiClient = ApiClient.buildService(ApiInterface::class.java)
        var call = apiClient.loginStudent(requestBody).apply {

            return@apply enqueue(any = object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()

                        var accessToken = response.body()?.accessToken
                        val studentId = response.body()?.studentId
                        var sharedPreferences =
                            PreferenceManager.getDefaultSharedPreferences(baseContext)
                        var editor = sharedPreferences.edit()
                        editor.putString("ACCESS_TOKEN_KEY", accessToken)
                        editor.putString("STUDENT_ID_KEY", studentId)
                        editor.apply()

                        startActivity(Intent(baseContext, CoursesActivity::class.java))
                    } else {
                        Toast.makeText(baseContext, response.message().toString(), Toast.LENGTH_LONG)
                            .show()
                    }
                }

            })
        }

    }

    private fun enqueue(any: Any): Any {
        TODO("Not yet implemented")
    }
}

enum class requestBody {

}

private fun Any.addFormDataPart(r: String, email: String): Any {
    TODO("Not yet implemented")
}
