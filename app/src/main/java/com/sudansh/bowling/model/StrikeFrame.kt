package com.sudansh.bowling.model

import com.sudansh.bowling.Constants.PIN_SIZE

class StrikeFrame(nextBonusRoll: Int, nextNextBonusRoll: Int) : Frame() {
    override val isValid: Boolean = true
    override val roll1: String = "X"
    override val roll2: String = ""
    override val frameScore: Int = PIN_SIZE + nextBonusRoll + nextNextBonusRoll
}