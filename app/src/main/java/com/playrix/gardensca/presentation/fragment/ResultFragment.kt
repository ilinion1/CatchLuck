package com.playrix.gardensca.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.playrix.gardensca.presentation.adapter.GameAdapter
import com.playrix.gardensca.databinding.FragmentResultBinding
import com.playrix.gardensca.presentation.GameViewModel


class ResultFragment : Fragment() {
    lateinit var binding: FragmentResultBinding
    lateinit var adapter: GameAdapter
    private val viewModel by lazy { ViewModelProvider(requireActivity())[GameViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = GameAdapter()
        binding.rcView.adapter = adapter
        viewModel.listResult.observe(requireActivity()){
            adapter.resultList.clear()
            adapter.resultList.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }
}