package com.android.appcontadordecliques_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.appcontadordecliques_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //instanciando as classes
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.nums.observe(this) {
            binding.numsAqui.text = it.toString()
        }

        binding.CliqueImage.setOnClickListener() {

            mainViewModel.nums.value = binding.numsAqui.text.toString().toInt() +1

        }

    }
}