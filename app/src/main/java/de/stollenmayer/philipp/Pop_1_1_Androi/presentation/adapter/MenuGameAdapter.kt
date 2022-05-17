package de.stollenmayer.philipp.Pop_1_1_Androi.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import de.stollenmayer.philipp.Pop_1_1_Androi.presentation.fragment.GameFragment
import de.stollenmayer.philipp.Pop_1_1_Androi.presentation.fragment.InfoFragment
import de.stollenmayer.philipp.Pop_1_1_Androi.presentation.fragment.ResultFragment
import de.stollenmayer.philipp.Pop_1_1_Androi.presentation.fragment.SettingsFragment

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