package org.sopt.sopkathon_31th.ui.quiz // ktlint-disable package-name

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sopkathon_31th.data.remote.ServicePool.quizService
import org.sopt.sopkathon_31th.data.remote.entity.quiz.ResponseQuizDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuizViewModel : ViewModel() {
    private var answerCount = 0
    private lateinit var quizList: List<ResponseQuizDto.Data.Quiz>
    private lateinit var answerList: List<ResponseQuizDto.Data.Answer>

    private val _quizIndex = MutableLiveData<Int>()
    val quizIndex: LiveData<Int>
        get() = _quizIndex

    private val _quizTitle = MutableLiveData<String>()
    val quizTitle: LiveData<String>
        get() = _quizTitle

    private val _quizResult = MutableLiveData<Boolean>()
    val quizResult: LiveData<Boolean>
        get() = _quizResult

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    /** 서버에 퀴즈 리스트 요청 */
    fun getQuizList(userId: Long) {
        // 서버 통신 API 연결
        quizService.getQuizList(userId).enqueue(object : Callback<ResponseQuizDto> {
            override fun onResponse(
                call: Call<ResponseQuizDto>,
                response: Response<ResponseQuizDto>
            ) {
                if (response.isSuccessful) {
                    // 퀴즈가 존재하지 않는 경우
                    if (response.body()?.data?.quizes == null) {
                        _errorMessage.value = "저장된 퀴즈가 없습니다."
                    }

                    // get quiz list success
                    quizList = response.body()?.data?.quizes!!

                    // 퀴즈 인덱스 및 정답 변수 초기화
                    _quizIndex.value = 0
                    answerCount = 0
                }
                // get quiz list fail
                else {
                    _errorMessage.value = "퀴즈 불러오기에 실패하였습니다."
                }
            }

            override fun onFailure(call: Call<ResponseQuizDto>, t: Throwable) {
                _errorMessage.value = "오류가 발생하였습니다."
                Log.e("GET_QUIZ_LIST_FAIL", "cause : " + t.cause)
                Log.e("GET_QUIZ_LIST_FAIL", "message : " + t.message)
            }
        })
    }

    /** 퀴즈 정답 여부 확인 */
    fun checkAnswer(answer: String) {
        if (_quizIndex.value?.let { answerList.get(it).quiz.equals(answer) } == true) answerCount++

        _quizIndex.value = _quizIndex.value?.plus(1)
        Log.d("QUIZ_INDEX", _quizIndex.value.toString())
        if (_quizIndex.value == 5) {
            _quizResult.value = answerCount == 5
            return
        }
        _quizTitle.value = _quizIndex.value?.let { quizList.get(it).quiz }
    }
}
