package com.sudansh.bowling

import android.arch.lifecycle.ViewModel
import com.sudansh.bowling.util.ScoreUtil

class MainActivityViewModel : ViewModel() {
    var rolls = IntArray(21)
    var scoreCard = ScoreUtil(rolls)
}