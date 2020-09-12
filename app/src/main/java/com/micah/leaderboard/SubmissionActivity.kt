package com.micah.leaderboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SubmissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission)
        setSupportActionBar(findViewById(R.id.lb_toolbar))
    }
}