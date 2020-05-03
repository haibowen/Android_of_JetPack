package com.haibowen.myjetpackdemo

import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.easypermissionx.hyploo.EasyPermissionX
import com.haibowen.myjetpackdemo.db.AppDatabase
import com.haibowen.myjetpackdemo.lifecycles.MyObserver2
import com.haibowen.myjetpackdemo.model.People
import com.haibowen.myjetpackdemo.model.SimpleWorker
import com.haibowen.myjetpackdemo.viewmodel.Main2ViewModel
import com.haibowen.myjetpackdemo.viewmodel.Main2ViewModelFactory
import kotlinx.android.synthetic.main.activity_main2.*
import kotlin.concurrent.thread

class Main2Activity : AppCompatActivity() {

    lateinit var viewModel: Main2ViewModel

    lateinit var sp: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        lifecycle.addObserver(MyObserver2())

        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)

        val personDao = AppDatabase.getDatabase(this).peopleDao()
        val person1 = People("Tom", "Brady", 20)
        val person2 = People("Tom", "Hanks", 27)


        //crud操作
        bt_add.setOnClickListener {
            thread {
                person1.id = personDao.insertPeople(person1)
                person2.id = personDao.insertPeople(person2)
            }
        }

        bt_update.setOnClickListener {
            thread {
                person1.age = 42
                personDao.updatePeople(person1)
            }
        }
        bt_delete.setOnClickListener {
            thread {
                personDao.deletePeopleByLastName("Hanks")

            }
        }
        bt_insert.setOnClickListener {
            thread {
                for (user in personDao.loadAllPeople()) {
                    Log.d("MainActivity", user.toString())
                }
            }


        }


        //crud 操作

        //旧版本的API已经被淘汰======》以下为新的API
        viewModel = ViewModelProvider(
            this,
            Main2ViewModelFactory(countReserved)
        )[Main2ViewModel::class.java]

        //加的按钮
        bt_show_second.setOnClickListener {
            viewModel.plusOne()
        }

        //清除的按钮
        bt_clean_second.setOnClickListener {
            viewModel.clear()
        }

        //worker
        bt_work.setOnClickListener {
            val request = OneTimeWorkRequest.Builder(
                SimpleWorker::class.java
            ).build()
            WorkManager.getInstance(this).enqueue(request)
        }

        //permission
        bt_permission.setOnClickListener {

            EasyPermissionX.request(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) { allGranted, deniedList ->
                if (allGranted) {

                } else {
                    Toast.makeText(this, "你拒绝了使用$deniedList" + "权限", Toast.LENGTH_SHORT).show()
                }
            }

        }

        viewModel.counter.observe(this, Observer { count ->
            tv_show_second.text = count.toString()
        })

        refreshCounter()

    }

    private fun refreshCounter() {
        tv_show_second.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter.value ?: 0)
        }
    }

}
