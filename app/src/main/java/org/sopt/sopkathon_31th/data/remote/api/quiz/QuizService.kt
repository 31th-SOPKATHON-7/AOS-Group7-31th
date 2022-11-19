package org.sopt.sopkathon_31th.data.remote.api.quiz // ktlint-disable package-name

import org.sopt.sopkathon_31th.data.remote.entity.quiz.ResponseQuizDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface QuizService {
    // 개인별 퀴즈 문제 리스트 조회 API
    @GET("/page/quiz/{userId}")
    fun getQuizList(
        @Path("userId") userId: Long
    ): Call<ResponseQuizDto>
}
