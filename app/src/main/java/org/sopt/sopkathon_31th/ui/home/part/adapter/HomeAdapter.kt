package org.sopt.sopkathon_31th.ui.home.part.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sopkathon_31th.databinding.ItemHomeBinding

class HomeAdapter(private val clickPart: (Int) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private val parts = listOf<String>("전체", "기획", "디자인", "안드로이드", "iOS", "서버")

    class HomeViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(part: String) {
            binding.tvPart.text = part
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeBinding.inflate(layoutInflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.itemView.setOnClickListener { clickPart(position) }
        return holder.onBind(parts[position])
    }

    override fun getItemCount() = parts.size
}
