package com.example.f.submisionfinal.view.match.fragment

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import com.example.f.submisionfinal.R
import com.example.f.submisionfinal.data.repository.MatchRepository
import com.example.f.submisionfinal.databinding.FragmentFavoriteMatchViewBinding
import com.example.f.submisionfinal.util.CostumViewModelFactory
import com.example.f.submisionfinal.view.base.BaseFragment
import com.example.f.submisionfinal.view.match.MatchViewModel

class FragmentFavoriteMatch:BaseFragment<FragmentFavoriteMatchViewBinding,MatchViewModel>() {

    override fun setLayoutResource(): Int = R.layout.fragment_favorite_match_view

    override fun code() {

        mainDataBinding.setLifecycleOwner(this)
        //setViewModel
        viewModel = ViewModelProviders.of(this, CostumViewModelFactory(MatchRepository()))
                .get(MatchViewModel::class.java)

        //set variable untuk xml
        mainDataBinding.itemBinding = viewModel

        mainDataBinding.recyclerViewFragment.layoutManager = LinearLayoutManager(viewBinding.context)

        viewModel.showFavorite(context)

    }

}