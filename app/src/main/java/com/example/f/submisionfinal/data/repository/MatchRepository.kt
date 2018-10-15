package com.example.f.submisionfinal.data.repository

import android.arch.lifecycle.MutableLiveData
import com.example.f.submisionfinal.data.model.league.League
import com.example.f.submisionfinal.data.model.match.Match
import com.example.f.submisionfinal.data.model.team.Team
import com.example.f.submisionfinal.data.model.team.TeamsItem
import com.example.f.submisionfinal.data.source.remote.MatchRemoteData

open class MatchRepository {

    var matchRemoteData:MatchRemoteData = object : MatchRemoteData(){

        override fun onSubscribe()
        {
            rvVisibility.value = false
            loading.value = true
        }

        override fun onCompleteSubscribe()     {
            loading.value = false
            rvVisibility.value = true

            //penambahan idle resource
            idlingResource.decrement()
        }

        override fun subscribeSuccess(match: Match)     {
            adapter.updateData(match.events)
        }

        override fun subscribeEventByName(match: Match) {
            adapter.updateData(match.event)
        }
    }

    val loading: MutableLiveData<Boolean> = matchRemoteData.loading
    val rvVisibility: MutableLiveData<Boolean> = matchRemoteData.rvVisibility
    val adapter= matchRemoteData.adapter
    var providerSchedulers = matchRemoteData.providerSchedulers


    fun getNextMatch(idLeague:String){
        matchRemoteData.getNextMatch(idLeague)
    }

    fun getLastMatch(idLeague: String){
        matchRemoteData.getLastMatch(idLeague)
    }

    fun getEventByName(name:String){
        matchRemoteData.getEventByName(name)
    }
}