package com.playrix.gardensca.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.playrix.gardensca.presentation.fragment.GameFragment
import com.playrix.gardensca.presentation.fragment.InfoFragment
import com.playrix.gardensca.presentation.fragment.ResultFragment
import com.playrix.gardensca.presentation.fragment.SettingsFragment

class MenuGameAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> GameFragment()
                1 -> ResultFragment()
                2 -> SettingsFragment()
                else -> InfoFragment()
        }
    }
}