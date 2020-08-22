package com.example.hello3

import android.app.TaskStackBuilder.create
import android.content.IntentFilter.create
import android.database.sqlite.SQLiteDatabase.create
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URI.create

object ApiClient {
    private var client = OkHttpClient.Builder().build()

    var retrofit
        get() = Retrofit.Builder()
            .baseUrl("https://courses-service.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.
            create())
            .client(client)
            .build()
        set(value) = TODO()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}

class OkHttpClient {

}

private fun Retrofit.Builder.baseUrl(s: Comparable<String>): Any {

}
 