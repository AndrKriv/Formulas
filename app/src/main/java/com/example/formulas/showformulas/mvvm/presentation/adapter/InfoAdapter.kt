package com.example.formulas.showformulas.mvvm.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.formulas.databinding.InfoItemBinding
import com.example.formulas.showformulas.mvvm.core.InfoModel

class ForecastViewHolder(
    private val binding: InfoItemBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(item: InfoModel) {
        with(binding) {
            infoItemNameOfFormula.text = item.nameOfFormula
            infoItemFormula.latex = item.formula
        }
    }
}

class InfoAdapter : RecyclerView.Adapter<ForecastViewHolder>() {

    private val items = mutableListOf<InfoModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder =
        ForecastViewHolder(
            InfoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) =
        holder.bindView(items[position])

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<InfoModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}