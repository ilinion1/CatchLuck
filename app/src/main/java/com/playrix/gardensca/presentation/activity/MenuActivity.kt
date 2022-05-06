package com.playrix.gardensca.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.view.menu.MenuAdapter
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.playrix.gardensca.R
import com.playrix.gardensca.databinding.ActivityMenuBinding
import com.playrix.gardensca.presentation.adapter.MenuGameAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPagerId.adapter = MenuGameAdapter(this)
        binding.tabLayoutId.tabIconTint = null
        TabLayoutMediator(binding.tabLayoutId, binding.viewPagerId) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.setIcon(R.drawable.ic_game)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.main))
                }
                1 -> {

                    tab.setIcon(R.drawable.ic_result)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.main))
                    tab.icon?.alpha = 70
                }
                2 -> {
                    tab.setIcon(R.drawable.ic_setting)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.main))
                    tab.icon?.alpha = 70
                }
                else -> {
                    tab.setIcon(R.drawable.ic_info)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.main))
                    tab.icon?.alpha = 70
                }

            }
        }.attach()

        binding.tabLayoutId.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 250
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 70
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
    }
}