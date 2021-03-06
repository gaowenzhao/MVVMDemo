package com.zhao.base.http

import android.text.TextUtils
import android.util.Log
import com.zhao.base.http.bean.BaseBean
import com.zhao.base.utils.NetUtils
import io.reactivex.observers.DisposableObserver

abstract class BaseObs<T:Any> : DisposableObserver<BaseBean<T>>() {
    override fun onComplete() {
        Log.i("BaseObs","onComplete")
    }
    override fun onNext(t: BaseBean<T>){
        if(t.isSuccess()){
            onSuccess(t,t?.data)
        }else{
            onError(t)
        }
    }
    override fun onError(e: Throwable) {
        if (!NetUtils.isNetworkAvailable()) {
            onError(-9998, "网络失败")
        } else {
            var msg = e.message
            if (TextUtils.isEmpty(msg)) {
                msg = e.cause?.message
            }
            onError(-9999, msg!!)
        }
    }
    open fun onError(t: BaseBean<T>) {}
    open fun onError(code:Int,msg:String){}
    open fun onSuccess(t: BaseBean<T>,data:T?){onSuccess(data)}
    open fun onSuccess(data:T?){}
}