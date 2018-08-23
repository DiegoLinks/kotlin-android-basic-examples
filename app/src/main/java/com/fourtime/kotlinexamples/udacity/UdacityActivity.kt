package com.fourtime.kotlinexamples.udacity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.fourtime.kotlinexamples.R
import com.fourtime.kotlinexamples.udacity.models.Course
import com.fourtime.kotlinexamples.udacity.models.CourseCatalog
import kotlinx.android.synthetic.main.activity_udacity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UdacityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_udacity)

        val progressBar: ProgressBar = this.progressBar
        progressBar.visibility = View.VISIBLE

        val call = RetrofitBuilder().apiInterface.list()
        call.enqueue(object: Callback<CourseCatalog> {
            override fun onResponse(call: Call<CourseCatalog>, response: Response<CourseCatalog>) {

                if(response.isSuccessful){
                        response?.body()?.let {
                            val catalog: CourseCatalog = it
                            configureList(catalog.courses)
                            configureHorizontalList(catalog.courses)
                         progressBar.visibility = View.GONE
                    }
                } else {
                    Log.i("onResponse","Error: "+response.code())
                }
            }

            override fun onFailure(call: Call<CourseCatalog>, t: Throwable?) {

                Log.e("onFailure error", t?.message)

            }
        })

        //Alternative form

//        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
//            Log.e("onFailure error", throwable.message)
//        }
//
//        launch(UI + exceptionHandler) {
//            val deferredCatalog: Deferred<CourseCatalog> = RetrofitBuilder().apiInterfaceee().list()
//
//            deferredCatalog.await().apply {
//                configureList(courses)
//                configureHorizontalList(courses)
//                progressBar.visibility = View.GONE
//            }
//        }
    }

    private fun configureList(catalog: List<Course>) {
        val recyclerView = recyclerview2
        recyclerView.adapter = CourseAdapter(catalog, this)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }

    private fun configureHorizontalList(catalog: List<Course>) {
        val recyclerView = recyclerviewHorizontal
        recyclerView.adapter = CourseAdapterHorizontal(catalog, this)
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        recyclerView.layoutManager = layoutManager
    }

}
