package com.example.f.submisionfinal.view.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

//TODO 1.a : buat base biar banyak yang tidak berulang kali dituliskan kodenya

abstract class BaseActivity<dB:ViewDataBinding,vM: BaseViewModel>:AppCompatActivity() {

    lateinit var mainDataBinding: dB
    lateinit var viewModel: vM

    abstract fun setLayoutResource():Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainDataBinding = DataBindingUtil.setContentView(this,setLayoutResource())

        code()
    }

    abstract fun code()
}
