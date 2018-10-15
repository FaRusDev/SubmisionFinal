package com.example.f.submisionfinal.view.match

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.widget.Toast
import com.example.f.submisionfinal.data.model.match.EventsItem
import com.example.f.submisionfinal.data.repository.MatchRepository
import com.example.f.submisionfinal.data.source.local.MatchLocalData
import com.example.f.submisionfinal.util.netConfig.ConnectToInetLib
import com.example.f.submisionfinal.view.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select


    open class MatchViewModel(val matchRepository: MatchRepository): BaseViewModel() {

        var isFavorite:Boolean = false
        val loading: MutableLiveData<Boolean> = matchRepository.loading
        val rvVisibility: MutableLiveData<Boolean> = matchRepository.rvVisibility

//    override fun injector(componentDagger: ComponentDagger) {
//        componentDagger.inject(this)
//    }

        val matchAdapter = matchRepository.adapter

        fun getNextMatch(id:String){
            matchRepository.getNextMatch(id)
        }

        fun getLastMatch(id: String){
            matchRepository.getLastMatch(id)
        }


        fun showFavorite(context: Context?) {
            MatchLocalData(context!!).use {
                val result = select(EventsItem.favorite)
                val fav = result.parseList(classParser<EventsItem>())


                matchAdapter.updateData(fav)

                loading.value = false
                rvVisibility.value = true

                matchAdapter.notifyDataSetChanged()

            }
        }


        //fungsi tambah ke db favorite
        fun addToFav(db:MatchLocalData,context: Context?,extra:EventsItem){

            try{
                db.use{
                    insert(EventsItem.favorite,

                            EventsItem.ID_EVENT to extra.idEvent,
                            EventsItem.intHomeShots to extra.intHomeShots,
                            EventsItem.strHomeLineupDefense to extra.strHomeLineupDefense,
                            EventsItem.strAwayLineupSubstitutes to extra.strAwayLineupSubstitutes,
                            EventsItem.strHomeLineupForward to extra.strHomeLineupForward,
                            EventsItem.strHomeGoalDetails to extra.strHomeGoalDetails,
                            EventsItem.strAwayLineupGoalkeeper to extra.strAwayLineupGoalkeeper,
                            EventsItem.strAwayLineupMidfield to extra.strAwayLineupMidfield,
                            EventsItem.strHomeYellowCards to extra.strHomeYellowCards,
                            EventsItem.IDHOMETEAM to extra.idHomeTeam,
                            EventsItem.INTHOMESCORE to extra.intHomeScore,
                            EventsItem.dateEvent to extra.dateEvent,
                            EventsItem.STRAWAYTEAM to extra.strAwayTeam,
                            EventsItem.strHomeLineupMidfield to extra.strHomeLineupMidfield,
                            EventsItem.strHomeFormation to extra.strHomeFormation,
                            EventsItem.IDAWAYTEAM to extra.idAwayTeam,
                            EventsItem.strAwayRedCards to extra.strAwayRedCards,
                            EventsItem.intAwayShots to extra.intAwayShots,
                            EventsItem.strAwayGoalDetails to extra.strAwayGoalDetails,
                            EventsItem.strAwayLineupForward to extra.strAwayLineupForward,
                            EventsItem.strHomeRedCards to extra.strHomeRedCards,
                            EventsItem.strHomeLineupGoalkeeper to extra.strHomeLineupGoalkeeper,
                            EventsItem.strHomeLineupSubstitutes to extra.strHomeLineupSubstitutes,
                            EventsItem.strAwayFormation to extra.strAwayFormation,
                            EventsItem.strAwayYellowCards to extra.strAwayYellowCards,
                            EventsItem.strAwayLineupDefense to extra.strAwayLineupDefense,
                            EventsItem.STRHOMETEAM to extra.strHomeTeam,
                            EventsItem.INTAWAYSCORE to extra.intAwayScore
                    )
                    Toast.makeText(context?.applicationContext,"added to fav", Toast.LENGTH_SHORT).show()
                }
            } catch (e: SQLiteConstraintException){
                Toast.makeText(context?.applicationContext,e.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }

        fun removeFromFav(db: MatchLocalData,context: Context?,extra:EventsItem){
            try {
                db.use {
                    delete(EventsItem.favorite,"(iE = {id})","id" to extra.idEvent!!)

                    Toast.makeText(context?.applicationContext,"remove from fav", Toast.LENGTH_SHORT).show()
                }

            }catch (e: SQLiteConstraintException){
                Toast.makeText(context?.applicationContext,e.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }

        fun favoriteState(db: MatchLocalData,id:String?){
            db.use {
                val result = select(EventsItem.favorite).whereArgs("(iE = {id})",
                        "id" to id!!)
                val fav = result.parseList(classParser<EventsItem>())

                if (fav.isNotEmpty()){
                    isFavorite = true
                }

            }
        }

        fun getEventByName(name:String){
            matchRepository.getEventByName(name)
        }
    }




