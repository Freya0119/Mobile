package com.example.repay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.repay.databinding.ActivityLogRoomBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_log_room)
        binding = ActivityLogRoomBinding.inflate(LayoutInflater.from(this))
    }

    private fun pay(money: Int) {
        val total = money
        changeMoneyText(total.toString())
    }

    private fun changeMoneyText(moneyString: String) {
        binding.nowMoneyTextView.text = moneyString
    }
}