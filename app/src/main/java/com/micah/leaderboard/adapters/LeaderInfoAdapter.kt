import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.micah.leaderboard.R
import com.micah.leaderboard.models.Leader
import com.micah.leaderboard.utils.FakeData

private val TAG = "LeaderInfoAdapter"

class LeaderInfoAdapter(val leaders: ArrayList<Leader>) : RecyclerView.Adapter<LeaderInfoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.leaderboard_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return FakeData.getFakeLeaders().size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val leader: Leader = leaders.get(position)
        holder.apply {
            leaderName.text = leader.name
            leaderHourLocation.text = leader.hours.toString() + " learning hours, " + leader.location
            leaderImage.setImageResource(R.drawable.top_learner_image)
        }
    }

    class ViewHolder : RecyclerView.ViewHolder, View.OnClickListener {
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
            Log.d(TAG, "Clicked the view holder housing the view")
        }
    }
}