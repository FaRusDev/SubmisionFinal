package com.example.f.submisionfinal.view.player

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import com.example.f.submisionfinal.R
import com.example.f.submisionfinal.data.repository.PlayerRepository
import com.example.f.submisionfinal.databinding.FragmentPlayerViewBinding
import com.example.f.submisionfinal.util.CostumPlayerViewModelFactory
import com.example.f.submisionfinal.view.base.BaseActivity

class PlayerActivity:BaseActivity<FragmentPlayerViewBinding,PlayerViewModel>() {
    override fun setLayoutResource(): Int = R.layout.fragment_player_view

//    var league = "English League Championship"
//    lateinit var x:Unit

    override fun code() {
        val id = intent.getStringExtra("player")

        viewModel = ViewModelProviders.of(this, CostumPlayerViewModelFactory(PlayerRepository()))
                .get(PlayerViewModel::class.java)


        mainDataBinding.setLifecycleOwner(this)
        mainDataBinding.itemBinding = viewModel

        mainDataBinding.recyclerViewFragment.layoutManager = LinearLayoutManager(this)

        viewModel.getTeamPlayer(id)
        supportActionBar?.title = "Player List"
    }
}