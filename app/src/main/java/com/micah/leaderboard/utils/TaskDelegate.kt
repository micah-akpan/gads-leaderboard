package com.micah.leaderboard.utils

import com.micah.leaderboard.models.Leader

interface TaskDelegate {
    fun onSuccessCallback(leaders: List<Leader>?)
}