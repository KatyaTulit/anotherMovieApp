package com.katyatulit.movieapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.katyatulit.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtons() // show toast messages when buttons are pressed
    }

    private fun initButtons() {
        val buttons = listOf(binding.buttonMenu,
                            binding.buttonFav,
                            binding.buttonLater,
                            binding.buttonSelections,
                            binding.buttonSettings)

        buttons.forEach { button ->
            button.setOnClickListener {
                Toast.makeText(this, button.text.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
