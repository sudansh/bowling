package com.sudansh.bowling.ui

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseRVAdapter : RecyclerView.Adapter<BaseHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<*> {
        val view =
                LayoutInflater.from(parent.context).inflate(onCreateViewLayout(viewType), parent, false)
        return BaseHolder<ViewDataBinding>(view)
    }

    protected abstract fun onCreateViewLayout(viewType: Int): Int

    override fun onBindViewHolder(holder: BaseHolder<*>, position: Int) {
        onBindViewHolder(holder.binding(), holder.adapterPosition)
    }

    protected abstract fun onBindViewHolder(viewDataBinding: ViewDataBinding, position: Int)

}