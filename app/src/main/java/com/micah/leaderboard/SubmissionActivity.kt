package com.micah.leaderboard

import android.app.Fragment
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SubmissionActivity : AppCompatActivity() {
    private val dialog = SubmissionDialogFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission)
        setSupportActionBar(findViewById(R.id.lb_toolbar))


        findViewById<Button>(R.id.lb_form_submit_btn).setOnClickListener() {
            showPrompt()
        }

        resources.getString(R.string.submit_btn_title)
    }

    fun showPrompt() {
        // Create an instance of the dialog fragment and show it
//        val dialog = SubmissionDialogFragment()
        dialog.show(supportFragmentManager, SubmissionDialogFragment::class.simpleName)
    }

    fun submitProject() {
        val userFirstName = findViewById<EditText>(R.id.lb_form_first_name)
        val userLastName = findViewById<EditText>(R.id.lb_form_last_name)
        val userEmail = findViewById<EditText>(R.id.lb_form_email)
        val userProjectLink = findViewById<EditText>(R.id.lb_form_project_link)
    }

}