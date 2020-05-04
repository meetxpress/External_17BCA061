package com.example.external_17bca061

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        BtnRegister.setOnClickListener {
            if((RegName.text.toString() == " ") && (RegEmail.text.toString() == " ") && (RegMobNo.text.toString() == " ") && (RegPassword.text.toString() == " ")){
                Toast.makeText(this@RegisterActivity, "Required Fields are missing.", Toast.LENGTH_LONG).show()
            } else {
                var user_name = RegName.text.toString()
                var user_email = RegEmail.text.toString()
                var user_mob = RegMobNo.text.toString()
                var user_pass = RegPassword.text.toString()

                var db=DatabaseHelper(this@RegisterActivity)
                var flag=db.registerUser(user_name, user_email, user_mob, user_pass)

                if(flag){
                    Toast.makeText(this, "User Registered Successfully.",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Can't Register User.",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
