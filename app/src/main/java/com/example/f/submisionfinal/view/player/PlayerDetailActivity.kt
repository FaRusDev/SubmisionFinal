package com.example.f.submisionfinal.view.player

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.content.ContextCompat
import android.view.Menu
import com.example.f.submisionfinal.R
import com.example.f.submisionfinal.data.model.player.PlayerItem
import com.example.f.submisionfinal.data.repository.PlayerRepository
import com.example.f.submisionfinal.databinding.ActivityDetailPlayerViewBinding
import com.example.f.submisionfinal.util.CostumPlayerViewModelFactory
import com.example.f.submisionfinal.util.EXTRA_PLAYER
import com.example.f.submisionfinal.util.EXTRA_TEAM
import com.example.f.submisionfinal.view.base.BaseActivity

class PlayerDetailActivity:BaseActivity<ActivityDetailPlayerViewBinding,PlayerViewModel>() {

    lateinit var extraPlayer:PlayerItem

    override fun setLayoutResource(): Int = R.layout.activity_detail_player_view

    override fun code() {
        viewModel = ViewModelProviders.of(this, CostumPlayerViewModelFactory(PlayerRepository()))
                .get(PlayerViewModel::class.java)

        extraPlayer = intent.extras.getParcelable(EXTRA_PLAYER)
        mainDataBinding.setLifecycleOwner(this)

        mainDataBinding.itemBinding = extraPlayer
    }

}