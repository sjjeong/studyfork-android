package com.googry.studyfork.ui.profile

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import com.googry.studyfork.R
import com.googry.studyfork.base.ui.BaseFragment
import com.googry.studyfork.data.source.ProfileRepository
import com.googry.studyfork.databinding.ProfileFragmentBinding

class ProfileFragment :
        BaseFragment<ProfileFragmentBinding>(R.layout.profile_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            profileViewModel = ViewModelProviders.of(this@ProfileFragment, object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                        ProfileViewModel(ProfileRepository(FirebaseFirestore.getInstance())) as T
            })[ProfileViewModel::class.java]
        }

    }
}