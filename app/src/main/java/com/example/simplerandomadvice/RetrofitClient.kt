package com.example.simplerandomadvice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    // 싱글턴 패턴
    companion object{
        // Base URL은 API 서버의 주소를 저장하는 변수
        private const val BASE_URL = "https://api.adviceslip.com/"
        private var INSTANCE: Retrofit? = null

        fun getClient(): Retrofit {
            if (INSTANCE == null) { // INSTACE가 null이면 객체 생성
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE!!
        }
    }
}