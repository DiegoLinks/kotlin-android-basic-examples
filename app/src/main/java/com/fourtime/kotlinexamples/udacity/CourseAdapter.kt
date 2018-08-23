package com.fourtime.kotlinexamples.udacity

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.fourtime.kotlinexamples.R
import com.fourtime.kotlinexamples.udacity.models.Course
import kotlinx.android.synthetic.main.list_model_udacity.view.*

class CourseAdapter ( private val courses: List<Course>,
                      private val context: Context): Adapter<CourseAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(context).inflate(R.layout.list_model_udacity, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val c = courses[position]
        holder.bindView(c)
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindView(course: Course) {

            val title = itemView.tvTitle
            val image = itemView.ivImagem
            val subTitle = itemView.tvSubtitle
            val desc = itemView.tvDesc

            title.text = course.title
            Glide.with(itemView).load(course.image).into(image)
            subTitle.text = course.subtitle
            desc.text = course.expected_learning

        }

    }

}


