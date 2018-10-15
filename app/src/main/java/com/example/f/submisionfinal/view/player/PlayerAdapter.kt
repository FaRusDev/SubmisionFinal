package com.example.f.submisionfinal.view.player

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.f.submisionfinal.R
import com.example.f.submisionfinal.data.model.player.PlayerItem
import com.example.f.submisionfinal.databinding.ItemPlayerRecyclerViewBinding
import com.example.f.submisionfinal.util.EXTRA_PLAYER

class PlayerAdapter:RecyclerView.Adapter<PlayerAdapter.PlayerVH>(){
    lateinit var player:List<PlayerItem?>

    fun updateData(playerList:List<PlayerItem?>?){
        this.player = playerList!!
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PlayerVH =
            PlayerVH(DataBindingUtil.inflate(LayoutInflater.from(p0.context)
                    , R.layout.item_player_recycler_view,p0,false))

    override fun getItemCount(): Int = player.size

    override fun onBindViewHolder(p0: PlayerVH, p1: Int) {
        p0.bindItem(player[p1]!!)
    }

    inner class PlayerVH(val itemBinding: ItemPlayerRecyclerViewBinding)
        : RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(list: PlayerItem)= with(itemBinding.root){
            itemBinding.itemBinding = list

            setOnClickListener {
                val i = Intent(itemView.context, PlayerDetailActivity::class.java)
                i.putExtra(EXTRA_PLAYER,list)
                itemView.context.startActivity(i)
            }
        }
    }
}