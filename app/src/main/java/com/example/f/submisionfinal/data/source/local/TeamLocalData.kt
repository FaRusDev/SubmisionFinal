package com.example.f.submisionfinal.data.source.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.f.submisionfinal.data.model.team.TeamsItem
import org.jetbrains.anko.db.*

class TeamLocalData(context: Context) :
        ManagedSQLiteOpenHelper(context,"TeamsItem.db",null,1){

    companion object {
        private var instance: TeamLocalData? = null

        @Synchronized
        fun getInstance(ctx: Context): TeamLocalData {
            if (instance == null){
                instance = TeamLocalData(ctx.applicationContext)
            }
            return instance as TeamLocalData
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(TeamsItem.favorite,true,
                TeamsItem.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,

                TeamsItem.ID_TEAM to TEXT + UNIQUE,
                TeamsItem.TEAM to TEXT,
                TeamsItem.DESC to TEXT,
                TeamsItem.WEBSITE to TEXT,
                TeamsItem.FORMED_YEAR to TEXT,
                TeamsItem.BADGE to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.dropTable(TeamsItem.favorite,true)
    }
}

val Context.teamDatabases: TeamLocalData
    get() = TeamLocalData.getInstance(applicationContext)
