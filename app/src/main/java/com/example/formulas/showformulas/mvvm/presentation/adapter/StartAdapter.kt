package com.example.formulas.showformulas.mvvm.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.formulas.databinding.StartItemBinding
import com.example.formulas.showformulas.OnItemClick
import com.example.formulas.showformulas.mvvm.model.StartUIModel
import com.example.formulas.util.loadImg

class StartViewHolder(
    private val binding: StartItemBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(item: StartUIModel) {
        with(binding) {
            startItemImage.setImageResource(loadImg(item.classNumber))
            startItemClassNumber.text = item.classNumber
        }
    }
}

class StartAdapter(private val onItemClick: OnItemClick) : RecyclerView.Adapter<StartViewHolder>() {

    private val items = mutableListOf<StartUIModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder =
        StartViewHolder(
            StartItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onItemClick.onClassClickListener(position)
        }
        holder.bindView(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<StartUIModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}