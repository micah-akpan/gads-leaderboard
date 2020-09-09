package com.micah.leaderboard

import LeaderInfoAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.micah.leaderboard.models.Leader

import com.micah.leaderboard.utils.FakeData
import com.micah.leaderboard.utils.LearningLeaderAsyncTask
import com.micah.leaderboard.utils.TaskDelegate

class LearningLeadersFragment : Fragment(), TaskDelegate {

    private val mLeaderInfoAdapter = LeaderInfoAdapter(this)
    private lateinit var mRecyclerView: RecyclerView
    private var mLearningLeaderAsyncTask = LearningLeaderAsyncTask(this)
    private val mLeaders: ArrayList<Leader> = ArrayList()
    private val TAG = LearningLeadersFragment::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        mLearningLeaderAsyncTask.cancel(true)
    }

    fun fetchLeaders() {
        mLearningLeaderAsyncTask.execute("")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mRecyclerView = view.findViewById(R.id.lb_list)
        fetchLeaders()
    }

    override fun onSuccessCallback(leaders: List<Leader>?) {
        Log.d(TAG, leaders?.get(0)?.name)
        mLeaders.addAll(leaders as ArrayList)

        mRecyclerView.apply {
            adapter = mLeaderInfoAdapter
            layoutManager = LinearLayoutManager(this.context)
        }

        mLeaderInfoAdapter.setLeaders(mLeaders)
    }
}
