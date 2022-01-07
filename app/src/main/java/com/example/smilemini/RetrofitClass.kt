package com.example.smilemini

import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClass  {
    companion object { var BaseURL: HttpUrl ="https://appserver2.smile.com.ng:9090/".toHttpUrl()
        var retrofit= Retrofit.Builder().baseUrl(BaseURL).addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .build()

  }
}