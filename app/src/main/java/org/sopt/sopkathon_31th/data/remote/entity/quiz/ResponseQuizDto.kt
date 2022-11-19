package org.sopt.sopkathon_31th.data.remote.entity.quiz // ktlint-disable package-name

import kotlinx.serialization.Serializable

@Serializable
data class ResponseQuizDto(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
) {
    @Serializable
    data class Data(
        val quizes: List<Quiz>,
        val answers: List<Answer>
    ) {
        @Serializable
        data class Quiz(
            val quizId: Long,
            val quiz: String
        )

        @Serializable
        data class Answer(
            val answerId: Long,
            val quiz: String
        )
    }
}
