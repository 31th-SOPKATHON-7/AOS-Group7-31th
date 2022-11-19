package org.sopt.sopkathon_31th.data.remote.entity.home

@kotlinx.serialization.Serializable
data class ResponseHomeDto(
    val user: List<Data>
) {
    @kotlinx.serialization.Serializable
    data class Data(
        val userId: Int,
        val photoUrl: String,
        val nickname: String
    )
}
