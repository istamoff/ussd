package com.yakubjon00.ussd

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Handler().postDelayed({
            val manager = fragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.container_layout, LanguageFragment(requireContext()))?.commit()
        }, 3000)

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }


}