package com.example.f.submisionfinal.data.model.match

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class EventsItem(
        var id:Long?,

    @SerializedName("idEvent")
	val idEvent: String?,

        @SerializedName("intHomeShots")
	val intHomeShots: String?,

        @SerializedName("strHomeLineupDefense")
	val strHomeLineupDefense: String?,

        @SerializedName("strAwayLineupSubstitutes")
	val strAwayLineupSubstitutes: String?,

        @SerializedName("strHomeLineupForward")
	val strHomeLineupForward: String?,

        @SerializedName("strHomeGoalDetails")
	val strHomeGoalDetails: String?,

        @SerializedName("strAwayLineupGoalkeeper")
	val strAwayLineupGoalkeeper: String?,

        @SerializedName("strAwayLineupMidfield")
	val strAwayLineupMidfield: String?,

        @SerializedName("strHomeYellowCards")
	val strHomeYellowCards: String?,

        @SerializedName("idHomeTeam")
	val idHomeTeam: String?,

        @SerializedName("intHomeScore")
	val intHomeScore: String?,

        @SerializedName("dateEvent")
	val dateEvent: String?,

        @SerializedName("strAwayTeam")
	val strAwayTeam: String?,

        @SerializedName("strHomeLineupMidfield")
	val strHomeLineupMidfield: String?,

        @SerializedName("strHomeFormation")
	val strHomeFormation: String?,

        @SerializedName("idAwayTeam")
	val idAwayTeam: String?,

        @SerializedName("strAwayRedCards")
	val strAwayRedCards: String?,

        @SerializedName("intAwayShots")
	val intAwayShots: String?,

        @SerializedName("strAwayGoalDetails")
	val strAwayGoalDetails: String?,

        @SerializedName("strAwayLineupForward")
	val strAwayLineupForward: String?,

        @SerializedName("strHomeRedCards")
	val strHomeRedCards: String?,

        @SerializedName("strHomeLineupGoalkeeper")
	val strHomeLineupGoalkeeper: String?,

        @SerializedName("strHomeLineupSubstitutes")
	val strHomeLineupSubstitutes: String?,

        @SerializedName("strAwayFormation")
	val strAwayFormation: String?,

        @SerializedName("strAwayYellowCards")
	val strAwayYellowCards: String?,

        @SerializedName("strAwayLineupDefense")
	val strAwayLineupDefense: String?,

        @SerializedName("strHomeTeam")
	val strHomeTeam: String?,

        @SerializedName("intAwayScore")
	val intAwayScore: String?

) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Long::class.java.classLoader) as? Long,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(idEvent)
        parcel.writeString(intHomeShots)
        parcel.writeString(strHomeLineupDefense)
        parcel.writeString(strAwayLineupSubstitutes)
        parcel.writeString(strHomeLineupForward)
        parcel.writeString(strHomeGoalDetails)
        parcel.writeString(strAwayLineupGoalkeeper)
        parcel.writeString(strAwayLineupMidfield)
        parcel.writeString(strHomeYellowCards)
        parcel.writeString(idHomeTeam)
        parcel.writeString(intHomeScore)
        parcel.writeString(dateEvent)
        parcel.writeString(strAwayTeam)
        parcel.writeString(strHomeLineupMidfield)
        parcel.writeString(strHomeFormation)
        parcel.writeString(idAwayTeam)
        parcel.writeString(strAwayRedCards)
        parcel.writeString(intAwayShots)
        parcel.writeString(strAwayGoalDetails)
        parcel.writeString(strAwayLineupForward)
        parcel.writeString(strHomeRedCards)
        parcel.writeString(strHomeLineupGoalkeeper)
        parcel.writeString(strHomeLineupSubstitutes)
        parcel.writeString(strAwayFormation)
        parcel.writeString(strAwayYellowCards)
        parcel.writeString(strAwayLineupDefense)
        parcel.writeString(strHomeTeam)
        parcel.writeString(intAwayScore)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EventsItem> {
        const val favorite = "fav"
        const val ID = "id"

        const val ID_EVENT = "iE"

        const val intHomeShots = "iHSh"

        const val strHomeLineupDefense = "sHLD"

        const val strAwayLineupSubstitutes = "sALS"

        const val strHomeLineupForward = "sHLF"

        const val strHomeGoalDetails = "sHGD"

        const val strAwayLineupGoalkeeper = "sALGK"

        const val strAwayLineupMidfield = "sALM"

        const val strHomeYellowCards = "sHYC"

        const val IDHOMETEAM = "iHT"

        const val INTHOMESCORE = "iHS"

        const val dateEvent = "dE"

        const val STRAWAYTEAM = "sAT"


        const val strHomeLineupMidfield = "sHLM"

        const val strHomeFormation = "sHF"

        const val IDAWAYTEAM = "iAT"

        const val strAwayRedCards = "sARC"

        const val intAwayShots = "iASh"

        const val strAwayGoalDetails = "sAGD"

        const val strAwayLineupForward = "sALF"

        const val strHomeRedCards = "sHRC"

        const val strHomeLineupGoalkeeper = "sHLGK"

        const val strHomeLineupSubstitutes = "sHLS"

        const val strAwayFormation = "sAF"

        const val strAwayYellowCards = "sAYC"

        const val strAwayLineupDefense = "sALD"

        const val STRHOMETEAM = "sHT"

        const val INTAWAYSCORE = "iAS"

        override fun createFromParcel(parcel: Parcel): EventsItem {
            return EventsItem(parcel)
        }

        override fun newArray(size: Int): Array<EventsItem?> {
            return arrayOfNulls(size)
        }
    }


}

