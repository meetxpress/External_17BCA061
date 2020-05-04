package com.example.external_17bca061

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.logout_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.logout){
            var preference=getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            var edit=preference.edit()
            edit.clear()
            edit.commit()

            Toast.makeText(this@HomeActivity,"Logged out Successfully", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@HomeActivity,LoginActivity::class.java))
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
