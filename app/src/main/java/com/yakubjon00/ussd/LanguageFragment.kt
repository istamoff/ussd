package com.yakubjon00.ussd


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class LanguageFragment(context: Context) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_language, container, false)

        val btn_uz = view.findViewById<Button>(R.id.btn_uz)

        val intent = Intent(context?.applicationContext, SecondActivity::class.java)

        btn_uz.setOnClickListener {

            startActivity(intent)

        }


        return view
    }


}