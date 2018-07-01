package com.sudansh.bowling

import com.sudansh.bowling.model.LastFrame
import com.sudansh.bowling.model.NormalFrame
import com.sudansh.bowling.model.SpareFrame
import com.sudansh.bowling.model.StrikeFrame
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Test

class FrameTests {


    @Test
    fun test_spare() {
        val spare = SpareFrame(4, 8)
        assertEquals(18, spare.frameScore)
    }

    @Test
    fun test_frame() {
        val frame = NormalFrame(2, 1)
        assertEquals(3, frame.frameScore)
    }

    @Test
    fun validEndFrame_endSpare() {
        val frame = LastFrame(10, 2, 8)
        assertTrue(frame.isValid)
    }

    @Test
    fun validEndFrame_SpareStrike() {
        val frame = LastFrame(2, 8, 10)
        assertTrue(frame.isValid)
    }

    @Test
    fun test_invalid_fame_should_return_false() {
        val frame = NormalFrame(4, 8)
        assertFalse(frame.isValid)
    }


    @Test
    fun test_strike() {
        val strike = StrikeFrame(2, 7)
        assertEquals(19, strike.frameScore)
    }

    @Test
    fun test_invalid_endfame_should_return_false() {
        val frame = LastFrame(9, 9, 3)
        assertFalse(frame.isValid)
    }

    @Test
    fun test_invalid_extrafame_should_return_false() {
        val frame = LastFrame(2, 1, 3)
        assertFalse(frame.isValid)
    }

    @Test
    fun invalidEndFrame_end() {
        val frame = LastFrame(10, 7, 4)
        assertFalse(frame.isValid)
    }

    @Test
    fun test_valid_lastfame_should_return_true() {
        val frame = LastFrame(10, 10, 10)
        assertTrue(frame.isValid)
    }

    @Test
    fun validEndFrame_endNothing() {
        val frame = LastFrame(10, 0, 0)
        assertTrue(frame.isValid)
    }


}