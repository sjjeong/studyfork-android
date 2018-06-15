package com.googry.studyfork.base.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.googry.studyfork.base.source.BaseDataSource
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(application: Application,
                             var baseDataSource: BaseDataSource? = null) :
        AndroidViewModel(application) {
    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.clear()
        baseDataSource?.onCleared()
        super.onCleared()
    }
}