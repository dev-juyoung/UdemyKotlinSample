package com.dev_juyoung.udemykotlinsample.data.schme
import com.google.gson.annotations.SerializedName


/**
 * Created by juyounglee on 2018. 2. 13..
 */


data class FlickrPhotoInfoData(
		@SerializedName("photo") val photo: PhotoDetailInfo,
		@SerializedName("stat") val stat: String
)

data class PhotoDetailInfo(
		@SerializedName("id") val id: String,
		@SerializedName("secret") val secret: String,
		@SerializedName("server") val server: String,
		@SerializedName("farm") val farm: Int,
		@SerializedName("dateuploaded") val dateuploaded: String,
		@SerializedName("isfavorite") val isfavorite: Int,
		@SerializedName("license") val license: String,
		@SerializedName("safety_level") val safetyLevel: String,
		@SerializedName("rotation") val rotation: Int,
		@SerializedName("originalsecret") val originalsecret: String,
		@SerializedName("originalformat") val originalformat: String,
		@SerializedName("owner") val owner: Owner,
		@SerializedName("title") val title: Title,
		@SerializedName("description") val description: Description,
		@SerializedName("visibility") val visibility: Visibility,
		@SerializedName("dates") val dates: Dates,
		@SerializedName("views") val views: String,
		@SerializedName("editability") val editability: Editability,
		@SerializedName("publiceditability") val publiceditability: Publiceditability,
		@SerializedName("usage") val usage: Usage,
		@SerializedName("comments") val comments: Comments,
		@SerializedName("notes") val notes: Notes,
		@SerializedName("people") val people: People,
		@SerializedName("tags") val tags: Tags,
		@SerializedName("location") val location: Location,
		@SerializedName("geoperms") val geoperms: Geoperms,
		@SerializedName("urls") val urls: Urls,
		@SerializedName("media") val media: String
) {
    fun getPhotoURI() = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
}

data class Usage(
		@SerializedName("candownload") val candownload: Int,
		@SerializedName("canblog") val canblog: Int,
		@SerializedName("canprint") val canprint: Int,
		@SerializedName("canshare") val canshare: Int
)

data class Urls(
		@SerializedName("url") val url: List<Url>
)

data class Url(
		@SerializedName("type") val type: String,
		@SerializedName("_content") val content: String
)

data class Editability(
		@SerializedName("cancomment") val cancomment: Int,
		@SerializedName("canaddmeta") val canaddmeta: Int
)

data class Title(
		@SerializedName("_content") val content: String
)

data class Owner(
		@SerializedName("nsid") val nsid: String,
		@SerializedName("username") val username: String,
		@SerializedName("realname") val realname: String,
		@SerializedName("location") val location: String,
		@SerializedName("iconserver") val iconserver: String,
		@SerializedName("iconfarm") val iconfarm: Int,
		@SerializedName("path_alias") val pathAlias: String
) {
    fun getBuddyIcon() = "http://farm$iconfarm.staticflickr.com/$iconserver/buddyicons/$nsid.jpg"
}

data class Dates(
		@SerializedName("posted") val posted: String,
		@SerializedName("taken") val taken: String,
		@SerializedName("takengranularity") val takengranularity: String,
		@SerializedName("takenunknown") val takenunknown: String,
		@SerializedName("lastupdate") val lastupdate: String
)

data class Visibility(
		@SerializedName("ispublic") val ispublic: Int,
		@SerializedName("isfriend") val isfriend: Int,
		@SerializedName("isfamily") val isfamily: Int
)

data class Geoperms(
		@SerializedName("ispublic") val ispublic: Int,
		@SerializedName("iscontact") val iscontact: Int,
		@SerializedName("isfriend") val isfriend: Int,
		@SerializedName("isfamily") val isfamily: Int
)

data class Description(
		@SerializedName("_content") val content: String
)

data class Publiceditability(
		@SerializedName("cancomment") val cancomment: Int,
		@SerializedName("canaddmeta") val canaddmeta: Int
)

data class People(
		@SerializedName("haspeople") val haspeople: Int
)

data class Tags(
		@SerializedName("tag") val tag: List<Tag>
)

data class Tag(
		@SerializedName("id") val id: String,
		@SerializedName("author") val author: String,
		@SerializedName("authorname") val authorname: String,
		@SerializedName("raw") val raw: String,
		@SerializedName("_content") val content: String,
		@SerializedName("machine_tag") val machineTag: Int
)

data class Notes(
		@SerializedName("note") val note: List<Any>
)

data class Location(
		@SerializedName("latitude") val latitude: String,
		@SerializedName("longitude") val longitude: String,
		@SerializedName("accuracy") val accuracy: String,
		@SerializedName("context") val context: String,
		@SerializedName("locality") val locality: Locality,
		@SerializedName("region") val region: Region,
		@SerializedName("country") val country: Country,
		@SerializedName("place_id") val placeId: String,
		@SerializedName("woeid") val woeid: String
)

data class Region(
		@SerializedName("_content") val content: String,
		@SerializedName("place_id") val placeId: String,
		@SerializedName("woeid") val woeid: String
)

data class Country(
		@SerializedName("_content") val content: String,
		@SerializedName("place_id") val placeId: String,
		@SerializedName("woeid") val woeid: String
)

data class Locality(
		@SerializedName("_content") val content: String,
		@SerializedName("place_id") val placeId: String,
		@SerializedName("woeid") val woeid: String
)

data class Comments(
		@SerializedName("_content") val content: String
)