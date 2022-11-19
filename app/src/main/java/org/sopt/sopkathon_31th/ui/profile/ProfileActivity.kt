package org.sopt.sopkathon_31th.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import org.sopt.sopkathon_31th.databinding.ActivityProfileBinding
import org.sopt.sopkathon_31th.ui.home.HomeActivity
// 문제풀기 버튼 누를 때 userId의 변수값을 넘겨줘야함(변수명만 넘겨주면 됨, putExtra)
class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setSupportActionBar()
//        binding.btnProfileBack.setOnClickListener {
//            startActivity(
//                Intent(
//                    this@ProfileActivity,
//                    HomeActivity::class.java
//                ).apply {
//                    putExtra("userID", )
//                }
//            )
//
//        }
        binding.btnProfileBack.setOnClickListener {
            startActivity(
                Intent(
                    this@ProfileActivity,
                    HomeActivity::class.java
                )
            )
        }
    }
}
