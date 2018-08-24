package com.fourtime.kotlinexamples.register

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fourtime.kotlinexamples.R
import kotlinx.android.synthetic.main.activity_registred.*

class RegistredActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registred)

        //Obs: not ir necessary declare or binding views, (how observed in the RegisterActivity)
        //but if necessary renamed for example, this is the mode to make:
        val ivPhoto = ivPhoto
        val tvName = tvName
        val tvEmail = tvEmail
        val tvAge = tvAge
        val tvPhone = tvPhone

        ivPhoto.setImageBitmap(BitmapFactory.decodeFile(intent.getStringExtra("photo")))
        tvName.text = "Name: "+intent.getStringExtra("name")
        tvEmail.text = "Email: "+intent.getStringExtra("email")
        tvAge.text = "Age: "+intent.getIntExtra("age",0)+" years"
        tvPhone.text = "Phone Number: "+intent.getStringExtra("phone")
    }
}
