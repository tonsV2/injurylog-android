package dk.fitfit.injurylog.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import dk.fitfit.injurylog.R
import dk.fitfit.injurylog.db.model.InjuryWithTags
import kotlinx.android.synthetic.main.injury_item.view.*

class InjuriesAdapter(private val onItemClickListener: (InjuryWithTags) -> Unit) : ListAdapter<InjuryWithTags, InjuriesAdapter.InjuryHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InjuryHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.injury_item, parent, false)
        return InjuryHolder(itemView)
    }

    override fun onBindViewHolder(holder: InjuryHolder, position: Int) {
        val injuryWithTags = getItem(position)
        holder.occurredAt.text = injuryWithTags.injury.occurredAt.toString()
        holder.description.text = injuryWithTags.injury.description
    }

    inner class InjuryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val occurredAt: TextView = itemView.occurredAt
        val description: TextView = itemView.description

        init {
            itemView.setOnClickListener {
                if(adapterPosition != NO_POSITION) {
                    onItemClickListener(getItem(adapterPosition))
                }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<InjuryWithTags>() {
            override fun areItemsTheSame(oldItem: InjuryWithTags, newItem: InjuryWithTags) = oldItem.injury.id == newItem.injury.id

            override fun areContentsTheSame(oldItem: InjuryWithTags, newItem: InjuryWithTags) = oldItem.injury.occurredAt == newItem.injury.occurredAt
                    && oldItem.injury.description == newItem.injury.description
        }
    }
}
