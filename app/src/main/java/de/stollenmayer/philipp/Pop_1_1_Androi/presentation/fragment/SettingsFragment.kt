package de.stollenmayer.philipp.Pop_1_1_Androi.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.playrix.gardensca.databinding.FragmentSettingsBinding
import de.stollenmayer.philipp.Pop_1_1_Androi.presentation.GameViewModel


class SettingsFragment : Fragment() {
    lateinit var binding: FragmentSettingsBinding
    private val viewModel by lazy { ViewModelProvider(requireActivity())[GameViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewModel.normalLevelGame.value == true){
            binding.rdEasy.isChecked = true
        } else {
            binding.rdHard.isChecked = true
        }
        binding.rdEasy.setOnClickListener {
            viewModel.normalLevelGame.value = true
            binding.rdHard.isChecked = false
        }
        binding.rdHard.setOnClickListener {
            viewModel.normalLevelGame.value = false
            binding.rdEasy.isChecked = false
        }
    }
}