package de.stollenmayer.philipp.Pop_1_1_Androi.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.playrix.gardensca.R

class GameAdapter: RecyclerView.Adapter<GameAdapter.RecordViewHolder>() {


    var resultList = arrayListOf<String>()


    class RecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hit = itemView.findViewById<TextView>(R.id.tvB)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false)
        return RecordViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.hit.text = resultList[position]
    }

    override fun getItemCount(): Int {
        return resultList.size
    }
}