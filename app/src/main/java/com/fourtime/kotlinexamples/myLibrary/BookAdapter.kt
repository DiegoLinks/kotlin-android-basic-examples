package com.fourtime.kotlinexamples.myLibrary

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.fourtime.kotlinexamples.R
import kotlinx.android.synthetic.main.list_model_books.view.*

class BookAdapter  (private val books: List<Book>,
                    private val context: Context): Adapter<BookAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_model_books, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = books[position]
        holder?.let {
            it.bindView(note)
        }
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindView(book: Book) {

            //val name = itemView.tv_text_view
            val title = itemView.tv_title
            val author = itemView.tv_author
            val year = itemView.tv_year
            val image = itemView.iv_book

            //TextView.text = model.nomeVariavel
            title.text = book.title
            author.text = book.author
            year.text = book.year
            Glide.with(itemView).load(book.image_url).into(image)
        }
    }
}

