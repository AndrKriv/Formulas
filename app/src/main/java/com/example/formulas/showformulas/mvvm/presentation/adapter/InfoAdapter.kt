package com.example.formulas.showformulas.mvvm.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.formulas.databinding.InfoItemBinding
import com.example.formulas.showformulas.mvvm.model.FormulasUIModel

class InfoViewHolder(
    private val binding: InfoItemBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(item: FormulasUIModel) {
        with(binding) {
            infoItemNameOfFormula.text = item.nameOfFormula
            infoItemFormula.latex = item.formula
            infoItemNoteOfFormula.text = item.note
        }
    }
}

class InfoAdapter : RecyclerView.Adapter<InfoViewHolder>() {

    private val items = mutableListOf<FormulasUIModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder =
        InfoViewHolder(
            InfoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) =
        holder.bindView(items[position])

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<FormulasUIModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}