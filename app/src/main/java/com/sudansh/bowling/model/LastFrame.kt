package com.sudansh.bowling.model

class LastFrame(roll1: Int,
                roll2: Int,
                roll3: Int) : Frame() {

    //Check if roll3 is valid
    override val isValid: Boolean =

            if (roll1 == 10) {
                //roll1 is strike
                if (roll2 == 10) {
                    //roll2 is strike
                    true
                } else {
                    //roll2 isn't a strike
                    //roll3 is at best a spare
                    roll2 + roll3 <= 10
                }
            } else {
                //roll1 is NOT a strike
                if (roll1 + roll2 == 10) {
                    //roll2 is a spare
                    true
                } else {
                    //roll2 is NOT a spare
                    //roll3 must be 0
                    roll3 == 0
                }
            }

    override val roll1: String = roll1.toString()
    override val roll2: String = roll2.toString()
    override val frameScore: Int = roll1 + roll2 + roll3
    val thirdRollText: String = roll3.toString()
}