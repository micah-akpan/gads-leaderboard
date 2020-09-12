package com.micah.leaderboard

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.DialogFragment

class SubmissionDialogFragment : DialogFragment() {

    val TAG = this::class.simpleName

    override fun onStart() {
//        val iView = activity?.findViewById<ImageView>(R.id.imageView2)
        super.onStart()
//        val iView = view.findViewById<ImageView>(R.id.imageView2)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;

            val view = inflater.inflate(R.layout.proj_submissn_dialog_content, null)
//            val imageView = view.findViewById<ImageView>(R.id.imageView2)

//            view.findViewById<ImageView>(R.id.iv_close_button).setOnClickListener {
//                Log.d(TAG, "Image view clicked...")
//            }
//
//            view.findViewById<Button>(R.id.yesButton).setOnClickListener {
//                Log.d(TAG, "yes button view clicked...")
//            }

            builder.setView(inflater.inflate(R.layout.proj_submissn_dialog_content, null))

            view.findViewById<ImageView>(R.id.iv_close_button).setOnClickListener {
                Log.d(TAG, "Image view clicked...")
            }

            view.findViewById<Button>(R.id.yesButton).setOnClickListener {
                Log.d(TAG, "yes button view clicked...")
            }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val iView = activity?.findViewById<ImageView>(R.id.imageView2)
    }

    fun closeDialog() {
        dismiss()
    }
}