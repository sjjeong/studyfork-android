package com.googry.studyfork.ui.profile

import android.arch.lifecycle.MutableLiveData
import com.googry.studyfork.base.ui.BaseViewModel
import com.googry.studyfork.data.model.Profile
import com.googry.studyfork.data.source.ProfileDataSource

class ProfileViewModel(profileDataSource: ProfileDataSource,
                       val profile: Profile)
    : BaseViewModel(profileDataSource) {

    val liveProfile = MutableLiveData<Profile>()

    init {
        liveProfile.value = profile
    }
}