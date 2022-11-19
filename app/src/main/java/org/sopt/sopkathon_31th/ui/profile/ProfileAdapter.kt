package org.sopt.sopkathon_31th.ui.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sopkathon_31th.data.remote.entity.profile.ResponseProfileDto
import org.sopt.sopkathon_31th.databinding.ProfileItemBinding

class ProfileAdapter(context: Context) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var profileList: List<ResponseProfileDto.Data.User> = emptyList()
    private val keys = mutableListOf<String>()
    private val values = mutableListOf<String>()
    fun initList(key: List<String>, value: List<String>) {
        keys.addAll(key)
        values.addAll(value)
        notifyDataSetChanged()
    }

    inner class ProfileViewHolder(
        private val binding: ProfileItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(key: String, value: String) {
            binding.profileTableTitle.text = key
            binding.profileTableValue.text = value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding = ProfileItemBinding.inflate(inflater, parent, false)
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.onBind(keys[position], values[position])
    }

    override fun getItemCount(): Int {
        return keys.size
    }
}
