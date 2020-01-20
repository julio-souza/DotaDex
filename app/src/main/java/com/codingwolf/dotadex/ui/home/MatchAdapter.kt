package com.codingwolf.dotadex.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codingwolf.dotadex.R
import com.codingwolf.dotadex.data.model.Match
import java.util.Date

class MatchAdapter(private val matches: List<Match>) : RecyclerView.Adapter<GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder =
        LayoutInflater.from(parent.context).run {
            inflate(R.layout.item_match, parent, false)
        }.let { view ->
            GameViewHolder(view)
        }

    override fun getItemCount() = matches.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val match = matches[position]
        holder.apply {
            itemView.context?.let { context ->
                date.text = Date(match.startTime.toLong()).toString()

                kda.text = context.getString(
                    R.string.pattern_kda,
                    match.kills,
                    match.deaths,
                    match.assists
                )
                result.text = getResultString(context, match.isVictory)
            }
        }
    }

    private fun getResultString(context: Context, victory: Boolean): String =
        if (victory) {
            context.getString(R.string.all_victory)
        } else {
            context.getString(R.string.all_defeat)
        }
}

class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val heroImage: ImageView = itemView.findViewById(R.id.imageView_itemMatch_hero)
    val itemSlot1Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_itemSlot1)
    val itemSlot2Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_itemSlot2)
    val itemSlot3Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_itemSlot3)
    val itemSlot4Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_itemSlot4)
    val itemSlot5Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_itemSlot5)
    val itemSlot6Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_itemSlot6)
    val backPack1Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_backPack1)
    val backPack2Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_backPack2)
    val backPack3Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_backPack3)
    val backPack4Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_backPack4)

    val date: TextView = itemView.findViewById(R.id.textView_itemMatch_date)
    val kda: TextView = itemView.findViewById(R.id.textView_itemMatch_kda)
    val result: TextView = itemView.findViewById(R.id.textView_itemMatch_result)
}
