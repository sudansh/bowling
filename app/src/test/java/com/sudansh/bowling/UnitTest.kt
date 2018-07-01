package com.sudansh.bowling

import com.sudansh.bowling.util.ScoreUtil
import org.junit.Assert.assertEquals
import org.junit.Test

class UnitTest {

    @Test
    fun test_valid_last_frame() {

        val numbers: IntArray = intArrayOf(0, 1, 2, 4, 3, 2, 3, 1, 8, 1, 0, 1, 2, 3, 4, 5, 6, 1, 9, 1, 3)
        val scorecard = ScoreUtil(numbers)
        assertEquals(60, scorecard.totalScore)
    }

    @Test
    fun test_allStrike_shouldReturn_300() {
        val numbers: IntArray = intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
        val scorecard = ScoreUtil(numbers)
        assertEquals(300, scorecard.totalScore)
    }


    @Test
    fun test_zero_shouldReturn_0() {

        val numbers: IntArray = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        val scorecard = ScoreUtil(numbers)
        assertEquals(0, scorecard.totalScore)
    }


    @Test
    fun test_spared() {

        val numbers: IntArray = intArrayOf(2, 8, 8, 8, 2, 1, 1, 9, 5, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0)
        val scorecard = ScoreUtil(numbers)
        assertEquals(58, scorecard.totalScore)
    }

}
