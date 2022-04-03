package com.example.simplerandomadvice

data class Advice(
    val slip: Slip
) {
    data class Slip(
        val advice: String,
        val id: Int
    )
}