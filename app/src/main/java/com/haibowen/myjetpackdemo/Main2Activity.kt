package com.haibowen.myjetpackdemo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.haibowen.myjetpackdemo.lifecycles.MyObserver2
import com.haibowen.myjetpackdemo.viewmodel.Main2ViewModel
import com.haibowen.myjetpackdemo.viewmodel.Main2ViewModelFactory
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    lateinit var viewModel: Main2ViewModel

    lateinit var sp:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        lifecycle.addObserver(MyObserver2())

        sp=getPreferences(Context.MODE_PRIVATE)
        val  countReserved=sp.getInt("count_reserved",0)




        //旧版本的API已经被淘汰======》以下为新的API
        viewModel = ViewModelProvider(this,Main2ViewModelFactory(countReserved))[Main2ViewModel::class.java]

        //加的按钮
        bt_show_second.setOnClickListener {
          viewModel.plusOne()
        }

        bt_clean_second.setOnClickListener {
            viewModel.clear()
        }

        viewModel.counter.observe(this, Observer {
            count->
            tv_show_second.text=count.toString()
        })

        refreshCounter()

    }

    private fun refreshCounter() {
        tv_show_second.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved",viewModel.counter.value?:0)
        }
    }

}
