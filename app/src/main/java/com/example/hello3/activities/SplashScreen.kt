package com.example.hello3.activities

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.example.hello.R
import com.example.hello3.R

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.SplashScreen_activity)


        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        var accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        if (accessToken.isNullOrEmpty()) {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(baseContext, CoursesActivity::class.java)
            startActivity(intent)
        }
    }
}

class SplashScreen {
}