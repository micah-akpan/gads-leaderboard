package com.micah.leaderboard.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.micah.leaderboard.R
import com.micah.leaderboard.models.Leader

class SkillIQAdapter(private val context: Fragment): RecyclerView.Adapter<SkillIQAdapter.ViewHolder>() {
    var TAG: String = this::class.java.name
    lateinit var mLeaders: ArrayList<Leader>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.leaderboard_skill_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mLeaders.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val leader: Leader = mLeaders[position]
        holder.apply {
            leaderName.text = leader.name
            leaderSkillLocation.text = context.getString(R.string.lb_skill_location_note, leader.skillIQ, leader.location)
            leaderImage.setImageResource(R.drawable.skill_iq_badge)
        }
    }

    fun setLeaders(leaders: ArrayList<Leader>) {
        mLeaders = leaders
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var leaderImage: ImageView = itemView.findViewById(R.id.lb_leader_badge)
        var leaderName: TextView = itemView.findViewById(R.id.lb_leader_name)
        var leaderSkillLocation: TextView = itemView.findViewById(R.id.lb_leader_skill_location)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

        }
    }
}