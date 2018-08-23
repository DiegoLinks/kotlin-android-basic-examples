package com.fourtime.kotlinexamples

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.fourtime.kotlinexamples.myLibrary.MyLibraryActivity
import com.fourtime.kotlinexamples.udacity.UdacityActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //[Cometário em Portugês] Pega o nome da view pelo id dado no XML, e usa o método senOnClick...

        //Get the name of the view by the id in XML, and use the senOnClick method
        bt_library.setOnClickListener(View.OnClickListener {

            //[Cometário em Portugês] Cria a intent, pega o context "this", nome da tela a ser aberta + ::class.java

            //Create the intent, get the context "this", name of activity to open + ::class.java
            val intent = Intent(this, MyLibraryActivity::class.java)
            startActivity(intent)

        })

        bt_udacity.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, UdacityActivity::class.java)
            startActivity(intent)

        })
    }

}
