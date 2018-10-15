package com.example.f.submisionfinal.data.model.match

import com.example.f.submisionfinal.data.model.match.EventsItem
import com.google.gson.annotations.SerializedName

data class Match(

		@SerializedName("events")
	val events: List<EventsItem?>? = null,

	@SerializedName("event")
	val event: List<EventsItem?>? = null

)