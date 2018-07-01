package com.sudansh.bowling.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.sudansh.bowling.MainActivityViewModel
import com.sudansh.bowling.R
import com.sudansh.bowling.databinding.ActivityMainBinding
import com.sudansh.bowling.util.ScoreUtil


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentRollIndex: Int = 0
    private val adapter by lazy { FrameAdapter() }
    private val rollAdapter by lazy { RollAdapter() }
    private val vm: MainActivityViewModel by lazy {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnRoll.setOnClickListener { onRoll() }
        binding.resetGame.setOnClickListener { reset() }
        binding.recyclerFrame.adapter = adapter
        binding.recyclerFrame.setHasFixedSize(true)
        binding.recyclerRoll.adapter = rollAdapter
        binding.recyclerRoll.setHasFixedSize(true)
    }


    private fun onRoll() {
        val roll: Int? = rollAdapter.selectedRoll
        roll?.let {

            //finished game
            if (currentRollIndex >= vm.rolls.size) {
                reset()
            }

            vm.rolls[currentRollIndex] = it
            val newScore = ScoreUtil(vm.rolls)
            if (!newScore.isValid) {
                Snackbar.make(binding.root, getString(R.string.snack_invalid_roll), Snackbar.LENGTH_LONG).show()
                return
            }

            adapter.setFrameList(newScore.frames)
            vm.scoreCard = newScore
            currentRollIndex++
        } ?: run {
            Snackbar.make(binding.root, getString(R.string.snack_select_pin), Snackbar.LENGTH_LONG).show()
        }
    }

    private fun reset() {
        vm.rolls = IntArray(21)
        currentRollIndex = 0
        adapter.setFrameList(ScoreUtil(vm.rolls).frames)
    }

}
