package com.micah.leaderboard.utils

import com.micah.leaderboard.models.Leader

class FakeData {
    companion object {
        fun getFakeLeaders(): ArrayList<Leader> {
            return arrayListOf(
                Leader("Ralph Lauren", 60, "Egypt", 200, ""),
                Leader("Kofo Kojo", 89, "Nigeria", 250, ""),
                Leader("Sam George", 99, "Nigeria", 300, ""),
                Leader("Pete Hambert", 50, "Ghana", 280, "")
            )
        }
    }
}