package com.dev_juyoung.udemykotlinsample.view.main.detail

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev_juyoung.udemykotlinsample.R
import com.dev_juyoung.udemykotlinsample.data.source.flickr.FlickrRepository
import com.dev_juyoung.udemykotlinsample.util.isInstalledApp
import com.dev_juyoung.udemykotlinsample.util.toast
import kotlinx.android.synthetic.main.dialog_photo_detail_info.*

/**
 * Created by juyounglee on 2018. 2. 12..
 */

class PhotoDetailBottomSheet : BottomSheetDialogFragment(), PhotoDetailContract.View {
    companion object {
        const val KEY_PHOTO_ID = "KEY_PHOTO_ID"

        fun create(photoId: String): PhotoDetailBottomSheet = PhotoDetailBottomSheet().apply {
            arguments = Bundle().apply {
                putString(KEY_PHOTO_ID, photoId)
            }
        }
    }

    private val presenter: PhotoDetailPresenter by lazy {
        PhotoDetailPresenter(this@PhotoDetailBottomSheet, FlickrRepository)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)

        dialog.setOnShowListener {
            val bottomSheet = dialog.findViewById<View>(android.support.design.R.id.design_bottom_sheet)
            BottomSheetBehavior.from(bottomSheet).apply {
                state = BottomSheetBehavior.STATE_EXPANDED
                peekHeight = 30
                setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                    override fun onSlide(bottomSheet: View, slideOffset: Float) {}

                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                            dismiss()
                        }
                    }
                })
            }
        }

        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.dialog_photo_detail_info, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageCloseButton.setOnClickListener {
            dismiss()
        }

        imageWeb.setOnClickListener {
            presenter.loadPhotoURL()
        }

        presenter.loadPhotoInfo(arguments.getString(KEY_PHOTO_ID))
    }

    override fun updateToolbarItem(ownerImageURL: String, ownerName: String) {
        imageBuddyIcon.load(ownerImageURL)
        textOwnerName.text = ownerName
    }

    override fun updateItem(photoURL: String) {
        imagePhoto.load(photoURL)
    }

    override fun onError(message: String) {
        context.toast(message)
        dismiss()
    }

    override fun showWebPage(url: String) {
        if (url.isEmpty()) {
            context.toast("요청할 URL이 비어 있음.")
            return
        }

        // Chrome Custom Tabs의 경우,
        // Chrome이 설치가 되어 있지 않으면 동작하지 않으므로, Chrome 설치여부를 확인한다.
        val chromeIsInstalled = (activity as AppCompatActivity).isInstalledApp("com.android.chrome")

        // Chrome이 설치 되어 있지 않다면, 외부 브라우저로 연결하도록 처리.
        if (!chromeIsInstalled) {
            val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(webIntent)
            return
        }

        CustomTabsIntent.Builder().apply {
            setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
        }.build().run {
            launchUrl(context, Uri.parse(url))
        }
    }
}