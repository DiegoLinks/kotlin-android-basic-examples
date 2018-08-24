package com.fourtime.kotlinexamples.register

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.fourtime.kotlinexamples.R
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    val resCode = 123
    var picture = ""

    var name=""
    var email=""
    var age=""
    var phone=""
    var password=""
    var passwordConfirm=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Permission write storage (get image)
        checkPermission()

        //Set image default (placeholder) of ImageView
        ivPhoto.setImageResource(R.drawable.placeholder)

        //Validate fields and send data to next activity with Intent
        btRegister.setOnClickListener(View.OnClickListener {
            validationFields()
        })

        //Clear data EditText
        btClean.setOnClickListener(View.OnClickListener {
            clean()
        })

        //Get image of gallery
        ivPhoto.setOnClickListener(View.OnClickListener {
            getImage()
        })

        edName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                buttonValidation()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
        edEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                buttonValidation()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
        edAge.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                buttonValidation()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
        edPhone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                buttonValidation()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
        edPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                buttonValidation()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }

    fun getImage(){
        val photoIntent = Intent(Intent.ACTION_PICK)
        photoIntent.setType("image/*")
        startActivityForResult(photoIntent, resCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode==Activity.RESULT_OK){
            if(requestCode==resCode){
                val selectedImage = data!!.data
                val filePath = arrayOf(MediaStore.Images.Media.DATA)
                val cursor = contentResolver.query(selectedImage, filePath, null, null, null)
                cursor.moveToFirst()
                val index = cursor.getColumnIndex(filePath[0])
                picture = cursor.getString(index)
                cursor.close()
                ivPhoto.setImageBitmap(BitmapFactory.decodeFile(picture))
            }
        }
    }

    fun validationFields(){

        name = edName.text.toString()
        email = edEmail.text.toString()
        age = edAge.text.toString()
        phone = edPhone.text.toString()
        password = edPassword.text.toString()
        passwordConfirm = edConfirmPassword.text.toString()

        if (name.length>0 && email.length>0 && age.length>0 && phone.length>0 && password.length>0){

            if (password.equals(passwordConfirm)){
                send()
            } else {
                Toast.makeText(this, "The password dont match!", Toast.LENGTH_SHORT).show()
            }

        } else {
            Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
        }

    }

    fun buttonValidation() {
        if (edName.text.length>0 && edEmail.text.length>0 && edAge.text.length>0 && edPhone.text.length>0 && edPassword.text.length>0) {
            btRegister.setBackgroundResource(R.drawable.bt_enabled)
            btRegister.setTextColor(resources.getColor(R.color.white))
        } else {
            btRegister.setBackgroundResource(R.drawable.bt_style)
            btRegister.setTextColor(resources.getColor(R.color.black))
        }
    }

    fun send(){
        val intent = Intent (this, RegistredActivity::class.java)
        intent.putExtra("photo",picture)
        intent.putExtra("name", edName.text.toString())
        intent.putExtra("email", edEmail.text.toString())
        //Convert editText.text to Integer
        val age: Int? = edAge.text.toString().toIntOrNull()
        intent.putExtra("age", age)
        intent.putExtra("phone", edPhone.text.toString())
        startActivity(intent)
    }

    fun clean (){
        ivPhoto.setImageResource(R.drawable.placeholder)
        edName.text.clear()
        edEmail.text.clear()
        edAge.text.clear()
        edPhone.text.clear()
        edPassword.text.clear()
        edConfirmPassword.text.clear()
    }

    private fun checkPermission(){
        val permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE )
        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            android.Manifest.permission.READ_EXTERNAL_STORAGE)){
            } else {
                ActivityCompat.requestPermissions(this,
                        arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),3)
            }
        }
    }

}


