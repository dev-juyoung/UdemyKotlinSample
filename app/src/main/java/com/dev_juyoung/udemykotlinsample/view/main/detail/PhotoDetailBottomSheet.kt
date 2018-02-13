package com.dev_juyoung.udemykotlinsample.view.main.detail

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dev_juyoung.udemykotlinsample.R
import com.dev_juyoung.udemykotlinsample.data.source.flickr.FlickrRepository
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

    override fun dismissDueToError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        dismiss()
    }
}