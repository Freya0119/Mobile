package com.example.repay.model

data class MoneyItem(
    val money: Int,
    val date: String,
    val address: String,
    val memo: String,
    val isBoolean: Boolean
)