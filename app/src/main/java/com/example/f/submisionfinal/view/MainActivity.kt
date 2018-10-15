package com.example.f.submisionfinal.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.f.submisionfinal.R
import com.example.f.submisionfinal.view.match.fragment.FragmentFavoriteMatch
import com.example.f.submisionfinal.view.match.fragment.FragmentNextMatch
import com.example.f.submisionfinal.view.team.fragment.FragmentFavoriteTeam
import com.example.f.submisionfinal.view.team.fragment.FragmentTeam
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener {item ->
            when(item.itemId){
                R.id.matchMenu -> loadMatch()
                R.id.teamMenu -> loadTeam()
                R.id.favMatchMenu -> loadMatchFavorite()
                R.id.favTeamMenu -> loadTeamFavorite()
            }
            true
        }

        bottomNavigationView.selectedItemId = R.id.matchMenu
    }

    fun loadMatch(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameMain, FragmentNextMatch(), FragmentNextMatch::class.java.simpleName).commit()
    }

    fun loadTeam(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameMain, FragmentTeam(), FragmentTeam::class.java.simpleName).commit()
    }

    fun loadMatchFavorite(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameMain, FragmentFavoriteMatch(), FragmentFavoriteMatch::class.java.simpleName).commit()
    }

    fun loadTeamFavorite(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameMain, FragmentFavoriteTeam(), FragmentFavoriteTeam::class.java.simpleName).commit()
    }


}


