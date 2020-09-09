package com.micah.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.micah.leaderboard.adapters.SkillIQAdapter
import com.micah.leaderboard.models.Leader
import com.micah.leaderboard.utils.SkillLeaderAsyncTask
import com.micah.leaderboard.utils.TaskDelegate

class SkillLeadersFragment : Fragment(), TaskDelegate {

    private var mLearningLeaderAsyncTask = SkillLeaderAsyncTask(this)
    private val mSkillLeaderAdapter = SkillIQAdapter(this)
    private lateinit var mRecyclerView: RecyclerView
    private val mLeaders: ArrayList<Leader> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStop() {
        super.onStop()
        mLearningLeaderAsyncTask.cancel(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_skill_leaders, container, false)
    }

    fun fetchLeaders() {
        mLearningLeaderAsyncTask.execute(null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mRecyclerView = view.findViewById(R.id.lb_skill_list)
        fetchLeaders()
    }

    override fun onSuccessCallback(leaders: List<Leader>?) {
        mLeaders.addAll(leaders as ArrayList)

        mRecyclerView.apply {
            adapter = mSkillLeaderAdapter
            layoutManager = LinearLayoutManager(this.context)
        }

        mSkillLeaderAdapter.setLeaders(mLeaders)
    }
}