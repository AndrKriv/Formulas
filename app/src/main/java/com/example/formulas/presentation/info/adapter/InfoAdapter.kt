package com.example.formulas.presentation.info.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.formulas.databinding.InfoItemBinding
import com.example.formulas.presentation.info.model.InfoUIModel
import com.taeim.mathdisplay.AndroidMathView

class InfoViewHolder(
    private val binding: InfoItemBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(item: InfoUIModel) {
        with(binding) {
            textId.contentDescription = item.contentDescription
            infoItemNameOfFormula.text = item.nameOfFormula
            infoItemFormula.latex = item.formula
            if(item.note.isEmpty()){
                infoItemNoteOfFormula.visibility = View.GONE
            }
            else{
                infoItemNoteOfFormula.text = item.note
            }
        }
    }
}

class InfoAdapter : RecyclerView.Adapter<InfoViewHolder>() {

    private val items = mutableListOf<InfoUIModel>()

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
    fun setItems(items: List<InfoUIModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}