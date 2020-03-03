package com.codingwolf.dotadex.ui.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingwolf.dotadex.R
import com.codingwolf.dotadex.data.model.Match
import com.codingwolf.dotadex.domain.util.DateUtil

class MatchAdapter(
    private val matches: MutableList<Match>,
    private val dateUtil: DateUtil
) : RecyclerView.Adapter<GameViewHolder>() {

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
                Glide.with(context)
                    .load("http://cdn.dota2.com/apps/dota2/images/heroes/snapfire_full.png")
                    .into(heroImage)

                gpm.text = match.gpm.toString()
                xpm.text = match.xpm.toString()

                date.text = dateUtil.formatDate(match.startTime)

                kda.text = context.getString(
                    R.string.pattern_kda,
                    match.kills,
                    match.deaths,
                    match.assists
                )

                if (match.victory) {
                    result.text = context.getString(R.string.all_victory)
                    result.setTextColor(context.getColor(R.color.dotaDex_green))
                } else {
                    result.text = context.getString(R.string.all_defeat)
                    result.setTextColor(context.getColor(R.color.dotaDex_red))
                }
            }
        }
    }

    fun updateMatches(newMatches: List<Match>) {
        matches.clear()
        matches.addAll(newMatches)
        notifyDataSetChanged()
    }
}

class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val heroImage: ImageView = itemView.findViewById(R.id.imageView_itemMatch_hero)
//    val itemSlot1Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_itemSlot1)
//    val itemSlot2Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_itemSlot2)
//    val itemSlot3Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_itemSlot3)
//    val itemSlot4Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_itemSlot4)
//    val itemSlot5Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_itemSlot5)
//    val itemSlot6Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_itemSlot6)
//    val backPack1Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_backPack1)
//    val backPack2Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_backPack2)
//    val backPack3Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_backPack3)
//    val backPack4Image: ImageView = itemView.findViewById(R.id.imageView_itemMatch_backPack4)

    val gpm: TextView = itemView.findViewById(R.id.textView_fragmentHome_gpm)
    val xpm: TextView = itemView.findViewById(R.id.textView_fragmentHome_xpm)

    val date: TextView = itemView.findViewById(R.id.textView_itemMatch_date)
    val kda: TextView = itemView.findViewById(R.id.textView_itemMatch_kda)
    val result: TextView = itemView.findViewById(R.id.textView_itemMatch_result)
}
