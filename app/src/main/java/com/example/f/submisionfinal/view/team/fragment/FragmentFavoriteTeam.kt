package com.example.f.submisionfinal.view.team.fragment

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import com.example.f.submisionfinal.R
import com.example.f.submisionfinal.data.repository.TeamRepository
import com.example.f.submisionfinal.databinding.FragmentFavoriteTeamViewBinding
import com.example.f.submisionfinal.util.CostumTeamViewModelFactory
import com.example.f.submisionfinal.view.base.BaseFragment
import com.example.f.submisionfinal.view.team.TeamViewModel

class FragmentFavoriteTeam: BaseFragment<FragmentFavoriteTeamViewBinding, TeamViewModel>() {

    override fun setLayoutResource(): Int = R.layout.fragment_favorite_team_view

    override fun code() {

        mainDataBinding.setLifecycleOwner(this)
        //setViewModel
        viewModel = ViewModelProviders.of(this, CostumTeamViewModelFactory(TeamRepository()))
                .get(TeamViewModel::class.java)

        //set variable untuk xml
        mainDataBinding.itemBinding = viewModel

        mainDataBinding.recyclerViewFragment.layoutManager = LinearLayoutManager(viewBinding.context)

        viewModel.showFavorite(context)
    }

}