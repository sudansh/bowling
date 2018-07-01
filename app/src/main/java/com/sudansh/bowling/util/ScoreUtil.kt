package com.sudansh.bowling.util

import com.sudansh.bowling.Constants.PIN_SIZE
import com.sudansh.bowling.model.*
import java.util.*

/**
 * Calculate the score of the game from list of rolls
 **
 * @param rolls int array which holds maximum of 21 isValid rolls with each value in range 0-10
 */
class ScoreUtil(private val rolls: IntArray) {
    val frames: Array<Frame> = calculateFrame(rolls)
    val totalScore = frames.last().total
    val isValid = frames.all { it.isValid }

    private fun calculateFrame(rolls: IntArray): Array<Frame> {
        val frames = Stack<Frame>()
        var currentFrame: Frame
        var i = 0
        while (i < rolls.size && frames.size < PIN_SIZE) {
            when {
                isLastFrame(frames) -> {
                    currentFrame = LastFrame(rolls[i], rolls[i + 1], rolls[i + 2])
                    i += 3
                }
                isStrike(i) -> {
                    currentFrame = StrikeFrame(rolls[i + 1], rolls[i + 2])
                    i++
                }
                isSpare(i) -> {
                    currentFrame = SpareFrame(rolls[i], rolls[i + 2])
                    i += 2
                }
                else -> {
                    currentFrame = NormalFrame(rolls[i], rolls[i + 1])
                    i += 2
                }
            }
            if (!frames.empty())
                currentFrame.previousFrame = frames.peek()
            frames.push(currentFrame)
        }
        return frames.toTypedArray()
    }

    private fun isLastFrame(frames: Stack<Frame>) = frames.size == PIN_SIZE - 1

    private fun isSpare(i: Int) = rolls[i] + rolls[i + 1] == PIN_SIZE

    private fun isStrike(i: Int) = rolls[i] == PIN_SIZE
}