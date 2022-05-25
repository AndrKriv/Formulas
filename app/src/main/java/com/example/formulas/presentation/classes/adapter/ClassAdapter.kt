package com.example.formulas.presentation.classes.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.formulas.databinding.ClassItemBinding
import com.example.formulas.extension.OnIntItemClick
import com.example.formulas.presentation.start.model.ClassUIModel
import com.example.formulas.utils.loadImg

class ClassViewHolder(
    private val binding: ClassItemBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(item: ClassUIModel) {
        with(binding) {
            classItemImage.setImageResource(loadImg(item.classNumber))
            classItemClassNumber.text = item.classNumber
        }
    }
}

class ClassAdapter(private val onItemClick: OnIntItemClick) :
    RecyclerView.Adapter<ClassViewHolder>() {

    private val items = mutableListOf<ClassUIModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder =
        ClassViewHolder(
            ClassItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onItemClick.onElementClickListener(position)
        }
        holder.bindView(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<ClassUIModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}