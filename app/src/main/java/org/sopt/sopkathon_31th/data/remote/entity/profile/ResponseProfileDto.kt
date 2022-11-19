package org.sopt.sopkathon_31th.data.remote.entity.profile

import kotlinx.serialization.Serializable

@Serializable
data class ResponseProfileDto(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
) {
    @Serializable
    data class Data(
        val user: User
    ) {
        @Serializable
        data class User(
            val userId: Int,
            val nickname: String,
            val name: String,
            val part: String,
            val ybob: String,
            val age: Int,
            val mbti: String,
            val univ: String,
            val major: String,
            val gender: String,
            val faceShape: String,
            val samdae: Int,
            val footsize: Int,
            val height: Int,
            val photoUrl: String
        )
    }
}
