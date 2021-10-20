package com.yakubjon00.ussd


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class HomePageFragment(context: Context) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home_page, container, false)

        val btn_internet = view.findViewById<LinearLayout>(R.id.btn_internet)
        val btn_sms = view.findViewById<LinearLayout>(R.id.btn_sms)
        val btn_minut = view.findViewById<LinearLayout>(R.id.btn_minut)
        val btn_tarif = view.findViewById<LinearLayout>(R.id.btn_tarif)
        val btn_ussd = view.findViewById<LinearLayout>(R.id.btn_ussd)
        val btn_xizmat = view.findViewById<LinearLayout>(R.id.btn_xizmat)
        val btn_banner = view.findViewById<ImageView>(R.id.btn_banner)

        val manager = fragmentManager
        val transaction = manager?.beginTransaction()

        btn_internet.setOnClickListener {
            //  transaction?.replace(R.id.fragment_layout,InternetPaketlarFragment(requireContext()))?.commit()
            startActivity(Intent(requireContext(), InternetPaketlar::class.java))
        }

        btn_sms.setOnClickListener {
            startActivity(Intent(requireContext(), SMSPaketlar::class.java))
        }

        btn_banner.setOnClickListener {
            transaction?.replace(R.id.fragment_layout, BannerFragment())?.commit()
        }

        return view
    }


}