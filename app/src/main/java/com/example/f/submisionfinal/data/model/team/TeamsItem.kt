package com.example.f.submisionfinal.data.model.team

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TeamsItem(

    var id:Long?,

	@field:SerializedName("idTeam")
	val idTeam: String? = null,

	@field:SerializedName("strTeam")
	val strTeam: String? = null,

	@field:SerializedName("strDescriptionEN")
	val strDescriptionEN: String? = null,

	@field:SerializedName("strWebsite")
	val strWebsite: String? = null,


	@field:SerializedName("intFormedYear")
	val intFormedYear:String? = null,

	@field:SerializedName("strTeamBadge")
	val strTeamBadge: String? = null


) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Long::class.java.classLoader) as? Long,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(idTeam)
        parcel.writeString(strTeam)
        parcel.writeString(strDescriptionEN)
        parcel.writeString(strWebsite)
        parcel.writeString(intFormedYear)
        parcel.writeString(strTeamBadge)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TeamsItem> {
        const val favorite = "favoriteTeam"

        const val ID = "id"
        const val ID_TEAM = "idTeam"
        const val TEAM = "team"
        const val DESC = "descriptionEN"
        const val WEBSITE = "website"
        const val FORMED_YEAR = "formedYear"
        const val BADGE = "badge"

        override fun createFromParcel(parcel: Parcel): TeamsItem {
            return TeamsItem(parcel)
        }

        override fun newArray(size: Int): Array<TeamsItem?> {
            return arrayOfNulls(size)
        }
    }

}