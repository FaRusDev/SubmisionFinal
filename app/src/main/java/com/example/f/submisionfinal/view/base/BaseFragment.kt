package com.example.f.submisionfinal.view.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

//TODO 1.b : buat base biar banyak yang tidak berulang kali dituliskan kodenya
abstract class BaseFragment<dB:ViewDataBinding,vM: BaseViewModel>:Fragment() {

    protected lateinit var viewBinding:View
    protected lateinit var mainDataBinding:dB
    protected lateinit var viewModel:vM

    //untuk ambil layoutresource
    abstract fun setLayoutResource():Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        mainDataBinding = DataBindingUtil.inflate(inflater,setLayoutResource(),container,false)
        viewBinding = mainDataBinding.root

        code()

        return viewBinding
    }

    abstract fun code()
}