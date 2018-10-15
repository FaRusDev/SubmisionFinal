package com.example.f.submisionfinal.data.model.player

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PlayerItem(

        @field:SerializedName("idPlayer")
        val idPlayer: String? = null,

	@field:SerializedName("strPlayer")
	val strPlayer: String? = null,

	@field:SerializedName("strCutout")
	val strCutout: String? = null,

	@field:SerializedName("dateBorn")
	val dateBorn: String? = null,

	@field:SerializedName("strNationality")
	val strNationality: String? = null,

	@field:SerializedName("strWeight")
	val strWeight: String? = null,

        @field:SerializedName("strHeight")
        val strHeight: String? = null,

        @field:SerializedName("strPosition")
        val strPosition: String? = null,

        @field:SerializedName("strDescriptionEN")
        val strDescriptionEN: String? = null,


        @field:SerializedName("idTeam")
	val idTeam: String? = null,


	@field:SerializedName("strBirthLocation")
	val strBirthLocation: String? = null,


	@field:SerializedName("strTeam")
	val strTeam: String? = null,

	@field:SerializedName("dateSigned")
	val dateSigned: String? = null

) : Parcelable {
    constructor(parcel: Parcel) : this(
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
        parcel.writeString(idPlayer)
        parcel.writeString(strPlayer)
        parcel.writeString(strCutout)
        parcel.writeString(dateBorn)
        parcel.writeString(strNationality)
        parcel.writeString(strWeight)
        parcel.writeString(strHeight)
        parcel.writeString(strPosition)
        parcel.writeString(strDescriptionEN)
        parcel.writeString(idTeam)
        parcel.writeString(strBirthLocation)
        parcel.writeString(strTeam)
        parcel.writeString(dateSigned)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlayerItem> {
        override fun createFromParcel(parcel: Parcel): PlayerItem {
            return PlayerItem(parcel)
        }

        override fun newArray(size: Int): Array<PlayerItem?> {
            return arrayOfNulls(size)
        }
    }

}