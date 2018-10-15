package com.example.f.submisionfinal.data.source.remote

import android.arch.lifecycle.MutableLiveData
import android.support.test.espresso.idling.CountingIdlingResource
import com.example.f.submisionfinal.data.model.player.Player
import com.example.f.submisionfinal.util.SchedulerProviders
import com.example.f.submisionfinal.util.netConfig.ConnectToInetLib
import com.example.f.submisionfinal.view.player.PlayerAdapter
import com.example.f.submisionfinal.view.team.TeamAdapter
import io.reactivex.disposables.CompositeDisposable

abstract class PlayerRemoteData {

    var network = ConnectToInetLib().getConnected()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var adapter: PlayerAdapter = PlayerAdapter()
    var loading: MutableLiveData<Boolean> = MutableLiveData()
    var rvVisibility: MutableLiveData<Boolean> = MutableLiveData()

    var providerSchedulers: SchedulerProviders.BaseSchedulerProvider = SchedulerProviders.SchedulerProvider()

    var idlingResource: CountingIdlingResource = CountingIdlingResource("Network_Calls")

    fun getPlayer(id:String){

        //penambahan idle resource
        idlingResource.increment()

        compositeDisposable.add(network.getPlayer(id)
                .observeOn(providerSchedulers.ui())
                .subscribeOn(providerSchedulers.io())
                .doOnSubscribe{onSubscribe()}
                .doOnComplete{onCompleteSubscribe()}
                .subscribe({subscribeSuccess(it)},{}))
    }

    fun getTeamPlayer(teamId:String){

        //penambahan idle resource
        idlingResource.increment()

        compositeDisposable.add(network.getTeamPlayer(teamId)
                .observeOn(providerSchedulers.ui())
                .subscribeOn(providerSchedulers.io())
                .doOnSubscribe{onSubscribe()}
                .doOnComplete{onCompleteSubscribe()}
                .subscribe({subscribeSuccess(it)},{}))
    }

    abstract fun onSubscribe()

    abstract fun onCompleteSubscribe()

    abstract fun subscribeSuccess(player: Player)

}