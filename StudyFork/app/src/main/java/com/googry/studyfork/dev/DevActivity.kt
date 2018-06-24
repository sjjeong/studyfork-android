package com.googry.studyfork.dev

import android.content.Intent
import android.os.Bundle
import com.googry.studyfork.R
import com.googry.studyfork.base.ui.BaseActivity
import com.googry.studyfork.databinding.DevActivityBinding
import com.googry.studyfork.ui.main.MainActivity
import com.googry.studyfork.ui.mentor_list.MentorListActivity
import com.googry.studyfork.ui.profile.ProfileActivity

class DevActivity :
        BaseActivity<DevActivityBinding>(R.layout.dev_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.activity = this
        supportActionBar?.run {
            title = "DevActivity"
        }
    }

    fun onStartActivityClick(activityName: String) {
        startActivity(Intent(this,
                when (activityName) {
                    "MainActivity" -> MainActivity::class.java
                    "MentorListActivity" -> MentorListActivity::class.java
                    else -> error("Unknown Activity")
                }))
    }

}