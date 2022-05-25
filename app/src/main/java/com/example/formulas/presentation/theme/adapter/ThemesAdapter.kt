package com.example.formulas.presentation.theme.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.formulas.databinding.ThemeItemBinding
import com.example.formulas.extension.OnStringItemClick

class ThemeViewHolder(
    private val binding: ThemeItemBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(item: String) {
        with(binding) {
            themeItemClassNumber.text = item
        }
    }
}

class ThemesAdapter(private val onItemClick: OnStringItemClick) :
    RecyclerView.Adapter<ThemeViewHolder>() {

    private val items = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeViewHolder =
        ThemeViewHolder(
            ThemeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ThemeViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onItemClick.onElementClickListener(items[position])
        }
        holder.bindView(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<String>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}