package com.sudansh.bowling.helper

object TestUtil {


    fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {

        return RecyclerViewMatcher(recyclerViewId)
    }

}