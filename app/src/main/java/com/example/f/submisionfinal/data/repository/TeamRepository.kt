package com.example.f.submisionfinal.data.repository

import android.arch.lifecycle.MutableLiveData
import com.example.f.submisionfinal.data.model.team.Team
import com.example.f.submisionfinal.data.source.remote.TeamRemoteData

open class TeamRepository() {

    var teamRemoteData: TeamRemoteData = object : TeamRemoteData(){

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

        override fun subscribeSuccess(team: Team)     {
            adapter.updateData(team.teams)
        }

    }

    val loading: MutableLiveData<Boolean> = teamRemoteData.loading
    val rvVisibility: MutableLiveData<Boolean> = teamRemoteData.rvVisibility
    val adapter= teamRemoteData.adapter
    var providerSchedulers = teamRemoteData.providerSchedulers

    fun getTeam(idLeague:String){
        teamRemoteData.getTeam(idLeague)
    }
    fun getAllTeam(league:String){
        teamRemoteData.getAllTeam(league)
    }

    fun getTeamByName(name:String){
        teamRemoteData.getTeamByName(name)
    }
}