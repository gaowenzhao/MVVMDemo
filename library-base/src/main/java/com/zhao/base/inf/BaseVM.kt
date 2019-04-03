package com.zhao.base.inf

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

open class BaseVM : ViewModel(),BaseVMI{
    private var mCompositeSubscription: CompositeDisposable? = null
    /**
     * 事件订阅
     */
    override fun addSubscription(s: DisposableObserver<*>) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = CompositeDisposable()
        }
        mCompositeSubscription?.add(s)
    }

    override fun unsubcrible() {
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription!!.clear()
        }
        mCompositeSubscription = null
    }

}