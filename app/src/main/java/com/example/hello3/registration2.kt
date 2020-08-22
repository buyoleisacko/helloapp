package com.example.hello3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.widget.Toast
import android.widget.Toast.*
import kotlinx.android.synthetic.main.activity_registration2.*
import javax.security.auth.callback.Callback
import com.example.hello3.RegistrationResponse as RegistrationResponse1

class registration2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration2)
        btnSignUp.setOnClickListener {
        var firstName = tvFirstName.text.toString()
        var lastName = tvLastName.text.toString()
        var email = tvEmail.text.toString()
        var phonenumber = tvPhoneNumber.text.toString()
        var password = tvPassWord.text.toString()
        var confirmPassword = tvConfirmPassword.text.toString()

            var requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("first_name", firstName)
                .addFormDataPart("last_name", lastName)

                .build()

            registerUser(requestBody)
            makeText(baseContext, lastName, LENGTH_SHORT).show()
        }
    }


    fun registerUser(requestBody: RequestBody) {
        var apiClient = ApiClient.buildService(ApiInterface::class.java)
        var registrationCall = apiClient.registerStudent(requestBody)
        val enqueue: Any = registrationCall.enqueue(object : Callback<RegistrationResponse1> {
            fun onFailure(
                call: Call<RegistrationResponse1>,
                t: Throwable
            ) =
                makeText(baseContext, t.message, LENGTH_LONG).show()

            fun onResponse(
                call: Call<RegistrationResponse1>,
                response: Response<RegistrationResponse1>
            ): Any {
                if (response.isSuccessful) {
                    makeText(baseContext, response.body()?.message, LENGTH_LONG).show()
                    startActivity(Intent(baseContext, MainActivity::class.java))
                } else {
                    val show: Any =
                        makeText(baseContext, response.errorBody().toString(), LENGTH_LONG)
                            .show()
                    when {
                        !!!status.equals("Success!") -> {
                        }
                        else -> {
                            // ADD  to save  and  read next time
                            String strUserName = mEditText1.getText().toString().trim();
                            String strPassword = mEditText2.getText().toString().trim();
                            if (null == strUserName || strUserName.length() == 0) {
                                // showToast("Enter Your Name");
                                mEditText1.setError( "username is required!" );
                                boolean isUserValidated = false;
                            }
                            if (null == strPassword || strPassword.length() == 0) {
                                // showToast("Enter Your Password");
                                //isPasswordValidated = false;
                                mEditText2.setError( "password is required!" );
                            }
                        }
                    }
                }
            }

            inner class Response<T> {

                val isSuccessful: Boolean = false
            }
        })
    }


interface RequestBody {


}
}

    }
}