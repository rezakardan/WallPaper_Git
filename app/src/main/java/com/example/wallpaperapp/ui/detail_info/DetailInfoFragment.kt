package com.example.wallpaperapp.ui.detail_info


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.example.wallpaperapp.R
import com.example.wallpaperapp.databinding.FragmentDetailInfoBinding
import com.example.wallpaperapp.utils.loadImage
import com.example.wallpaperapp.utils.separating
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailInfoFragment : BottomSheetDialogFragment() {
    //Binding
    private var _binding: FragmentDetailInfoBinding? = null
    private val binding get() = _binding!!

    //Other
    private val args by navArgs<DetailInfoFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Args
        args.data.let { data ->
            //InitViews
            binding.apply {
                titleTxt.text = data.altDescription
                //Description
                if (data.description.isNullOrEmpty().not())
                    descriptionTxt.text = data.description
                else
                    descriptionTxt.isVisible = false
                //User
                data.user?.let { user ->
                    userNameTxt.text = user.name
                    userPhotosCountTxt.text = "${user.totalPhotos} ${getString(
                        R.string.photos)}"
                    user.profileImage?.large?.let { avatar ->
                        userAvatarImg.loadImage(avatar)
                    }
                }
                //Counts
                likesTxt.text = data.likes?.separating()
                viewsTxt.text = data.views?.separating()
                downloadsTxt.text = data.downloads?.separating()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}