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
    private val keyList =
        listOf<String>("본명", "나이", "mbti", "학교", "전공", "성별", "얼굴형", "3대몇", "발사이즈", "키")

    inner class ProfileViewHolder(
        private val binding: ProfileItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(profile: ResponseProfileDto.Data.User, position: Int) {
            binding.profileTableTitle.text = keyList.get(position)
            binding.profileTableValue.text = profile.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding = ProfileItemBinding.inflate(inflater, parent, false)
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.onBind(profileList[position], position)
    }

    fun setRepoList(repoList: List<ResponseProfileDto.Data.User>) {
        this.profileList = repoList.toList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return profileList.size
    }
}
