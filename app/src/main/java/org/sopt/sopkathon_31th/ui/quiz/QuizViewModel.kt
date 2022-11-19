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
    fun getQuizList(userId: Int) {
        quizList = listOf(
            ResponseQuizDto.Data.Quiz(0, "이 사람은\n여자/남자친구를 5명 이상\n만났을 것이다."),
            ResponseQuizDto.Data.Quiz(1, "이 사람은\n2년 이상 연애한 애인이\n있을 것이다."),
            ResponseQuizDto.Data.Quiz(2, "이 사람은\n솝트 내의 번개모임을\n좋아할 것이다."),
            ResponseQuizDto.Data.Quiz(3, "이 사람은\n소주를 2병 이상\n마실 것이다."),
            ResponseQuizDto.Data.Quiz(4, "이 사람은\n해외 여행을 3번 이상\n가봤을 것이다.")
        )

        answerList = listOf(
            ResponseQuizDto.Data.Answer(0, "X"),
            ResponseQuizDto.Data.Answer(1, "X"),
            ResponseQuizDto.Data.Answer(2, "O"),
            ResponseQuizDto.Data.Answer(3, "X"),
            ResponseQuizDto.Data.Answer(4, "O")
        )

        _quizIndex.value = 0
        answerCount = 0

//        // 서버 통신 API 연결
//        quizService.getQuizList(userId).enqueue(object : Callback<ResponseQuizDto> {
//            override fun onResponse(
//                call: Call<ResponseQuizDto>,
//                response: Response<ResponseQuizDto>
//            ) {
//                if (response.isSuccessful) {
//                    // 퀴즈가 존재하지 않는 경우
//                    if (response.body()?.data?.quizes == null) {
//                        _errorMessage.value = "저장된 퀴즈가 없습니다."
//                    }
//
//                    // get quiz list success
//                    quizList = response.body()?.data?.quizes!!
//
//                    // 퀴즈 인덱스 및 정답 변수 초기화
//                    _quizIndex.value = 0
//                    answerCount = 0
//                }
//                // get quiz list fail
//                else {
//                    _errorMessage.value = "퀴즈 불러오기에 실패하였습니다."
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseQuizDto>, t: Throwable) {
//                _errorMessage.value = "오류가 발생하였습니다."
//                Log.e("GET_QUIZ_LIST_FAIL", "cause : " + t.cause)
//                Log.e("GET_QUIZ_LIST_FAIL", "message : " + t.message)
//            }
//        })
    }

    fun setQuiz() {
        if (_quizIndex.value!! >= 5) return
        _quizTitle.value = quizIndex.value?.let { quizList.get(it).quiz }
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
        if (_quizIndex.value!! >= 5) return
        _quizTitle.value = _quizIndex.value?.let { quizList.get(it).quiz }
    }
}
