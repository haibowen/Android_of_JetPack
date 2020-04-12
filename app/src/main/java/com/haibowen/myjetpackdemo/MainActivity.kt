package com.haibowen.myjetpackdemo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProviders
import com.haibowen.myjetpackdemo.lifecycles.Myobserver
import com.haibowen.myjetpackdemo.viewmodel.MainViewModel
import com.haibowen.myjetpackdemo.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(Myobserver(lifecycle))

        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reversed", 0)
        viewModel = ViewModelProviders.of(
            this,
            MainViewModelFactory(
                countReserved
            )
        ).get(MainViewModel::class.java)


        bt_clear.setOnClickListener {
            viewModel.count = 0
            refreshCounter()
        }
        refreshCounter()

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        bt_show.setOnClickListener {
            viewModel.count++

            refreshCounter()
        }
        refreshCounter()


    }

    private fun refreshCounter() {
        tv_show.text =
            viewModel.count.toString() + "#####" + "当前activity的状态" + lifecycle.currentState
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reversed", viewModel.count)
        }


    }
}
