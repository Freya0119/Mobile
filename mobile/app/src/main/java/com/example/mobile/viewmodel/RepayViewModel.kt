package com.example.mobile.viewmodel

import com.example.mobile.model.MoneyItem
import com.google.firebase.storage.FirebaseStorage

class RepayViewModel() {
    private var _total: Int = 0
    val total get() = _total

    var allItems: List<MoneyItem>? = null

    fun updateItems() {
        allItems = getMoneyItems()
    }

    private fun getMoneyItems(): List<MoneyItem> {
        val data = FirebaseStorage.getInstance()
        return listOf(
            MoneyItem(1000, "230108", "where", "For test in viewModle"),
            MoneyItem(2000, "230109", " any where", "For test in viewModel")
        )
    }
}