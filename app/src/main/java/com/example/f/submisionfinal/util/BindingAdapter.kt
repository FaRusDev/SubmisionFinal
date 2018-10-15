package com.example.f.submisionfinal.util

import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.example.f.submisionfinal.data.model.team.Team
import com.example.f.submisionfinal.data.source.remote.TeamRemoteData
import com.example.f.submisionfinal.util.netConfig.ConnectToInetLib
import com.squareup.picasso.Picasso
import io.reactivex.disposables.CompositeDisposable

@BindingAdapter("app:visible")
fun mutableVisibility(v: View, visible:Boolean){
    v.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("app:rvAdapter")
fun mutableAdapter(rv: RecyclerView, adapter: RecyclerView.Adapter<*>){
    rv.adapter = adapter
}


@BindingAdapter("app:imgRes")
fun mutableImage(imageView: ImageView, id:String?){

    //TODO:ini ada gak cara yang lebih simple kyk import dari MatchViewModel ? udah coba-coba tapi masih aja gagal
    //satu-satunya cara yang berhasil smapi skarang pake ini


    val teamRemoteData = object : TeamRemoteData(){
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

        override fun subscribeSuccess(team: Team) {
            Picasso.get().load(team.teams?.get(0)?.strTeamBadge).into(imageView)
        }

    }
    teamRemoteData.getTeam(id)
}

@BindingAdapter("imgPlayer")
fun mutablePlayerImage(imageView: ImageView,imgUrl:String?){
    Picasso.get().load(imgUrl).into(imageView)
}