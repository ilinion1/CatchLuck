package de.stollenmayer.philipp.Pop_1_1_Androi.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    val listResult = MutableLiveData<ArrayList<String>>()
    val normalLevelGame = MutableLiveData<Boolean>(true)
}