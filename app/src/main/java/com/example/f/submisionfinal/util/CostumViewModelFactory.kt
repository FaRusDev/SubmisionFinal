package com.example.f.submisionfinal.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.f.submisionfinal.data.repository.MatchRepository
import com.example.f.submisionfinal.data.repository.PlayerRepository
import com.example.f.submisionfinal.data.repository.TeamRepository
import com.example.f.submisionfinal.view.match.MatchViewModel
import com.example.f.submisionfinal.view.player.PlayerViewModel
import com.example.f.submisionfinal.view.team.TeamViewModel

//class ini untuk menambahkan constructor di viewModel

class CostumViewModelFactory(
        private val costumConstructor: MatchRepository //atur tipe data apa yang mau dijadikan constructor
):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MatchViewModel(costumConstructor) as T
    }

}

class CostumTeamViewModelFactory(
        private val constructorTeam: TeamRepository //atur tipe data apa yang mau dijadikan constructor
):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TeamViewModel(constructorTeam) as T
    }

}

class CostumPlayerViewModelFactory(
        private val constructorPlayer: PlayerRepository //atur tipe data apa yang mau dijadikan constructor
):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlayerViewModel(constructorPlayer) as T
    }

}