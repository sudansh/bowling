package com.sudansh.bowling.ui

import android.databinding.ViewDataBinding
import android.support.v4.content.ContextCompat
import android.view.View
import com.sudansh.bowling.R
import com.sudansh.bowling.databinding.ViewFrameItemBinding
import com.sudansh.bowling.model.Frame
import com.sudansh.bowling.model.LastFrame

class FrameAdapter : BaseRVAdapter() {
    private val frameList = mutableListOf<Frame>()

    override fun onCreateViewLayout(viewType: Int) = R.layout.view_frame_item

    override fun onBindViewHolder(viewDataBinding: ViewDataBinding, position: Int) {
        val binding = viewDataBinding as ViewFrameItemBinding
        val frame = frameList[position]
        binding.frame.text = (position + 1).toString()
        binding.roll1.text = frame.roll1
        binding.roll2.text = frame.roll2
        binding.frameScore.text = frame.totalText
        if (frame is LastFrame) {
            binding.roll3.text = frame.thirdRollText
            binding.roll3.visibility = View.VISIBLE
        } else {
            binding.roll3.visibility = View.GONE
        }
        if (frame.isValid)
            binding.frameScore.setTextColor(ContextCompat.getColor(binding.frameScore.rootView.context, R.color.black))
        else
            binding.frameScore.setTextColor(ContextCompat.getColor(binding.frameScore.rootView.context, R.color.error))
    }


    fun setFrameList(newItems: Array<Frame>) {
        frameList.clear()
        frameList.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = frameList.size

}

