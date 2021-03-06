package com.zhao.home.model

import androidx.databinding.ObservableArrayList
import android.util.Log
import android.util.SparseArray
import androidx.databinding.BaseObservable
import com.zhao.base.adapter.multityppe.MultiItemEntity
import com.zhao.base.http.BaseObs
import com.zhao.base.http.Client
import com.zhao.base.http.bean.BaseBean
import com.zhao.base.model.BaseModel
import com.zhao.base.rx.SimplaObserver
import com.zhao.home.bean.AfficheBean
import com.zhao.home.bean.BidBean
import com.zhao.home.bean.HomeDataBean
import com.zhao.home.http.Client.api
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.internal.util.HalfSerializer.onNext
import java.util.function.Consumer

class HomeModel : BaseModel(){
    private val ANDROID = "3"
    fun getBanner(obs: BaseObs<Any>): BaseObs<Any> {
        return sub(api.getBannerList(), obs)
    }

   fun getHomeInfo(obs: BaseObs<HomeDataBean>): BaseObs<HomeDataBean> {
        return sub(api.getHomeInfo(mapOf("platform" to ANDROID)), obs)
    }
    fun getAffiche(obs: BaseObs<AfficheBean>): BaseObs<AfficheBean> {
        return sub(api.getAffiche(mapOf("platform" to ANDROID)), obs)
    }
    fun getBidList(obs: BaseObs<ArrayList<BidBean>>): BaseObs<ArrayList<BidBean>> {
        return sub(api.getbidList(mapOf("platform" to ANDROID)), obs)
    }
    fun getBottomText(obs: BaseObs<String>): BaseObs<String> {
        return sub(api.getBottomText(mapOf("platform" to ANDROID)), obs)
    }
    fun convertData(multiData: SparseArray<Any>, obs: SimplaObserver<ObservableArrayList<MultiItemEntity>>){
         sub(Observable.create { emitter ->
            Log.i("HomeModel", " 线程：+ ${Thread.currentThread().name}")
            val datas = ConvertDataUtil.convertData(multiData)
            emitter.onNext(datas)
        }, obs)
    }


}