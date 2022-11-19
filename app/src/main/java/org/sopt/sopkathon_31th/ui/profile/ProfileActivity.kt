package org.sopt.sopkathon_31th.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sopkathon_31th.databinding.ActivityProfileBinding
import org.sopt.sopkathon_31th.ui.home.HomeActivity
import org.sopt.sopkathon_31th.ui.quiz.QuizActivity

// 문제풀기 버튼 누를 때 userId의 변수값을 넘겨줘야함(변수명만 넘겨주면 됨, putExtra)
class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
//        val adapter = ProfileAdapter(requireContext())
        setContentView(binding.root)
        profileAdapter = ProfileAdapter(this)
        binding.rvProfile.adapter = profileAdapter
        val key = listOf<String>("본명", "나이", "mbti", "학교", "전공", "성별", "얼굴형", "3대몇", "발사이즈", "키")
        val value = listOf<String>(
            "최수민",
            "23세",
            "ISFJ",
            "동국대학교",
            "경영정보학과",
            "여성",
            "원영",
            "240",
            "230mm",
            "157Cm"
        )

        profileAdapter.initList(key, value)

        binding.btnProfileBack.setOnClickListener {
            startActivity(
                Intent(
                    this@ProfileActivity,
                    HomeActivity::class.java

                )
            )
        }

        binding.btnProfile1.setOnClickListener {
            startActivity(
                Intent(
                    this@ProfileActivity,
                    QuizActivity::class.java

                )
            )
        }
        binding.btnProfile2.setOnClickListener {

        }
    }
}
