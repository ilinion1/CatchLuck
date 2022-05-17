package de.stollenmayer.philipp.Pop_1_1_Androi.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.playrix.gardensca.databinding.FragmentGameBinding
import de.stollenmayer.philipp.Pop_1_1_Androi.presentation.GameViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class GameFragment : Fragment() {
    lateinit var binding: FragmentGameBinding
    private val viewModel by lazy { ViewModelProvider(requireActivity())[GameViewModel::class.java] }
    val listGame = arrayListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var random = (1..6).random()
        binding.btHit.setOnClickListener {
            viewModel.normalLevelGame.observe(requireActivity()){
                if (it){
                    random = (1..6).random()
                } else {
                    random = (1..4).random()
                }
            }

            firstTrajectory(random)
            secondTrajectory(random)
            threeTrajectory(random)
            fourTrajectory(random)
            fiveTrajectory(random)
            sixTrajectory(random)
        }
    }

    private fun firstTrajectory(random: Int){
        if (random == 1){
            lifecycleScope.launch {
                binding.startGame.visibility = View.GONE
                delay(150)
                binding.startGame2.visibility = View.VISIBLE
                delay(150)
                binding.startGame2.visibility = View.GONE
                delay(150)
                binding.startGame3.visibility = View.VISIBLE
                delay(150)
                binding.startGame3.visibility = View.GONE
                delay(150)
                binding.startGame4.visibility = View.VISIBLE
                delay(150)
                binding.startGame4.visibility = View.GONE
                delay(150)
                binding.startGame5.visibility = View.VISIBLE
                delay(150)
                binding.startGame5.visibility = View.GONE
                delay(150)
                binding.startGame6.visibility = View.VISIBLE
                binding.tvGameResult.text = "Goal!"
                delay(1500)
                binding.startGame6.visibility = View.GONE
                binding.tvGameResult.text = "Take a hit!"
                binding.startGame.visibility = View.VISIBLE
                listGame.add("Goal!")
                viewModel.listResult.value = listGame
            }
        }
    }

    private fun secondTrajectory(random: Int){
        if (random == 6){
            lifecycleScope.launch {
                binding.startGame.visibility = View.GONE
                delay(150)
                binding.startGame02.visibility = View.VISIBLE
                delay(150)
                binding.startGame02.visibility = View.GONE
                delay(150)
                binding.startGame03.visibility = View.VISIBLE
                delay(150)
                binding.startGame03.visibility = View.GONE
                delay(150)
                binding.startGame04.visibility = View.VISIBLE
                delay(150)
                binding.startGame04.visibility = View.GONE
                delay(150)
                binding.startGame05.visibility = View.VISIBLE
                delay(150)
                binding.startGame05.visibility = View.GONE
                delay(150)
                binding.startGame06.visibility = View.VISIBLE
                binding.tvGameResult.text = "Goal!"
                delay(1500)
                binding.startGame06.visibility = View.GONE
                binding.tvGameResult.text = "Take a hit!"
                binding.startGame.visibility = View.VISIBLE
                listGame.add("Goal!")
                viewModel.listResult.value = listGame
            }
        }
    }

    private fun threeTrajectory(random: Int){
        if (random == 3){
            lifecycleScope.launch {
                binding.startGame.visibility = View.GONE
                delay(150)
                binding.startGame12.visibility = View.VISIBLE
                delay(150)
                binding.startGame12.visibility = View.GONE
                delay(150)
                binding.startGame13.visibility = View.VISIBLE
                delay(150)
                binding.startGame13.visibility = View.GONE
                delay(150)
                binding.startGame14.visibility = View.VISIBLE
                delay(150)
                binding.startGame14.visibility = View.GONE
                delay(150)
                binding.startGame15.visibility = View.VISIBLE
                delay(150)
                binding.startGame15.visibility = View.GONE
                delay(150)
                binding.startGame16.visibility = View.VISIBLE
                binding.tvGameResult.text = "Miss!"
                delay(1500)
                binding.startGame16.visibility = View.GONE
                binding.tvGameResult.text = "Take a hit!"
                binding.startGame.visibility = View.VISIBLE
                listGame.add("Miss!")
                viewModel.listResult.value = listGame
            }
        }
    }

    private fun fourTrajectory(random: Int){
        if (random == 5){
            lifecycleScope.launch {
                binding.startGame.visibility = View.GONE
                delay(150)
                binding.startGame32.visibility = View.VISIBLE
                delay(150)
                binding.startGame32.visibility = View.GONE
                delay(150)
                binding.startGame33.visibility = View.VISIBLE
                delay(150)
                binding.startGame33.visibility = View.GONE
                delay(150)
                binding.startGame34.visibility = View.VISIBLE
                delay(150)
                binding.startGame34.visibility = View.GONE
                delay(150)
                binding.startGame35.visibility = View.VISIBLE
                delay(150)
                binding.startGame35.visibility = View.GONE
                delay(150)
                binding.startGame36.visibility = View.VISIBLE
                binding.tvGameResult.text = "Goal!"
                delay(1500)
                binding.startGame36.visibility = View.GONE
                binding.tvGameResult.text = "Take a hit!"
                binding.startGame.visibility = View.VISIBLE
                listGame.add("Goal!")
                viewModel.listResult.value = listGame
            }
        }
    }

    private fun fiveTrajectory(random: Int){
        if (random == 4){
            lifecycleScope.launch {
                binding.startGame.visibility = View.GONE
                delay(150)
                binding.startGame22.visibility = View.VISIBLE
                delay(150)
                binding.startGame22.visibility = View.GONE
                delay(150)
                binding.startGame23.visibility = View.VISIBLE
                delay(150)
                binding.startGame23.visibility = View.GONE
                delay(150)
                binding.startGame24.visibility = View.VISIBLE
                delay(150)
                binding.startGame24.visibility = View.GONE
                delay(150)
                binding.startGame25.visibility = View.VISIBLE
                delay(150)
                binding.startGame25.visibility = View.GONE
                delay(150)
                binding.startGame26.visibility = View.VISIBLE
                binding.tvGameResult.text = "Miss!"
                delay(1500)
                binding.startGame26.visibility = View.GONE
                binding.tvGameResult.text = "Take a hit!"
                binding.startGame.visibility = View.VISIBLE
                listGame.add("Miss!")
                viewModel.listResult.value = listGame
            }
        }
    }

    private fun sixTrajectory(random: Int){
        if (random == 2){
            lifecycleScope.launch {
                binding.startGame.visibility = View.GONE
                delay(150)
                binding.startGame42.visibility = View.VISIBLE
                delay(150)
                binding.startGame42.visibility = View.GONE
                delay(150)
                binding.startGame43.visibility = View.VISIBLE
                delay(150)
                binding.startGame43.visibility = View.GONE
                delay(150)
                binding.startGame44.visibility = View.VISIBLE
                delay(150)
                binding.startGame44.visibility = View.GONE
                delay(150)
                binding.startGame45.visibility = View.VISIBLE
                delay(150)
                binding.startGame45.visibility = View.GONE
                delay(150)
                binding.startGame46.visibility = View.VISIBLE
                binding.tvGameResult.text = "Miss!"
                delay(1500)
                binding.startGame46.visibility = View.GONE
                binding.tvGameResult.text = "Take a hit!"
                binding.startGame.visibility = View.VISIBLE
                listGame.add("Miss!")
                viewModel.listResult.value = listGame
            }
        }
    }

}