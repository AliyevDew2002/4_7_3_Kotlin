package com.example.a4_7_3_kotlin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.a4_7_3_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        initView()
    }
    fun initView() {
        binding.edText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Matn o'zgarishidan oldin nima qilish kerakligini ko'rsatadi
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // Matn o'zgarishi bo'lganda nima qilish kerakligini ko'rsatadi
            }

            override fun afterTextChanged(s: Editable) {
                // Matn o'zgarishidan so'ng nima qilish kerakligini ko'rsatadi
                // binding.tvText.setText(s.toString());
            }
        })
        binding.edText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                // Enter tugmasi bosilganda nima qilish kerakligini ko'rsatadi
                show_msg()
                return@OnKeyListener true
            }
            binding.tvText.setText("xayr")
            false
        })
        binding.button.setOnClickListener(View.OnClickListener { show_msg() })
    }
    private fun show_msg() {
        binding.tvText.setText(binding.edText.getText().toString())
    }

}