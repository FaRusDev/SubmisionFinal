package com.example.f.submisionfinal.util.netConfig

import com.example.f.submisionfinal.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//class untuk koneksi ke internet
// saat ini pake library retrofit

class ConnectToInetLib {

    fun getConnected():ResponseRetrofit{
       return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ResponseRetrofit::class.java)
    }

}