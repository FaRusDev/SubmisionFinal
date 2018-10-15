package com.example.f.submisionfinal.data.source.remote

import android.arch.lifecycle.MutableLiveData
import android.support.test.espresso.idling.CountingIdlingResource
import com.example.f.submisionfinal.data.model.league.League
import com.example.f.submisionfinal.data.model.match.Match
import com.example.f.submisionfinal.data.model.team.Team
import com.example.f.submisionfinal.util.SchedulerProviders
import com.example.f.submisionfinal.util.netConfig.ConnectToInetLib
import com.example.f.submisionfinal.util.netConfig.ResponseRetrofit
import com.example.f.submisionfinal.view.match.MatchAdapter
import com.example.f.submisionfinal.view.team.TeamAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class TeamRemoteData {

    var network = ConnectToInetLib().getConnected()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var adapter: TeamAdapter = TeamAdapter()
    var loading: MutableLiveData<Boolean> = MutableLiveData()
    var rvVisibility: MutableLiveData<Boolean> = MutableLiveData()

    var providerSchedulers: SchedulerProviders.BaseSchedulerProvider = SchedulerProviders.SchedulerProvider()

    var idlingResource: CountingIdlingResource = CountingIdlingResource("Network_Calls")

    fun getTeam(id:String?){

        //penambahan idle resource
        idlingResource.increment()

        compositeDisposable.add(network.getTeam(id)
                .observeOn(providerSchedulers.ui())
                .subscribeOn(providerSchedulers.io())
                .doOnSubscribe{onSubscribe()}
                .doOnComplete{onCompleteSubscribe()}
                .subscribe({subscribeSuccess(it)},{}))
    }

    fun getAllTeam(league:String){

        //penambahan idle resource
        idlingResource.increment()

        compositeDisposable.add(network.getAllTeam(league)
                .observeOn(providerSchedulers.ui())
                .subscribeOn(providerSchedulers.io())
                .doOnSubscribe{onSubscribe()}
                .doOnComplete{onCompleteSubscribe()}
                .subscribe({subscribeSuccess(it)},{}))
    }

    fun getTeamByName(name:String){

        //penambahan idle resource
        idlingResource.increment()

        compositeDisposable.add(network.getTeamByName(name)
                .observeOn(providerSchedulers.ui())
                .subscribeOn(providerSchedulers.io())
                .doOnSubscribe{onSubscribe()}
                .doOnComplete{onCompleteSubscribe()}
                .subscribe({subscribeSuccess(it)},{}))
    }

    abstract fun onSubscribe()

    abstract fun onCompleteSubscribe()

    abstract fun subscribeSuccess(team: Team)

}