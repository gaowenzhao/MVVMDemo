package com.zhao.home.bean

import androidx.databinding.BaseObservable


/**
 * gaowenzhao
 */
class PlatformadBean : BaseObservable(){
    lateinit var firstTitle:String
    lateinit var secondTitle:String
    lateinit var image:String
    lateinit var advertisings:List<BannerBean>
}