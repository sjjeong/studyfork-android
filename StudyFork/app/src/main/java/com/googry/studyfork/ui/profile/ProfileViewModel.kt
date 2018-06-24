package com.googry.studyfork.ui.profile

import android.arch.lifecycle.MutableLiveData
import com.googry.studyfork.base.ui.BaseViewModel
import com.googry.studyfork.data.model.Profile
import com.googry.studyfork.data.source.ProfileDataSource

class ProfileViewModel(profileDataSource: ProfileDataSource)
    : BaseViewModel(profileDataSource) {

    val profile = MutableLiveData<Profile>()

    init {
        profileDataSource.getProfile(email = "sjjeong1225@gmai.com") {
            profile.postValue(it)
        }
    }
}