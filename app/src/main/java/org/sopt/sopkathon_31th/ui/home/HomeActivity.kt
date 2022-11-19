package org.sopt.sopkathon_31th.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sopkathon_31th.R
import org.sopt.sopkathon_31th.databinding.ActivityHomeBinding
import org.sopt.sopkathon_31th.ui.home.part.*
import org.sopt.sopkathon_31th.ui.home.part.adapter.HomeAdapter
import org.sopt.sopkathon_31th.ui.home.part.plan.PlanFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
    }

    private fun initAdapter() {
        homeAdapter = HomeAdapter(this) { initFragment(it) }
        binding.rvPart.adapter = homeAdapter
    }

    private fun initFragment(part: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        when (part) {
            0 -> transaction.replace(R.id.fc_home, PlanFragment())
            1 -> transaction.replace(R.id.fc_home, DesignFragment())
            2 -> transaction.replace(R.id.fc_home, AndroidFragment())
            3 -> transaction.replace(R.id.fc_home, IosFragment())
            4 -> transaction.replace(R.id.fc_home, WebFragment())
            5 -> transaction.replace(R.id.fc_home, ServerFragment())
        }
        transaction.commit()
    }
}
