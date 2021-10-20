package com.yakubjon00.ussd


import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_internet_paketlar.*

class SMSPaketlar : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_s_m_s_paketlar)

        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager = findViewById<ViewPager>(R.id.viewPager)

        val adapter = viewPagerAdapter2(supportFragmentManager)
        adapter.addFragment(KunlikFragment(), "Kunlik")
        adapter.addFragment(HaftalikFragment(), "Haftalik")
        adapter.addFragment(SMSPaketlarFragment(), "Oylik")
        adapter.addFragment(YillikFragment(), "Yillik")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        setMarginOnTabItems()

        btn_trafik_tekshirish.setOnClickListener {
            Toast.makeText(applicationContext, "SMS paket tekshirilmoqda", Toast.LENGTH_SHORT)
                .show()
        }

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

    }

    fun setMarginOnTabItems() {
        for (i in 0 until tabLayout.tabCount) {
            val tabItem = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val params = tabItem.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(20, 0, 20, 0)
        }
    }

}