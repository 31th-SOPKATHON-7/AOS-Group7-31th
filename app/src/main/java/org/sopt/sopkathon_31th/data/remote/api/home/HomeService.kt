package org.sopt.sopkathon_31th.data.remote.api.home

import org.sopt.sopkathon_31th.data.remote.entity.home.ResponseHomeDto
import retrofit2.Call
import retrofit2.http.GET

interface HomeService {
    @GET("/page")
    fun getHomeMembers(): Call<ResponseHomeDto>
}
