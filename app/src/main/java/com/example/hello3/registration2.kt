
package com.example.firstapp

import android.animation.ObjectAnimator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration2.*

 class registrationactivity2 : AppCompatActivity() {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_registrationactivity2)
    etRegister.setOnClickListener {
         run {
             var firstName = tvFirstName.text.toString()
             var password = etEnterPassword.text.toString()
             var lastName = tvLastName.text.toString()
             var etConfirmEmail = null
             var email = etConfirmEmail.text.toString()
             var phoneNumber = tvPhoneNumber.text.toString()
             var confirmPassword = tvPassWord.text.toString()

             if (firstName.isBlank() || firstName.isEmpty()) {
                 tvFirstName.error = "First Name is required"
             }
             if (lastName.isBlank() || lastName.isEmpty()) {
                 tvLastName.error = "Last Name is required"
             }
             if (email.isBlank() || email.isEmpty()) {
                 tvEmail.error = "Email is required"
             }
             if (phoneNumber.isBlank() || phoneNumber.isEmpty()) {
                 tvPhoneNumber.error = "Phone Number is required"
             }
             if (password.isBlank() || password.isEmpty()) {
                 etPassword.error = "Password is required"
             }
             if (confirmPassword.isBlank() || confirmPassword.isEmpty()) {
                 etPassword.error = "Confirm your password"
             }
             progressBar.max = 1000
             val currentProgress = 600
             ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
                 .setDuration(20000)
                 .start()


             var requestBody = MultipartBody.Builder()
                 .setType(MultipartBody.FORM)
                 .addFormDataPart("first_name", firstName)
                 .addFormDataPart("last_name", lastName)
                 .addFormDataPart("email", email)
                 .addFormDataPart("phone_number", phoneNumber)
                 .addFormDataPart("password", password)
                 .build()

             //registerUser(requestBody)
             Toast.makeText(baseContext, password, Toast.LENGTH_LONG).show()


         }

         class MultipartBody {

         }
