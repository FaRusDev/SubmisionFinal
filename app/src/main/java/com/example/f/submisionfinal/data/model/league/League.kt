package com.example.f.submisionfinal.data.model.league

import com.example.f.submisionfinal.data.model.league.LeaguesItem
import com.google.gson.annotations.SerializedName

data class League(

	@field:SerializedName("leagues")
	val leagues: List<LeaguesItem?>? = null
)