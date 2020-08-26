package com.example.hello3

import android.app.TaskStackBuilder.create
import android.content.IntentFilter.create
import android.database.sqlite.SQLiteDatabase.create
import android.media.audiofx.AcousticEchoCanceler.create
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URI.create
import java.util.stream.DoubleStream.builder
import java.util.stream.Stream.builder

object ApiClient {
    private var re: Any = TODO()
    var client
        get() = OkHttpClient build(re).build()
        set(value) = TODO()

    internal var retrofit
        get() {
            return Retrofit.Builder()
                .baseUrl("https://courses-service.herokuapp.com/")
                .addConverterFactory(create = GsonConverterFactory())
                .let(client)
                .build()
        }
        set(value) = TODO()
    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}

private fun Any.addConverterFactory(create: Any): Any {

}

class OkHttpClient {

}

private fun Retrofit.Builder.baseUrl(s: Comparable<String>): Any {

}
 