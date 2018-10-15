package com.example.f.submisionfinal.data.source.remote

import android.arch.lifecycle.MutableLiveData
import android.support.test.espresso.idling.CountingIdlingResource
import com.example.f.submisionfinal.data.model.match.Match
import com.example.f.submisionfinal.data.model.team.Team
import com.example.f.submisionfinal.util.SchedulerProviders
import com.example.f.submisionfinal.util.netConfig.ConnectToInetLib
import com.example.f.submisionfinal.util.netConfig.ResponseRetrofit
import com.example.f.submisionfinal.view.match.MatchAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class MatchRemoteData {
    var network = ConnectToInetLib().getConnected()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var adapter: MatchAdapter = MatchAdapter()
    var loading: MutableLiveData<Boolean> = MutableLiveData()
    var rvVisibility: MutableLiveData<Boolean> = MutableLiveData()

    var providerSchedulers: SchedulerProviders.BaseSchedulerProvider = SchedulerProviders.SchedulerProvider()

    var idlingResource: CountingIdlingResource = CountingIdlingResource("Network_Calls")

    fun getNextMatch(id:String){

        //penambahan idle resource
        idlingResource.increment()

        compositeDisposable.add(network.getNextMatch(id)
                .observeOn(providerSchedulers.ui())
                .subscribeOn(providerSchedulers.io())
                .doOnSubscribe{onSubscribe()}
                .doOnComplete{onCompleteSubscribe()}
                .subscribe({subscribeSuccess(it)},{}))
    }

    fun getLastMatch(id:String){
        idlingResource.increment()
        compositeDisposable.add(network.getLastMatch(id)
                .observeOn(providerSchedulers.ui())
                .subscribeOn(providerSchedulers.io())
                .doOnSubscribe{onSubscribe()}
                .doOnComplete{onCompleteSubscribe()}
                .subscribe({subscribeSuccess(it)},{}))
    }

    fun getEventByName(name:String){
        idlingResource.increment()
        compositeDisposable.add(network.getEventByName(name)
                .observeOn(providerSchedulers.ui())
                .subscribeOn(providerSchedulers.io())
                .doOnSubscribe{onSubscribe()}
                .doOnComplete{onCompleteSubscribe()}
                .subscribe({subscribeEventByName(it)},{}))
    }


    abstract fun onSubscribe()

    abstract fun onCompleteSubscribe()

    abstract fun subscribeSuccess(match: Match)

    abstract fun subscribeEventByName(match: Match)

}