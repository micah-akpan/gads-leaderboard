package com.micah.leaderboard.utils

import com.micah.leaderboard.models.Leader
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface LearningLeaderService {
    @GET("/api/hours")
    fun getLearningLeadersByHours(): Call<List<Leader>>

    companion object {
        var baseAPIUrl = "https://gadsapi.herokuapp.com";
        fun create(): LearningLeaderService {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(baseAPIUrl)
                .build()

            val leaderService: LearningLeaderService =
                retrofit.create(LearningLeaderService::class.java)
            return leaderService
        }
    }
}

