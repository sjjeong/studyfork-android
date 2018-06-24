package com.googry.studyfork.ui.mentor_list

import android.arch.lifecycle.MutableLiveData
import com.googry.studyfork.base.ui.BaseViewModel
import com.googry.studyfork.data.model.Profile
import com.googry.studyfork.data.source.ProfileDataSource

class MentorListViewModel(profileDataSource: ProfileDataSource): BaseViewModel() {

    val mentors = MutableLiveData<List<Profile>>()

    init {
        profileDataSource.getAllMentor {
            mentors.postValue(it)
        }
    }
}