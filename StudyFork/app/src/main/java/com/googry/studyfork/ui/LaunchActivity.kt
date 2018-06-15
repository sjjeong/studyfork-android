package com.googry.studyfork.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.googry.studyfork.BuildConfig
import com.googry.studyfork.dev.DevActivity
import com.googry.studyfork.ui.main.MainActivity

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this,
                if (BuildConfig.DEBUG) DevActivity::class.java else MainActivity::class.java))
        finish()
    }
}
