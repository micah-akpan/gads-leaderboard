package com.micah.leaderboard.utils

import android.os.AsyncTask
import com.micah.leaderboard.models.Leader
import retrofit2.Call
import retrofit2.Retrofit

class LearningLeaderAsyncTask: AsyncTask<String, Nothing, Call<List<Leader>>>() {
    var baseAPIUrl = "https://gadsapi.herokuapp.com";
    override fun doInBackground(vararg params: String): Call<List<Leader>> {
        var leaderService: LearningLeaderService = LearningLeaderService.create()
        return leaderService.getLearningLeadersByHours()
    }
}