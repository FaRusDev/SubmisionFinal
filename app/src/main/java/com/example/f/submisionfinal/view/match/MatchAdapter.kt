package com.example.f.submisionfinal.view.match

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.f.submisionfinal.R
import com.example.f.submisionfinal.data.model.match.EventsItem
import com.example.f.submisionfinal.databinding.ItemMatchRecyclerViewBinding
import com.example.f.submisionfinal.util.EXTRA_MATCH

class MatchAdapter: RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    lateinit var match: List<EventsItem?>

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MatchViewHolder =
        MatchViewHolder(DataBindingUtil.inflate(LayoutInflater.from(p0.context)
                , R.layout.item_match_recycler_view,p0,false))


    override fun getItemCount(): Int = match.size

    override fun onBindViewHolder(p0: MatchViewHolder, p1: Int) {
        p0.bindItem(match[p1])
    }

    //update data setiap ada koneksi
    fun updateData(list: List<EventsItem?>?){
        this.match = list!!
        notifyDataSetChanged()
    }

    inner class MatchViewHolder(private val recylerBinding:ItemMatchRecyclerViewBinding)
        : RecyclerView.ViewHolder(recylerBinding.root){

        fun bindItem(list:EventsItem?) = with(recylerBinding.root){
            recylerBinding.matchBindingRv = list!!

            setOnClickListener {
                val i = Intent(itemView.context,MatchDetailActivity::class.java)
                i.putExtra(EXTRA_MATCH,list)
                itemView.context.startActivity(i)
            }
        }

    }
}