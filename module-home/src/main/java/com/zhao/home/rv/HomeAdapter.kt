package com.zhao.home.rv

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.hzcfapp.qmwallet.widget.recycler.VHType
import com.zhao.base.adapter.BaseMultiItemAdapter
import com.zhao.base.adapter.multityppe.MultiItemEntity
import com.zhao.home.rv.vh.AdverVH
import com.zhao.home.rv.vh.BannerVH

class HomeAdapter(datas: List<MultiItemEntity>) : BaseMultiItemAdapter<RecyclerView.ViewHolder>(datas) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VHType.BANNER.code -> {
                BannerVH(parent)
            }
            else -> {
                AdverVH(parent)
            }
        }
    }
}