package com.example.f.submisionfinal.view.player

import android.arch.lifecycle.MutableLiveData
import com.example.f.submisionfinal.data.repository.PlayerRepository
import com.example.f.submisionfinal.view.base.BaseViewModel

class PlayerViewModel(val playerRepository: PlayerRepository):BaseViewModel() {
    var isFavorite:Boolean = false
    val loading: MutableLiveData<Boolean> = playerRepository.loading
    val rvVisibility: MutableLiveData<Boolean> = playerRepository.rvVisibility

//    override fun injector(componentDagger: ComponentDagger) {
//        componentDagger.inject(this)
//    }

    val adapter = playerRepository.adapter

    fun getPlayer(id: String){
        playerRepository.getPlayer(id)
    }

    fun getTeamPlayer(idTeam:String){
        playerRepository.getTeamPlayer(idTeam)
    }


    //    fun showFavorite(context: Context?) {
//        TeamLocalData(context!!).use {
//            val result = select(TeamsItem.favorite)
//            val fav = result.parseList(classParser<TeamsItem>())
//
//
//            matchAdapter.updateData(fav)
//
//            loading.value = false
//            rvVisibility.value = true
//
//            matchAdapter.notifyDataSetChanged()
//
//        }
//    }
//

//    //fungsi tambah ke db favorite
//    fun addToFav(db: TeamLocalData, context: Context?, extra: TeamsItem){
//
//        try{
//            db.use{
//                insert(TeamsItem.favorite,
//
//                        TeamsItem.ID_EVENT to extra.idEvent,
//                        TeamsItem.intHomeShots to extra.intHomeShots,
//                        TeamsItem.strHomeLineupDefense to extra.strHomeLineupDefense,
//                        TeamsItem.strAwayLineupSubstitutes to extra.strAwayLineupSubstitutes,
//                        TeamsItem.strHomeLineupForward to extra.strHomeLineupForward,
//                        TeamsItem.strHomeGoalDetails to extra.strHomeGoalDetails,
//                        TeamsItem.strAwayLineupGoalkeeper to extra.strAwayLineupGoalkeeper,
//                        TeamsItem.strAwayLineupMidfield to extra.strAwayLineupMidfield,
//                        TeamsItem.strHomeYellowCards to extra.strHomeYellowCards,
//                        TeamsItem.IDHOMETEAM to extra.idHomeTeam,
//                        TeamsItem.INTHOMESCORE to extra.intHomeScore,
//                        TeamsItem.dateEvent to extra.dateEvent,
//                        TeamsItem.STRAWAYTEAM to extra.strAwayTeam,
//                        TeamsItem.strHomeLineupMidfield to extra.strHomeLineupMidfield,
//                        TeamsItem.strHomeFormation to extra.strHomeFormation,
//                        TeamsItem.IDAWAYTEAM to extra.idAwayTeam,
//                        TeamsItem.strAwayRedCards to extra.strAwayRedCards,
//                        TeamsItem.intAwayShots to extra.intAwayShots,
//                        TeamsItem.strAwayGoalDetails to extra.strAwayGoalDetails,
//                        TeamsItem.strAwayLineupForward to extra.strAwayLineupForward,
//                        TeamsItem.strHomeRedCards to extra.strHomeRedCards,
//                        TeamsItem.strHomeLineupGoalkeeper to extra.strHomeLineupGoalkeeper,
//                        TeamsItem.strHomeLineupSubstitutes to extra.strHomeLineupSubstitutes,
//                        TeamsItem.strAwayFormation to extra.strAwayFormation,
//                        TeamsItem.strAwayYellowCards to extra.strAwayYellowCards,
//                        TeamsItem.strAwayLineupDefense to extra.strAwayLineupDefense,
//                        TeamsItem.STRHOMETEAM to extra.strHomeTeam,
//                        TeamsItem.INTAWAYSCORE to extra.intAwayScore
//                )
//                Toast.makeText(context?.applicationContext,"added to fav", Toast.LENGTH_SHORT).show()
//            }
//        } catch (e: SQLiteConstraintException){
//            Toast.makeText(context?.applicationContext,e.localizedMessage, Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    fun removeFromFav(db: TeamLocalData, context: Context?, extra: TeamsItem){
//        try {
//            db.use {
//                delete(TeamsItem.favorite,"(iE = {id})","id" to extra.idEvent!!)
//
//                Toast.makeText(context?.applicationContext,"remove from fav", Toast.LENGTH_SHORT).show()
//            }
//
//        }catch (e: SQLiteConstraintException){
//            Toast.makeText(context?.applicationContext,e.localizedMessage, Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    fun favoriteState(db: TeamLocalData, id:String?){
//        db.use {
//            val result = select(TeamsItem.favorite).whereArgs("(iE = {id})",
//                    "id" to id!!)
//            val fav = result.parseList(classParser<TeamsItem>())
//
//            if (fav.isNotEmpty()){
//                isFavorite = true
//            }
//
//        }
//    }

}