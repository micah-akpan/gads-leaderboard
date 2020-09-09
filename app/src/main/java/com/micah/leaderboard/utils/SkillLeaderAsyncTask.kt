package com.micah.leaderboard.utils

import android.os.AsyncTask
import com.micah.leaderboard.models.Leader
import java.lang.ref.WeakReference

class SkillLeaderAsyncTask(): AsyncTask<String, Nothing, List<Leader>>() {
    private lateinit var taskDelegate: WeakReference<TaskDelegate>
    private val RESPONSE_CODE_SUCCESS = 200

    constructor(delegate: TaskDelegate) : this() {
        taskDelegate = WeakReference(delegate)
    }

    override fun doInBackground(vararg params: String): List<Leader>? {
        val leaderService: SkillLeaderService = SkillLeaderService.create()
        val leaders = leaderService.getLearningLeadersBySkillIQ()

        val response = leaders.execute()
        if (response.code() == RESPONSE_CODE_SUCCESS) {
            return response.body()
        }
        return null;
    }

    override fun onPostExecute(leaders: List<Leader>?) {
        taskDelegate.get()?.onSuccessCallback(leaders)
    }
}