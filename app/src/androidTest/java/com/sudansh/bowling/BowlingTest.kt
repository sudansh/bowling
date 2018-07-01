package com.sudansh.bowling

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.util.Log
import com.sudansh.bowling.helper.TestUtil.withRecyclerView
import com.sudansh.bowling.ui.BaseHolder

class BowlingTest {
    fun pressRoll(): BowlingTest {
        onView(withId(R.id.btnRoll)).perform(click())
        return this
    }

    fun chooseRoll(position: Int): BowlingTest {
        onView(withRecyclerView(R.id.recyclerRoll)
                .atPosition(position - 1)).perform(click())
        return this
    }

    fun chooseRolls(vararg sequence: Int): BowlingTest {
        sequence.forEach { chooseRoll(it).pressRoll() }
        return this
    }

    private fun scrollTo(position: Int): BowlingTest {
        onView(withId(R.id.recyclerFrame))
                .perform(RecyclerViewActions.scrollToPosition<BaseHolder<*>>(position))
        return this
    }

    fun test_score_for_position(position: Int, score: Int): BowlingTest {
        scrollTo(position)
        Log.i("position", position.toString())
        onView(withRecyclerView(R.id.recyclerFrame)
                .atPositionOnView(position, R.id.frameScore))
                .check(matches(withText("$score")))
        return this
    }
}