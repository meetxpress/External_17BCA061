package com.example.external_17bca061

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.btnInsert
import kotlinx.android.synthetic.main.activity_insert.*

class InsertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnInsert.setOnClickListener {
            if((InName.text.toString() == "") && (InUnits.text.toString() == "") && (InPrice.text.toString() == "")){
                Toast.makeText(this@InsertActivity, "Required Fields are missing.", Toast.LENGTH_LONG).show()
/*-------17BCA061-------*/
            } else{
                var name = InName.text.toString()
                var unit = InUnits.text.toString()
                var price = InPrice.text.toString()

                var db=DatabaseHelper(this@InsertActivity)
                var flag=db.insertDate(name, unit, price)

                if(flag){
                    Toast.makeText(this@InsertActivity, "Data Inserted Successfully.",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@InsertActivity, HomeActivity::class.java))
/*-------17BCA061-------*/
                }else{
                    Toast.makeText(this@InsertActivity, "Can't Insert!",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
