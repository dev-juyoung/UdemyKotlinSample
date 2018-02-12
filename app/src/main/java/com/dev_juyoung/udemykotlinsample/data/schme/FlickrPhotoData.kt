package com.dev_juyoung.udemykotlinsample.data.schme

/**
 * Created by juyounglee on 2018. 2. 12..
 */

data class FlickrPhotoData(
        val photos: Photos,
        val stat: String,
        val code: Int,
        val message: String
)

data class Photos(
        val page: Int,
        val pages: Int,
        val perpage: Int,
        val total: String,
        val photo: List<Photo>
)

data class Photo(
        val id: String,
        val owner: String,
        val secret: String,
        val server: String,
        val farm: Int,
        val title: String,
        val ispublic: Int,
        val isfriend: Int,
        val isfamliy: Int
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