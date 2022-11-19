package org.sopt.sopkathon_31th.ui.home.part.plan

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sopkathon_31th.data.remote.ServiceFactory
import org.sopt.sopkathon_31th.data.remote.api.home.HomeService
import org.sopt.sopkathon_31th.data.remote.entity.home.ResponseHomeDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanViewModel : ViewModel() {
    private val _planProfiles = MutableLiveData<List<ResponseHomeDto.Data>>()
    val planProfiles: LiveData<List<ResponseHomeDto.Data>> get() = _planProfiles

    fun getPlanMembers() {
        val nameThiefService = ServiceFactory.retrofitAuth.create(HomeService::class.java)
        nameThiefService.getHomeMembers().enqueue(object : Callback<ResponseHomeDto> {
            override fun onResponse(
                call: Call<ResponseHomeDto>,
                response: Response<ResponseHomeDto>
            ) {
                if (response.isSuccessful) {
                    _planProfiles.value = response.body()?.user
                } else {
                    Log.e("home server connect", "onResponse Error")
                }
            }

            override fun onFailure(call: Call<ResponseHomeDto>, t: Throwable) {
                Log.e("home server connect", "onFailure")
            }
        })
    }
}
