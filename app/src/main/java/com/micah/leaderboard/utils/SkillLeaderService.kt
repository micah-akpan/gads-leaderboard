package com.micah.leaderboard.utils

import com.micah.leaderboard.models.Leader
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SkillLeaderService {
    @GET("/api/skilliq")
    fun getLearningLeadersBySkillIQ(): Call<List<Leader>>

    companion object {
        var baseAPIUrl = "https://gadsapi.herokuapp.com";
        fun create(): SkillLeaderService {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(baseAPIUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val leaderService: SkillLeaderService =
                retrofit.create(SkillLeaderService::class.java)
            return leaderService
        }
    }
}