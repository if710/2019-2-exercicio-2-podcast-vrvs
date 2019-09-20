package br.ufpe.cin.android.podcast

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ItemFeedAdapter (private val itemFeeds: List<ItemFeed>) : RecyclerView.Adapter<ItemFeedAdapter.ViewHolder>() {

    override fun getItemCount(): Int = itemFeeds.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = itemFeeds[position]
        holder.title.text = p.title
        holder.date.text = p.pubDate
    }

    class ViewHolder (item : View) : RecyclerView.ViewHolder(item), View.OnClickListener {
        val title : TextView = item.findViewById(R.id.item_title)
        val date : TextView = item.findViewById(R.id.item_date)
        private val download : TextView = item.findViewById(R.id.item_action)

        init {
            download.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Toast.makeText(v.context, "Downloading ${title.text}..", Toast.LENGTH_SHORT).show()
        }
    }
}