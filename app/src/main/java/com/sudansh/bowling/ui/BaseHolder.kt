package com.sudansh.bowling.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View

open class BaseHolder<out T : ViewDataBinding>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: T = DataBindingUtil.bind(itemView)!!

    fun binding(): T = binding
}