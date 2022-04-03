package com.example.simplerandomadvice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.simplerandomadvice.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val retrofit = RetrofitClient.getClient()
            .create(AdviceService::class.java)


        binding.btnChange.setOnClickListener {
            retrofit.getAdvice()
                .enqueue(object : Callback<Advice> {
                    override fun onResponse(call: Call<Advice>, response: Response<Advice>) {
                        val advice = response.body()
                        binding.textAdvice.text = advice?.slip?.advice
                    }

                    override fun onFailure(call: Call<Advice>, t: Throwable) {
                        t.printStackTrace()
                    }
                })
        }

    }
}