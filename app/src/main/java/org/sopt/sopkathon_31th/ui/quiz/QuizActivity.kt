package org.sopt.sopkathon_31th.ui.quiz // ktlint-disable package-name

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sopkathon_31th.databinding.ActivityQuizBinding
import org.sopt.sopkathon_31th.util.ContextExt.shortToast

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private val viewModel by viewModels<QuizViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getQuizList()
        answerBtnOnClick()
        closeBtnOnClick()
        updateQuiz()
        showErrorMsg()
        printResult()
    }

    fun getQuizList() {
        // ★★★ intent에서 userID 받아와서 getQuizList 함수 매개변수로 전달하기
        viewModel.getQuizList(1)
    }

    fun answerBtnOnClick() {
        binding.btnO.setOnClickListener { viewModel.checkAnswer("O") }
        binding.btnX.setOnClickListener { viewModel.checkAnswer("X") }
    }

    fun closeBtnOnClick() {
        binding.btnClose.setOnClickListener { finish() }
    }

    fun updateQuiz() {
        viewModel.quizIndex.observe(this) {
            binding.tvTitle.text = "문제 " + viewModel.quizIndex.value
        }
        viewModel.quizTitle.observe(this) {
            val question = viewModel.quizTitle.value?.split("\n")
            binding.tvQuestion1.text = question?.get(0)
            binding.tvQuestion2.text = question?.get(1)
            binding.tvQuestion3.text = question?.get(2)
        }
    }

    fun showErrorMsg() {
        viewModel.errorMessage.observe(this) {
            this.shortToast(viewModel.errorMessage.value.toString())
            finish()
        }
    }

    fun printResult() {
        viewModel.quizResult.observe(this) {
            if (viewModel.quizResult.value == true) {
                // ★★★ shared preference에 코인 5개 추가
                this.shortToast("문제를 모두 맞춰 5표창 획득했습니다.")
            } else {
                this.shortToast("틀린 문제가 있어 표창 획득에 실패했습니다.")
            }
            finish()
        }
    }
}
