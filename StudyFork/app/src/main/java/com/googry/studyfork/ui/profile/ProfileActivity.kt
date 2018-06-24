package com.googry.studyfork.ui.profile

import com.googry.studyfork.base.ui.BaseFragmentBindingActivity
import com.googry.studyfork.data.model.Profile

class ProfileActivity : BaseFragmentBindingActivity() {
    override fun createFragment() = ProfileFragment.newInstance(intent.getParcelableExtra(EXTRA_PROFILE))

    companion object {
        const val EXTRA_PROFILE = "EXTRA_PROFILE"
    }
}