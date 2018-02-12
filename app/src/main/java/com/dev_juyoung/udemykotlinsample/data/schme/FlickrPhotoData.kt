package com.dev_juyoung.udemykotlinsample.data.schme

import com.google.gson.annotations.SerializedName


/**
 * Created by juyounglee on 2018. 2. 12..
 */
data class FlickrPhotoData(
		@SerializedName("photos") val photos: Photos,
		@SerializedName("stat") val stat: String
)

data class Photos(
		@SerializedName("page") val page: Int,
		@SerializedName("pages") val pages: Int,
		@SerializedName("perpage") val perpage: Int,
		@SerializedName("total") val total: String,
		@SerializedName("photo") val photo: List<Photo>
)

data class Photo(
        @SerializedName("id") val id: String,
        @SerializedName("owner") val owner: String,
        @SerializedName("secret") val secret: String,
        @SerializedName("server") val server: String,
        @SerializedName("farm") val farm: Int,
        @SerializedName("title") val title: String,
        @SerializedName("ispublic") val ispublic: Int,
        @SerializedName("isfriend") val isfriend: Int,
        @SerializedName("isfamily") val isfamily: Int
) {
    /**
     * TODO: 아래의 규칙으로 이미지 URL 요청하여야 하며, 해당 샘플에서는 가장 기본 방법으로 요청함.
     * https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
     *      or
     * https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}_[mstzb].jpg
     *      or
     * https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{o-secret}_o.(jpg|gif|png)
     */
    fun getPhotoURI() = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"

    fun getTitleInfo(): String {
        if (title.isEmpty()) {
            return "Empty Photo Title"
        }

        return title
    }
}