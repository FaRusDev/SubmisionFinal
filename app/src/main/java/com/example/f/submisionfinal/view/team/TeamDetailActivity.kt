package com.example.f.submisionfinal.view.team

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.f.submisionfinal.R
import com.example.f.submisionfinal.R.id.add_to_fav
import com.example.f.submisionfinal.data.model.team.TeamsItem
import com.example.f.submisionfinal.data.repository.TeamRepository
import com.example.f.submisionfinal.data.source.local.teamDatabases
import com.example.f.submisionfinal.databinding.ActivityDetailTeamBinding
import com.example.f.submisionfinal.util.CostumTeamViewModelFactory
import com.example.f.submisionfinal.util.EXTRA_TEAM
import com.example.f.submisionfinal.view.base.BaseActivity
import com.example.f.submisionfinal.view.player.PlayerActivity
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class TeamDetailActivity:BaseActivity<ActivityDetailTeamBinding,TeamViewModel>() {
    lateinit var extraTeam: TeamsItem

    override fun setLayoutResource(): Int = R.layout.activity_detail_team

    override fun code() {
        viewModel = ViewModelProviders.of(this, CostumTeamViewModelFactory(TeamRepository()))
                .get(TeamViewModel::class.java)

        extraTeam = intent.extras.getParcelable(EXTRA_TEAM)
        mainDataBinding.setLifecycleOwner(this)

        mainDataBinding.itemBinding = extraTeam
        mainDataBinding.handler = this

        supportActionBar?.title = "Detail Team"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        favState()

    }

    var menuItem: Menu? = null
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail_activity,menu)
        menuItem = menu
        setFavorite()
        return true
    }

    fun setFavorite(){
        if (viewModel.isFavorite){
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_has_added_to_fav)
        } else{
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_to_fav)
        }
    }

    fun favState(){

        val dbValue = teamDatabases.use {
            val idTeam = select(TeamsItem.favorite).whereArgs("idTeam = {id}","id" to extraTeam.idTeam!!)
            return@use idTeam.parseList(classParser<TeamsItem>())
        }

        if(dbValue.isNotEmpty()){
            if (dbValue.get(0).idTeam == extraTeam.idTeam){
                viewModel.favoriteState(teamDatabases,extraTeam.idTeam)
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        return when(item?.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            add_to_fav->{
                if (viewModel.isFavorite){
                    viewModel.removeFromFav(teamDatabases,this,extraTeam)
                    finish()
                }else{
                    viewModel.addToFav(teamDatabases,this,extraTeam)
                }

                viewModel.isFavorite = !viewModel.isFavorite
                setFavorite()

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun playerClick(v:View){
        val i = Intent(this,PlayerActivity::class.java)
        i.putExtra("player",extraTeam.idTeam)

        startActivity(i)
    }

}