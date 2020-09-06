package com.micah.leaderboard.utils

import android.os.AsyncTask
import com.micah.leaderboard.models.Leader
import java.lang.ref.WeakReference

class LearningLeaderAsyncTask(): AsyncTask<String, Nothing, List<Leader>>() {

    private lateinit var taskDelegate: WeakReference<TaskDelegate>

    constructor(delegate: TaskDelegate) : this() {
        taskDelegate = WeakReference(delegate)
    }

    private val RESPONSE_CODE_SUCCESS = 200

    override fun doInBackground(vararg params: String): List<Leader>? {
        val leaderService: LearningLeaderService = LearningLeaderService.create()
        val leaders = leaderService.getLearningLeadersByHours()
        
        // TODO: Retrofit runs it's task on a background task
        // TODO: Move this to a service that is called on the main thread
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
