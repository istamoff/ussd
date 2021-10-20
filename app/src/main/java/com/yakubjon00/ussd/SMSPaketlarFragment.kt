package com.yakubjon00.ussd


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SMSPaketlarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_s_m_s_paketlar, container, false)

        val adapterList = arrayListOf<RecyclerViewAdapter>()
        val groupList = createItems()

        val recycler_view = view.findViewById<RecyclerView>(R.id.recycler_view)

        for (item in groupList) {
            val adapter = RecyclerViewAdapter(item)
            adapterList.add(adapter)
        }

        val concatConfig = ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build()
        val adapter = ConcatAdapter(concatConfig, adapterList)
        recycler_view.layoutManager = LinearLayoutManager(
            mContext,
            LinearLayoutManager.VERTICAL, false
        )
        recycler_view.adapter = adapter

        return view
    }

    fun createItems(): List<GroupItem> {

        val groupList = arrayListOf<GroupItem>()
        val itemList = arrayListOf<GroupItem.Item>()
        itemList.add(GroupItem.Item("Ulanish"))
        groupList.add(
            GroupItem(
                GroupItem.Header(
                    "SMS 10",
                    "Agar abonentda ADSL texnologiyasidan foydalangan holda IPTV xizmati mavjud bo'lsa, tarif rejasida ko'rsatilgan tezlikni ta'minlash uchun texnik imkoniyat UZTELECOM savdo idorasiga yozma ariza bilan belgilanadi."
                ), itemList
            )
        )
        groupList.add(
            GroupItem(
                GroupItem.Header(
                    "SMS 20",
                    "Agar abonentda ADSL texnologiyasidan foydalangan holda IPTV xizmati mavjud bo'lsa, tarif rejasida ko'rsatilgan tezlikni ta'minlash uchun texnik imkoniyat UZTELECOM savdo idorasiga yozma ariza bilan belgilanadi."
                ), itemList
            )
        )
        groupList.add(
            GroupItem(
                GroupItem.Header(
                    "SMS 25",
                    "Agar abonentda ADSL texnologiyasidan foydalangan holda IPTV xizmati mavjud bo'lsa, tarif rejasida ko'rsatilgan tezlikni ta'minlash uchun texnik imkoniyat UZTELECOM savdo idorasiga yozma ariza bilan belgilanadi."
                ), itemList
            )
        )
        groupList.add(
            GroupItem(
                GroupItem.Header(
                    "SMS 50",
                    "Agar abonentda ADSL texnologiyasidan foydalangan holda IPTV xizmati mavjud bo'lsa, tarif rejasida ko'rsatilgan tezlikni ta'minlash uchun texnik imkoniyat UZTELECOM savdo idorasiga yozma ariza bilan belgilanadi."
                ), itemList
            )
        )
        groupList.add(
            GroupItem(
                GroupItem.Header(
                    "SMS 100",
                    "Agar abonentda ADSL texnologiyasidan foydalangan holda IPTV xizmati mavjud bo'lsa, tarif rejasida ko'rsatilgan tezlikni ta'minlash uchun texnik imkoniyat UZTELECOM savdo idorasiga yozma ariza bilan belgilanadi."
                ), itemList
            )
        )
        groupList.add(
            GroupItem(
                GroupItem.Header(
                    "SMS 500",
                    "Agar abonentda ADSL texnologiyasidan foydalangan holda IPTV xizmati mavjud bo'lsa, tarif rejasida ko'rsatilgan tezlikni ta'minlash uchun texnik imkoniyat UZTELECOM savdo idorasiga yozma ariza bilan belgilanadi."
                ), itemList
            )
        )
        groupList.add(
            GroupItem(
                GroupItem.Header(
                    "SMS 1000",
                    "Agar abonentda ADSL texnologiyasidan foydalangan holda IPTV xizmati mavjud bo'lsa, tarif rejasida ko'rsatilgan tezlikni ta'minlash uchun texnik imkoniyat UZTELECOM savdo idorasiga yozma ariza bilan belgilanadi."
                ), itemList
            )
        )
        groupList.add(
            GroupItem(
                GroupItem.Header(
                    "SMS 2500",
                    "Agar abonentda ADSL texnologiyasidan foydalangan holda IPTV xizmati mavjud bo'lsa, tarif rejasida ko'rsatilgan tezlikni ta'minlash uchun texnik imkoniyat UZTELECOM savdo idorasiga yozma ariza bilan belgilanadi."
                ), itemList
            )
        )
        return groupList
    }

}