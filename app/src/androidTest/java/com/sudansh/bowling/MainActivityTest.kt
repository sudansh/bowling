package com.sudansh.bowling

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.sudansh.bowling.ui.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    private val test: BowlingTest = BowlingTest()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mActivityRule.launchActivity(Intent())
    }

    @Test
    fun test_allStrike_shouldReturn_300() {
        test.chooseRolls(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
                .test_score_for_position(0, 30)
                .test_score_for_position(1, 60)
                .test_score_for_position(2, 90)
                .test_score_for_position(3, 120)
                .test_score_for_position(4, 150)
                .test_score_for_position(5, 180)
                .test_score_for_position(6, 210)
                .test_score_for_position(7, 240)
                .test_score_for_position(8, 270)
                .test_score_for_position(9, 300)
    }

    @Test
    fun test_roll_one() {
        test.chooseRoll(4)
                .pressRoll()
                .test_score_for_position(0, 4)
    }

    @Test
    fun test_roll_two() {
        test.chooseRolls(3, 6)
                .test_score_for_position(0, 9)
    }

    @Test
    fun test_strike() {
        test.chooseRolls(4, 4, 10, 3, 3)
                .test_score_for_position(0, 8)
                .test_score_for_position(1, 24)
                .test_score_for_position(2, 30)
    }

    @Test
    fun test_spare() {
        test.chooseRolls(4, 4, 7, 3, 2)
                .test_score_for_position(0, 8)
                .test_score_for_position(1, 20)
                .test_score_for_position(2, 22)
    }


    @Test
    fun test_givenInput_should_return_80() {
        test.chooseRolls(6, 3, 3, 7, 4, 3, 4, 2, 7, 3, 2, 3, 2, 1, 3, 6, 4, 3, 3, 5)
                .test_score_for_position(0, 9)
                .test_score_for_position(1, 23)
                .test_score_for_position(2, 30)
                .test_score_for_position(3, 36)
                .test_score_for_position(4, 48)
                .test_score_for_position(5, 53)
                .test_score_for_position(6, 56)
                .test_score_for_position(7, 65)
                .test_score_for_position(8, 72)
                .test_score_for_position(9, 80)
    }
}
