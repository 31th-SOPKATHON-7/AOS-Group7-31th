package org.sopt.sopkathon_31th.ui.home.part.plan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.sopt.sopkathon_31th.R
import org.sopt.sopkathon_31th.databinding.FragmentPlanBinding
import org.sopt.sopkathon_31th.ui.home.part.adapter.PartMemberDecorator
import org.sopt.sopkathon_31th.ui.home.part.adapter.PartMembersAdapter
import org.sopt.sopkathon_31th.ui.profile.ProfileActivity

class PlanFragment : Fragment() {
    private val planViewModel: PlanViewModel by viewModels()
    private lateinit var planAdapter: PartMembersAdapter
    private var _binding: FragmentPlanBinding? = null
    private val binding get() = requireNotNull(_binding) { "${this::class.java.simpleName}에서 바인딩 초기화 에러가 발생했습니다." }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlanBinding.inflate(layoutInflater)
        initAdapter()
        initList()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        planViewModel.getPlanMembers()
    }

    private fun initAdapter() {
        planAdapter = PartMembersAdapter { goProfile(it) }
        binding.rvPlan.adapter = planAdapter
        binding.rvPlan.addItemDecoration(PartMemberDecorator())
    }

    private fun goProfile(userId: Int) {
        Log.d("asdf", "goProfile1")
        val intent = Intent(requireContext(), ProfileActivity::class.java)
        intent.putExtra(USER_ID, userId)
        startActivity(intent)
        Log.d("asdf", "goProfile2")
    }

    private fun initList() {
        /*planViewModel.planProfiles.observe(viewLifecycleOwner) {
            planAdapter.submitList(it)
        }*/

        planAdapter.submitList(
            listOf(
                PlanInfo("주우재", R.drawable.dongjae),
                PlanInfo("빅스 앤", R.drawable.yongmin),
                PlanInfo("우주소녀 수빈", R.drawable.chaeyoung),
                PlanInfo("장원영", R.drawable.asdf),
                PlanInfo("심혜빈", R.drawable.hyebin),
                PlanInfo("서유리", R.drawable.jiyoung),
                PlanInfo("전채연", R.drawable.chaeyeon),
                PlanInfo("김지은", R.drawable.jieun),
                PlanInfo("이선화", R.drawable.seonhwa)
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val USER_ID = "userId"
    }
}
