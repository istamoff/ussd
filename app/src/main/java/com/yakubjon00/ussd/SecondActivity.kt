package com.yakubjon00.ussd


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_balans -> Toast.makeText(
                    applicationContext,
                    "Balans bosildi",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_operator -> Toast.makeText(
                    applicationContext,
                    "Operator bosildi",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_yangiliklar -> Toast.makeText(
                    applicationContext,
                    "Yangiliklar bosildi",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_sozlamalar -> Toast.makeText(
                    applicationContext,
                    "Sozlamalar bosildi",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_home -> Toast.makeText(
                    applicationContext,
                    "Asosiy bosildi",
                    Toast.LENGTH_SHORT
                ).show()
            }
            return@setOnNavigationItemSelectedListener true
        }

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_layout, HomePageFragment(this)).commit()
    }
}