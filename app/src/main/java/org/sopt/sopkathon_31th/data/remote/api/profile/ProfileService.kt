package org.sopt.sopkathon_31th.data.remote.api.profile

import org.sopt.sopkathon_31th.data.remote.entity.profile.ResponseProfileDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileService {
    @GET("/page/{userId}")
    fun getProfile(
        @Path("userId") userId: Int
    ): Call<ResponseProfileDto>
}
