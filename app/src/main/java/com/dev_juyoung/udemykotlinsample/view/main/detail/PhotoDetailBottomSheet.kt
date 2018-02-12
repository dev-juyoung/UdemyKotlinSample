package com.dev_juyoung.udemykotlinsample.view.main.detail

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev_juyoung.udemykotlinsample.R
import kotlinx.android.synthetic.main.dialog_photo_detail.*

/**
 * Created by juyounglee on 2018. 2. 12..
 */

class PhotoDetailBottomSheet : BottomSheetDialogFragment() {
    companion object {
        const val KEY_PHOTO_ID = "KEY_PHOTO_ID"

        fun create(photoId: String): PhotoDetailBottomSheet = PhotoDetailBottomSheet().apply {
            arguments = Bundle().apply {
                putString(KEY_PHOTO_ID, photoId)
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener {
            val bottomSheet = dialog.findViewById<View>(android.support.design.R.id.design_bottom_sheet)
            BottomSheetBehavior.from(bottomSheet).apply {
                state = BottomSheetBehavior.STATE_EXPANDED
                peekHeight = 30
                setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                    override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    }

                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        when (newState) {
                            BottomSheetBehavior.STATE_COLLAPSED -> {
                                if (!isRemoving) dismiss()
                            }
                            else -> {

                            }
                        }
                    }
                })
            }
        }

        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            View.inflate(context, R.layout.dialog_photo_detail, null)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        photoDetailView.setOnClickListener {
//            dismiss()
//        }

        photoIdTextView.text = arguments.getString(KEY_PHOTO_ID)
    }
}