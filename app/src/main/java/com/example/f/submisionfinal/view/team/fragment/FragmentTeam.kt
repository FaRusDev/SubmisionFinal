package com.example.f.submisionfinal.view.team.fragment

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.f.submisionfinal.R
import com.example.f.submisionfinal.data.repository.TeamRepository
import com.example.f.submisionfinal.databinding.FragmentTeamViewBinding
import com.example.f.submisionfinal.util.CostumTeamViewModelFactory
import com.example.f.submisionfinal.util.RxSearchView
import com.example.f.submisionfinal.view.base.BaseFragment
import com.example.f.submisionfinal.view.team.TeamViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_team_view.*
import kotlinx.android.synthetic.main.fragment_team_view.view.*
import kotlinx.android.synthetic.main.fragment_view.view.*

class FragmentTeam:BaseFragment<FragmentTeamViewBinding,TeamViewModel>(){
    override fun setLayoutResource(): Int = R.layout.fragment_team_view

    var listLeague = listOf(
            "English Premiere League",
            "English League Championship",
            "German Bundesliga",
            "Italian Serie A",
            "French Ligue 1",
            "Spanish La Liga"
            )

    var league:String = "English League Championship"
    lateinit var x:Unit
    val rxSearchView = RxSearchView()

    override fun code() {


        viewModel = ViewModelProviders.of(this, CostumTeamViewModelFactory(TeamRepository()))
                .get(TeamViewModel::class.java)

        mainDataBinding.setLifecycleOwner(this)
        mainDataBinding.itemBinding = viewModel

        mainDataBinding.recyclerViewFragment.layoutManager = LinearLayoutManager(viewBinding.context)

        val teamSpinnerAdapter = ArrayAdapter(context,android.R.layout.simple_spinner_item,listLeague)
        teamSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        viewBinding.teamSpinner.adapter = teamSpinnerAdapter
        viewBinding.teamSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                league = "English League Championship"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                league = teamSpinner.selectedItem.toString()
                x = viewModel.getAllTeam(league)
            }
        }

        x = viewModel.getAllTeam(league)
        x

        rxSearchView.getSearchView(viewBinding.searchTeam)

        val compositeDisposable = viewModel.teamRepository.teamRemoteData.compositeDisposable

        compositeDisposable.add(rxSearchView.getTextWatcherObservable()
                .debounce(500, java.util.concurrent.TimeUnit.MILLISECONDS) //delay input 500MS
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { searchText ->
                    if (searchText.isEmpty()) {
                        x = viewModel.getAllTeam(league)
                    } else if (!searchText.isEmpty()) {
                        val query = searchText
                        x = viewModel.getTeamByName(query)
                    }
                })
    }

}