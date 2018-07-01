package com.sudansh.bowling.ui

import android.databinding.ViewDataBinding
import com.sudansh.bowling.R
import com.sudansh.bowling.databinding.ViewRollItemBinding


class RollAdapter : BaseRVAdapter() {
    var selectedRoll: Int? = null
    private val selectCheck: IntArray = IntArray(10) { 0 }

    override fun onCreateViewLayout(viewType: Int) = R.layout.view_roll_item

    override fun onBindViewHolder(viewDataBinding: ViewDataBinding, position: Int) {
        val holder = viewDataBinding as ViewRollItemBinding
        holder.roll.text = String.format("%d", position + 1)
        holder.roll.isChecked = selectCheck[position] == 1
        holder.roll.setOnClickListener {
            for (k in 0 until selectCheck.size) {
                if (k == position) {
                    selectCheck[k] = 1
                    selectedRoll = k + 1
                } else {
                    selectCheck[k] = 0
                }
            }
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = 10
}