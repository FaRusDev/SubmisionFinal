package com.example.f.submisionfinal.data.model.player

import com.google.gson.annotations.SerializedName

data class Player(

	@field:SerializedName("player")
	val player: List<PlayerItem?>? = null
)