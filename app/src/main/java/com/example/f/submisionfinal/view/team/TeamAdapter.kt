package com.example.f.submisionfinal.view.team

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.f.submisionfinal.R
import com.example.f.submisionfinal.data.model.team.TeamsItem
import com.example.f.submisionfinal.databinding.FragmentTeamViewBinding
import com.example.f.submisionfinal.databinding.ItemTeamRecyclerViewBinding
import com.example.f.submisionfinal.util.EXTRA_MATCH
import com.example.f.submisionfinal.util.EXTRA_TEAM
import com.example.f.submisionfinal.view.match.MatchDetailActivity

class TeamAdapter:RecyclerView.Adapter<TeamAdapter.TeamVH>(){

    lateinit var team:List<TeamsItem?>

    fun updateData(teamList:List<TeamsItem?>?){
        this.team = teamList!!
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TeamVH =
            TeamVH(DataBindingUtil.inflate(LayoutInflater.from(p0.context)
                    , R.layout.item_team_recycler_view,p0,false))

    override fun getItemCount(): Int = team.size

    override fun onBindViewHolder(p0: TeamVH, p1: Int) {
        p0.bindItem(team[p1]!!)
    }

    inner class TeamVH(val itemBinding: ItemTeamRecyclerViewBinding)
        : RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(list:TeamsItem)= with(itemBinding.root){
            itemBinding.itemBinding = list

            setOnClickListener {
                val i = Intent(itemView.context, TeamDetailActivity::class.java)
                i.putExtra(EXTRA_TEAM,list)
                itemView.context.startActivity(i)
            }
        }
    }

}