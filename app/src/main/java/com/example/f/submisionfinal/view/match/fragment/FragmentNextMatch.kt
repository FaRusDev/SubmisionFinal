package com.example.f.submisionfinal.view.match.fragment

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.f.submisionfinal.R
import com.example.f.submisionfinal.data.repository.MatchRepository
import com.example.f.submisionfinal.databinding.FragmentViewBinding
import com.example.f.submisionfinal.util.CostumViewModelFactory
import com.example.f.submisionfinal.util.RxSearchView
import com.example.f.submisionfinal.view.base.BaseFragment
import com.example.f.submisionfinal.view.match.MatchViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_view.view.*

class FragmentNextMatch:BaseFragment<FragmentViewBinding,MatchViewModel>(){
    override fun setLayoutResource(): Int = R.layout.fragment_view

    var listLeague = listOf(
            "English Premiere League",
            "English League Championship",
            "German Bundesliga",
            "Italian Serie A",
            "French Ligue 1",
            "Spanish La Liga"
    )

    var idLeague = "4328"
    lateinit var x:Unit
    val rxSearchView = RxSearchView()

    override fun code() {

        viewModel = ViewModelProviders.of(this,CostumViewModelFactory(MatchRepository()))
                .get(MatchViewModel::class.java)


        mainDataBinding.setLifecycleOwner(this)
        mainDataBinding.itemBinding = viewModel
        mainDataBinding.handler = this

        mainDataBinding.recyclerViewFragment.layoutManager = LinearLayoutManager(viewBinding.context)

        val matchSpinnerAdapter = ArrayAdapter(context,android.R.layout.simple_spinner_item,listLeague)
        matchSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        viewBinding.matchSpinner.adapter = matchSpinnerAdapter
        viewBinding.matchSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                idLeague = "4328"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when(p2){
                    0->{
                        idLeague = "4328"
                        x = viewModel.getNextMatch(idLeague)
                    }
                    1->{
                        idLeague = "4329"
                        x = viewModel.getNextMatch(idLeague)
                    }
                    2->{
                        idLeague = "4331"
                        x = viewModel.getNextMatch(idLeague)
                    }
                    3->{
                        idLeague = "4332"
                        x = viewModel.getNextMatch(idLeague)
                    }
                    4->{
                        idLeague = "4334"
                        x = viewModel.getNextMatch(idLeague)
                    }
                    5->{
                        idLeague = "4335"
                        x = viewModel.getNextMatch(idLeague)
                    }
                }
            }
        }

        x = viewModel.getNextMatch(idLeague)
        viewBinding.nextMatchIcon.setColorFilter(resources.getColor(R.color.colorAccent))
        viewBinding.nextMatchTv.setTextColor(resources.getColor(R.color.colorAccent))

        viewBinding.lastMatchIcon.setColorFilter(resources.getColor(R.color.primary_dark_material_light))
        viewBinding.lastMatchTv.setTextColor(resources.getColor(R.color.primary_dark_material_light))

        x


        rxSearchView.getSearchView(viewBinding.searchMatch)

        val compositeDisposable = viewModel.matchRepository.matchRemoteData.compositeDisposable

        compositeDisposable.add(rxSearchView.getTextWatcherObservable()
                .debounce(500, java.util.concurrent.TimeUnit.MILLISECONDS) //delay input 500MS
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { searchText ->
                    if (searchText.isEmpty()) {
                        x = viewModel.getNextMatch(idLeague)
                    } else if (!searchText.isEmpty()) {
                        val query = searchText
                        x = viewModel.getEventByName(query)
                    }
                })
    }

    fun next(v: View){
        x = viewModel.getNextMatch(idLeague)
        viewBinding.nextMatchIcon.setColorFilter(resources.getColor(R.color.colorAccent))
        viewBinding.nextMatchTv.setTextColor(resources.getColor(R.color.colorAccent))

        viewBinding.lastMatchIcon.setColorFilter(resources.getColor(R.color.primary_dark_material_light))
        viewBinding.lastMatchTv.setTextColor(resources.getColor(R.color.primary_dark_material_light))
    }

    fun last(v: View){
        x = viewModel.getLastMatch(idLeague)
        viewBinding.lastMatchIcon.setColorFilter(resources.getColor(R.color.colorAccent))
        viewBinding.lastMatchTv.setTextColor(resources.getColor(R.color.colorAccent))

        viewBinding.nextMatchIcon.setColorFilter(resources.getColor(R.color.primary_dark_material_light))
        viewBinding.nextMatchTv.setTextColor(resources.getColor(R.color.primary_dark_material_light))
    }
}


