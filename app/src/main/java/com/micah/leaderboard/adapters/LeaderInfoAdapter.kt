import android.content.Context
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


class LeaderInfoAdapter(private val context: Fragment) : RecyclerView.Adapter<LeaderInfoAdapter.ViewHolder>() {
    var TAG: String = LeaderInfoAdapter::class.java.name
    lateinit var mLeaders: ArrayList<Leader>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.leaderboard_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mLeaders.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val leader: Leader = mLeaders[position]
        holder.apply {
            leaderName.text = leader.name
            leaderHourLocation.text = context.getString(R.string.lb_hours_location_note, leader.hours, leader.location)
            leaderImage.setImageResource(R.drawable.top_learner_badge)
        }
    }

    fun setLeaders(leaders: ArrayList<Leader>) {
        mLeaders = leaders
        notifyDataSetChanged()
    }

    inner class ViewHolder : RecyclerView.ViewHolder, View.OnClickListener {
        var leaderImage: ImageView
        var leaderName: TextView
        var leaderHourLocation: TextView

        constructor(itemView: View): super(itemView) {
            leaderImage = itemView.findViewById(R.id.imageView)
            leaderName = itemView.findViewById(R.id.lb_item_leader_name)
            leaderHourLocation = itemView.findViewById(R.id.lb_leader_hours_location)

            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

        }
    }
}