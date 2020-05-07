package com.example.external_17bca061

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            var preference=getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            var str=preference.getString("uname","Wrong")
            if(str.equals("Wrong")){
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                finish()
/*-------17BCA061-------*/
            } else {
                startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                finish()
            }
        },1000)
    }
}
