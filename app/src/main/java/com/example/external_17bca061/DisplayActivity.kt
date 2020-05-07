package com.example.external_17bca061

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var db = DatabaseHelper(this@DisplayActivity)
        var arr = db.viewAll()
/*-------17BCA061-------*/
        var ada = ArrayAdapter<ArrayDetails>(this@DisplayActivity, android.R.layout.simple_list_item_1, arr)
        listDisplay.adapter = ada
    }
}
