package com.example.formulas.rec_view_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.formulas.R


class Check_Adapter(private val numb_class: Int,private val name_of_formula: List<String>, private val formulas: List<String>) :
    RecyclerView.Adapter<Check_Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.formulasName?.text = name_of_formula[position]
        holder.formula?.text = formulas[position]
    }

    override fun getItemCount() = formulas.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var formulasName: TextView? = null
        var formula: TextView? = null

        init {
            formulasName = itemView.findViewById(R.id.tv_name)
            formula = itemView.findViewById(R.id.tv_formula)
        }
    }
}