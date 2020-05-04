package com.example.external_17bca061

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        BtnLogin.setOnClickListener {
            if((LoginUsername.text.toString() == " ") && (LoginPassword.text.toString() == " ")){
                Toast.makeText(this@LoginActivity, "Required Fields are missing.", Toast.LENGTH_LONG).show()
            } else {
                var username = LoginUsername.text.toString()
                var password = LoginPassword.text.toString()

                var db=DatabaseHelper(this@LoginActivity)
                var flag=db.loginUser(username, password)

                if(flag){
                    startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                    Toast.makeText(this@LoginActivity, "Logged In Successfully.",Toast.LENGTH_SHORT).show()

                }else{
                    Toast.makeText(this@LoginActivity, "Invalid Username or Password.",Toast.LENGTH_SHORT).show()
                }

               /* if ((LoginUsername.text.toString() == "admin") && (LoginPassword.text.toString() == "admin")) {
                    startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                }*/
            }
        }

        RegisterLink.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
    }
}
