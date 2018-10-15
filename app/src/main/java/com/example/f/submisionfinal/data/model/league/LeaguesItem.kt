package com.example.f.submisionfinal.data.model.league

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class LeaguesItem(
		@SerializedName("idLeague")
		val idLeague: String? = null,

		@SerializedName("strLeague")
		val strLeague: String? = null,

		@SerializedName("strLeagueAlternate")
		val strLeagueAlternate: String? = null,

		@SerializedName("strSport")
		val strSport: String? = null


) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readString(),
			parcel.readString(),
			parcel.readString(),
			parcel.readString()) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(idLeague)
		parcel.writeString(strLeague)
		parcel.writeString(strLeagueAlternate)
		parcel.writeString(strSport)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<LeaguesItem> {
		override fun createFromParcel(parcel: Parcel): LeaguesItem {
			return LeaguesItem(parcel)
		}

		override fun newArray(size: Int): Array<LeaguesItem?> {
			return arrayOfNulls(size)
		}
	}
}