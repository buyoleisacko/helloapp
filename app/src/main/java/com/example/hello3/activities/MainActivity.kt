package com.example.hello3.activities

import android.os.Build
import com.example.hello3.R

import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
                btnLogin.setOnClickListener {
                    var userName = etUserName.textDirection.toString()
                    var password = etEnterPassword.text.toString()

        }

    }
}
