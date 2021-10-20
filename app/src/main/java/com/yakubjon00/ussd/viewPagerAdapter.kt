package com.yakubjon00.ussd


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class viewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    val fragments: MutableList<Fragment> = ArrayList()
    val titles: MutableList<String> = ArrayList()
    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return KunlikFragment()
            1 -> return HaftalikFragment()
            2 -> return InternetPaketlarFragment(mContext)
            3 -> return YillikFragment()
        }
        return HaftalikFragment()
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}