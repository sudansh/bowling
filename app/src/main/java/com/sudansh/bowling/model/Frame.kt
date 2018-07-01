package com.sudansh.bowling.model


abstract class Frame {
    abstract val frameScore: Int
    abstract val roll1: String
    abstract val roll2: String
    abstract val isValid: Boolean

    var previousFrame: Frame? = null
    var total: Int = 0
        get() = frameScore + (previousFrame?.total ?: 0)

    val totalText: String by lazy { total.toString() }
}