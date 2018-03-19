package com.dev_juyoung.udemykotlinsample.view.main.detail

import com.dev_juyoung.udemykotlinsample.data.schme.FlickrPhotoInfoData
import com.dev_juyoung.udemykotlinsample.data.source.flickr.FlickrDataSource
import com.dev_juyoung.udemykotlinsample.data.source.flickr.FlickrRepository

/**
 * Created by juyounglee on 2018. 2. 12..
 */
class PhotoDetailPresenter(
        val view: PhotoDetailContract.View,
        private val flickrRepository: FlickrRepository
) : PhotoDetailContract.Presenter {
    override fun loadPhotoInfo(photoId: String) {
        flickrRepository.getPhotoDetailInfo(photoId, object : FlickrDataSource.LoadFlickrCallback<FlickrPhotoInfoData> {
            override fun onSuccess(data: FlickrPhotoInfoData) {
                if (data.stat.contentEquals("ok")) {
                    data.photo.let {
                        view.updateToolbarItem(it.owner.getBuddyIcon(), it.owner.username)

                        view.updateItem(it.getPhotoURI())
                    }
                } else {
                    view.onError("Flickr API의 결과가 Failed.")
                }
            }

            override fun onFailure(message: String) {
                view.onError(message)
            }
        })
    }

    override fun loadPhotoURL() {
        val url = flickrRepository.cachedPhotoInfo?.photo?.urls?.url?.firstOrNull()?.content ?: ""
        view.showWebPage(url)
    }
}