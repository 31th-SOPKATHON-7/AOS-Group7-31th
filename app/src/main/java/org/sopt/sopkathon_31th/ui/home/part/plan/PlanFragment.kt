package org.sopt.sopkathon_31th.ui.home.part.plan

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.sopt.sopkathon_31th.data.remote.entity.home.ResponseHomeDto
import org.sopt.sopkathon_31th.databinding.FragmentPlanBinding
import org.sopt.sopkathon_31th.ui.home.part.adapter.PartMemberDecorator
import org.sopt.sopkathon_31th.ui.home.part.adapter.PartMembersAdapter

class PlanFragment : Fragment() {
    private val planViewModel: PlanViewModel by viewModels()
    private val planAdapter: PartMembersAdapter by lazy { PartMembersAdapter() }
    private var _binding: FragmentPlanBinding? = null
    private val binding get() = requireNotNull(_binding) { "${this::class.java.simpleName}에서 바인딩 초기화 에러가 발생했습니다." }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlanBinding.inflate(layoutInflater)
        initAdapter()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // planViewModel.getPlanMembers()
        initList()
    }

    private fun initAdapter() {
        Log.d("asdf", "planFragment initAdapter1")
        binding.rvPlan.adapter = planAdapter
        binding.rvPlan.addItemDecoration(PartMemberDecorator())
        Log.d("asdf", "planFragment initAdapter2")
    }

    private fun initList() {
        planAdapter.submitList(
            listOf(
                ResponseHomeDto("", "권용민"),
                ResponseHomeDto("", "김동재"),
                ResponseHomeDto("", "김지은"),
                ResponseHomeDto("", "김지영"),
                ResponseHomeDto("", "전채연"),
                ResponseHomeDto("", "임채영"),
                ResponseHomeDto("", "심혜빈")
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
