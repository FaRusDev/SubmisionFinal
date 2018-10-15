package com.example.f.submisionfinal.view.match

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import com.example.f.submisionfinal.R
import com.example.f.submisionfinal.R.id.add_to_fav
import com.example.f.submisionfinal.R.menu.menu_detail_activity
import com.example.f.submisionfinal.data.model.match.EventsItem
import com.example.f.submisionfinal.data.repository.MatchRepository
import com.example.f.submisionfinal.data.source.local.matchDatabase
import com.example.f.submisionfinal.databinding.ActivityDetailMatchesBinding
import com.example.f.submisionfinal.util.CostumViewModelFactory
import com.example.f.submisionfinal.util.EXTRA_MATCH
import com.example.f.submisionfinal.view.base.BaseActivity
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class MatchDetailActivity:BaseActivity<ActivityDetailMatchesBinding,MatchViewModel>() {

    lateinit var extraMatch:EventsItem

    override fun setLayoutResource(): Int = R.layout.activity_detail_matches

    override fun code() {
        viewModel = ViewModelProviders.of(this,CostumViewModelFactory(MatchRepository()))
                .get(MatchViewModel::class.java)

        extraMatch = intent.extras.getParcelable(EXTRA_MATCH)
        mainDataBinding.setLifecycleOwner(this)

        mainDataBinding.xmlDetail = extraMatch

        supportActionBar?.title = "Detail Match"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        favState()
    }

    var menuItem:Menu? = null


    fun setFavorite(){
        if (viewModel.isFavorite){
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this,R.drawable.ic_has_added_to_fav)
        } else{
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this,R.drawable.ic_add_to_fav)
        }
    }

    fun favState(){

        val dbValue = matchDatabase.use {
            val idEvent = select(EventsItem.favorite).whereArgs("iE = {id}","id" to extraMatch.idEvent!!)
            return@use idEvent.parseList(classParser<EventsItem>())
        }

        if(dbValue.isNotEmpty()){
            if (dbValue.get(0).idEvent == extraMatch.idEvent){
                viewModel.favoriteState(matchDatabase,extraMatch.idEvent)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(menu_detail_activity,menu)
        menuItem = menu
        setFavorite()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        return when(item?.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            add_to_fav->{
                if (viewModel.isFavorite){
                    viewModel.removeFromFav(matchDatabase,this,extraMatch)
                    finish()
                }else{
                    viewModel.addToFav(matchDatabase,this,extraMatch)
                }

                viewModel.isFavorite = !viewModel.isFavorite
                setFavorite()

                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

}