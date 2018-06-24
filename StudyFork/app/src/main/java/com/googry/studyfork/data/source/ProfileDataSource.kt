package com.googry.studyfork.data.source

import com.googry.studyfork.base.source.BaseDataSource
import com.googry.studyfork.data.model.Profile

interface ProfileDataSource : BaseDataSource {

    fun getProfile(email: String, receiver: (Profile) -> Unit)

    fun getAllMentor(recevier: (List<Profile>) -> Unit)
}