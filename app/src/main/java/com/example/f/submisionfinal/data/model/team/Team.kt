package com.example.f.submisionfinal.data.model.team

import com.google.gson.annotations.SerializedName

data class Team(

	@field:SerializedName("teams")
	val teams: List<TeamsItem?>? = null
)