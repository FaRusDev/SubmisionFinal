package com.example.f.submisionfinal.view.team

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.widget.Toast
import com.example.f.submisionfinal.data.model.league.League
import com.example.f.submisionfinal.data.model.team.TeamsItem
import com.example.f.submisionfinal.data.repository.TeamRepository
import com.example.f.submisionfinal.data.source.local.TeamLocalData
import com.example.f.submisionfinal.view.base.BaseViewModel
import org.jetbrains.anko.db.*

open class TeamViewModel(val teamRepository: TeamRepository): BaseViewModel() {
    var isFavorite:Boolean = false
    val loading: MutableLiveData<Boolean> = teamRepository.loading
    val rvVisibility: MutableLiveData<Boolean> = teamRepository.rvVisibility

//    override fun injector(componentDagger: ComponentDagger) {
//        componentDagger.inject(this)
//    }

    val adapter = teamRepository.adapter

    fun getTeam(id: String){
        teamRepository.getTeam(id)
    }

    fun getAllTeam(league: String){
        teamRepository.getAllTeam(league)
    }

    fun getTeamByName(name:String){
        teamRepository.getTeamByName(name)
    }

    fun showFavorite(context: Context?) {
        TeamLocalData(context!!).use {
            val result = select(TeamsItem.favorite)
            val fav = result.parseList(classParser<TeamsItem>())


            adapter.updateData(fav)

            loading.value = false
            rvVisibility.value = true

            adapter.notifyDataSetChanged()

        }
    }


    //fungsi tambah ke db favorite
    fun addToFav(db: TeamLocalData, context: Context?, extra: TeamsItem){

        try{
            db.use{
                insert(TeamsItem.favorite,

                        TeamsItem.ID_TEAM to extra.idTeam,
                        TeamsItem.TEAM to extra.strTeam,
                        TeamsItem.DESC to extra.strDescriptionEN,
                        TeamsItem.WEBSITE to extra.strWebsite,
                        TeamsItem.FORMED_YEAR to extra.intFormedYear,
                        TeamsItem.BADGE to extra.strTeamBadge
                )
                Toast.makeText(context?.applicationContext,"added to fav", Toast.LENGTH_SHORT).show()
            }
        } catch (e: SQLiteConstraintException){
            Toast.makeText(context?.applicationContext,e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    fun removeFromFav(db: TeamLocalData, context: Context?, extra: TeamsItem){
        try {
            db.use {
                delete(TeamsItem.favorite,"(idTeam = {id})","id" to extra.idTeam!!)

                Toast.makeText(context?.applicationContext,"remove from fav", Toast.LENGTH_SHORT).show()
            }

        }catch (e: SQLiteConstraintException){
            Toast.makeText(context?.applicationContext,e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    fun favoriteState(db: TeamLocalData, id:String?){
        db.use {
            val result = select(TeamsItem.favorite).whereArgs("(idTeam = {id})",
                    "id" to id!!)
            val fav = result.parseList(classParser<TeamsItem>())

            if (fav.isNotEmpty()){
                isFavorite = true
            }

        }
    }

    fun click():Unit{

    }

}