package org.sopt.sopkathon_31th.ui.home.part.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.sopkathon_31th.R
import org.sopt.sopkathon_31th.data.remote.entity.home.ResponseHomeDto
import org.sopt.sopkathon_31th.databinding.ItemPartMemberBinding

class PartMembersAdapter :
    ListAdapter<ResponseHomeDto.Data, PartMembersAdapter.PartMembersViewHolder>(
        PartMembersComparator()
    ) {
    class PartMembersViewHolder(private val binding: ItemPartMemberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseHomeDto.Data) {
            binding.tvName.text = data.nickname
            Glide.with(binding.ivProfile).load(data.photoUrl).placeholder(R.drawable.dongjae)
                .error(R.drawable.dongjae)
                .into(binding.ivProfile)
        }
    }

    class PartMembersComparator() : DiffUtil.ItemCallback<ResponseHomeDto.Data>() {
        override fun areItemsTheSame(
            oldItem: ResponseHomeDto.Data,
            newItem: ResponseHomeDto.Data
        ): Boolean {
            return oldItem.userId == newItem.userId
        }

        override fun areContentsTheSame(
            oldItem: ResponseHomeDto.Data,
            newItem: ResponseHomeDto.Data
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartMembersViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val binding = ItemPartMemberBinding.inflate(layoutInflator, parent, false)
        return PartMembersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PartMembersViewHolder, position: Int) {
        return holder.onBind(getItem(position))
    }
}
