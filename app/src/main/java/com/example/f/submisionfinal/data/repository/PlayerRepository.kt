package com.example.f.submisionfinal.data.repository

import android.arch.lifecycle.MutableLiveData
import com.example.f.submisionfinal.data.model.player.Player
import com.example.f.submisionfinal.data.source.remote.PlayerRemoteData

open class PlayerRepository {

    var playerRemoteData: PlayerRemoteData = object : PlayerRemoteData(){

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

        override fun subscribeSuccess(player: Player) {
            adapter.updateData(player.player)
        }
    }

    val loading: MutableLiveData<Boolean> = playerRemoteData.loading
    val rvVisibility: MutableLiveData<Boolean> = playerRemoteData.rvVisibility
    val adapter= playerRemoteData.adapter
    var providerSchedulers = playerRemoteData.providerSchedulers

    fun getTeamPlayer(idTeam:String){
        playerRemoteData.getTeamPlayer(idTeam)
    }
    fun getPlayer(id:String){
        playerRemoteData.getPlayer(id)
    }

}