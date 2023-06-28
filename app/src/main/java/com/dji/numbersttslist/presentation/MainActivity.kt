package com.dji.numbersttslist.presentation

import com.dji.numbersttslist.presentation.numbers_list_screen.NumbersFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dji.numbersttslist.R
import com.dji.numbersttslist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, NumbersFragment())
                .commit()
        }
    }
}