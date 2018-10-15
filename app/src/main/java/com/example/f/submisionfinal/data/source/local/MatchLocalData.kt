package com.example.f.submisionfinal.data.source.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.f.submisionfinal.data.model.match.EventsItem
import org.jetbrains.anko.db.*

class MatchLocalData(context: Context) :
        ManagedSQLiteOpenHelper(context,"EventsItem.db",null,1){

        companion object {
            private var instance: MatchLocalData? = null

            @Synchronized
            fun getInstance(ctx:Context): MatchLocalData {
                if (instance == null){
                    instance = MatchLocalData(ctx.applicationContext)
                }
                return instance as MatchLocalData
            }
        }

        override fun onCreate(db: SQLiteDatabase) {
            db.createTable(EventsItem.favorite,true,
                    EventsItem.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,

                    EventsItem.ID_EVENT to TEXT + UNIQUE,
                    EventsItem.intHomeShots to TEXT,
                    EventsItem.strHomeLineupDefense to TEXT,
                    EventsItem.strAwayLineupSubstitutes to TEXT,
                    EventsItem.strHomeLineupForward to TEXT,
                    EventsItem.strHomeGoalDetails to TEXT,
                    EventsItem.strAwayLineupGoalkeeper to TEXT,
                    EventsItem.strAwayLineupMidfield to TEXT,
                    EventsItem.strHomeYellowCards to TEXT,
                    EventsItem.IDHOMETEAM to TEXT,
                    EventsItem.INTHOMESCORE to TEXT,
                    EventsItem.dateEvent to TEXT,
                    EventsItem.STRAWAYTEAM to TEXT,
                    EventsItem.strHomeLineupMidfield to TEXT,
                    EventsItem.strHomeFormation to TEXT,
                    EventsItem.IDAWAYTEAM to TEXT,
                    EventsItem.strAwayRedCards to TEXT,
                    EventsItem.intAwayShots to TEXT,
                    EventsItem.strAwayGoalDetails to TEXT,
                    EventsItem.strAwayLineupForward to TEXT,
                    EventsItem.strHomeRedCards to TEXT,
                    EventsItem.strHomeLineupGoalkeeper to TEXT,
                    EventsItem.strHomeLineupSubstitutes to TEXT,
                    EventsItem.strAwayFormation to TEXT,
                    EventsItem.strAwayYellowCards to TEXT,
                    EventsItem.strAwayLineupDefense to TEXT,
                    EventsItem.STRHOMETEAM to TEXT,
                    EventsItem.INTAWAYSCORE to TEXT
            )
        }

        override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
            db.dropTable(EventsItem.favorite,true)
        }
    }

    val Context.matchDatabase: MatchLocalData
        get() = MatchLocalData.getInstance(applicationContext)
