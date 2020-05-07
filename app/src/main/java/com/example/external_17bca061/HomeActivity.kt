package com.example.external_17bca061

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnInsert.setOnClickListener {
            startActivity(Intent(this@HomeActivity, InsertActivity::class.java))
        }
/*-------17BCA061-------*/
        btnDisplay.setOnClickListener {
            startActivity(Intent(this@HomeActivity, DisplayActivity::class.java))
        }
        btnExit.setOnClickListener {
            finishAffinity()
            finish()
        }
    }
/*-------17BCA061-------*/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
/*-------17BCA061-------*/
        menuInflater.inflate(R.menu.logout_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.logout){
            var preference=getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            var edit=preference.edit()
/*-------17BCA061-------*/
            edit.clear()
            edit.commit()

            Toast.makeText(this@HomeActivity,"Logged out Successfully", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@HomeActivity,LoginActivity::class.java))
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
