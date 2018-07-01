package com.sudansh.bowling.model

import com.sudansh.bowling.Constants.PIN_SIZE

class NormalFrame(firstRoll: Int, secondRoll: Int) : Frame() {
    override val isValid: Boolean = firstRoll + secondRoll < PIN_SIZE
    override val roll1: String = firstRoll.toString()
    override val roll2: String = secondRoll.toString()
    override val frameScore: Int = firstRoll + secondRoll
}