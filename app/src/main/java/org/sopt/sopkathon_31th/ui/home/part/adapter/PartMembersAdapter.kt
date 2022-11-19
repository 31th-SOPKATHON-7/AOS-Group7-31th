package org.sopt.sopkathon_31th.ui.home.part.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.sopkathon_31th.R
import org.sopt.sopkathon_31th.data.remote.entity.home.ResponseHomeDto
import org.sopt.sopkathon_31th.databinding.ItemPartMemberBinding
import org.sopt.sopkathon_31th.ui.home.part.plan.PlanInfo

class PartMembersAdapter(private val clickProfile: (Int) -> Unit) :
    ListAdapter<PlanInfo, PartMembersAdapter.PartMembersViewHolder>(
        PartMembersComparator()
    ) {
    class PartMembersViewHolder(private val binding: ItemPartMemberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: PlanInfo) {
            binding.tvName.text = data.name
            Glide.with(binding.ivProfile).load(data.profileImg).placeholder(R.drawable.dongjae)
                .error(R.drawable.dongjae)
                .into(binding.ivProfile)
        }
    }

    class PartMembersComparator() : DiffUtil.ItemCallback<PlanInfo>() {
        override fun areItemsTheSame(
            oldItem: PlanInfo,
            newItem: PlanInfo
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: PlanInfo,
            newItem: PlanInfo
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
        holder.itemView.setOnClickListener {
            Log.d("asdf", "클릭됨")
            clickProfile(1)
        }
        return holder.onBind(getItem(position))
    }
}
