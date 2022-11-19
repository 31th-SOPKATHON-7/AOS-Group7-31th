package org.sopt.sopkathon_31th.data.remote // ktlint-disable package-name

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.sopt.sopkathon_31th.data.remote.api.quiz.QuizService
import retrofit2.Retrofit

object ServiceFactory {
    private const val BASE_URL = "https://4d9cc071-f745-4823-bcf0-fd31ae1b6f6b.mock.pstmn.io"

    val retrofitAuth: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofitAuth.create<T>(T::class.java)
}

object ServicePool {
    val quizService = ServiceFactory.create<QuizService>()
}
