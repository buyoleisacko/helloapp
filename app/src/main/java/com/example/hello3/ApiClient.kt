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
import com.example.hello3.OkHttpClient as ExampleHello3OkHttpClient

object ApiClient {
    private var re: Any = TODO()
    override fun hashCode(): Int {
        return super.hashCode()
    }

    private var client = ExampleHello3OkHttpClientbuild(re as Unit).build()
        set(value) = TODO()

    private fun ExampleHello3OkHttpClientbuild(re: Unit) {
        TODO("Not yet implemented")
    }

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}

private fun Any.build() {
    TODO("Not yet implemented")
}

private fun Any.addConverterFactory(create: Any): Any {

}

class OkHttpClient {

}

private fun Retrofit.Builder.baseUrl(s: Comparable<String>): Any {

}

annotation class internal var retrofit
    get() {
        var client = null
        return client?.let {
            Retrofit.run {
                val build: Any = Builder()
                    .baseUrl("https://courses-service.herokuapp.com/")
                    .addConverterFactory(create = GsonConverterFactory())
                    .let(it)
                    .build()
            }
        }
    }
    set(value) = TODO()