package com.micah.leaderboard.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.micah.leaderboard.LearningLeadersFragment
import com.micah.leaderboard.SkillLeadersFragment

private const val ARG_OBJECT = "object"

class TabLayoutAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        lateinit var fragment: Fragment

        if (position == 0) {
            fragment = LearningLeadersFragment()
        } else {
            fragment = SkillLeadersFragment()
        }
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment;
    }
}
