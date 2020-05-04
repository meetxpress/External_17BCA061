package com.example.external_17bca061

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import androidx.annotation.UiThread

class DatabaseHelper(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, VERSION) {
    companion object{
        var DATABASE_NAME = "DB_Externals"
        var VERSION = 1
        var TB_NAME = "User_Master"
        var uId = "userId"
        var uName = "userName"
        var uEmail = "userEmail"
        var uMob = "userMob"
        var uPass = "userPassword"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var query="CREATE TABLE $TB_NAME($uId INTEGER PRIMARY KEY AUTOINCREMENT, $uName VARCHAR(20), $uEmail VARCHAR(50) WHERE $uEmail LIKE ('%@%.com'), $uMob VARCHAR(10), $uPass VARCHAR(15))"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var query="DROP TABLE IF EXISTS $TB_NAME"
        db!!.execSQL(query)
        onCreate(db)
    }

    fun registerUser(user_name:String, user_email:String, user_mob:String, user_pass:String): Boolean {
        var db=writableDatabase
        var cv= ContentValues()

        //cv.put(animal_id, aId)
        cv.put(uName, user_name)
        cv.put(uEmail, user_email)
        cv.put(uMob, user_mob)
        cv.put(uPass, user_pass)

        var a = db.insert(TB_NAME,null, cv)
        db.close()
        if(a > 0){
            return true
        }else{
            return false
        }
    }

    fun viewData(): ArrayList<ArrayDetails> {
        var db= readableDatabase
        var cor:Cursor = db.query(TB_NAME,null, null, null,null,null,null,null)
        var arrDD = ArrayList<ArrayDetails>()

        while (cor.moveToNext()) {
            var _user_id=cor.getInt(0)
            var _user_name = cor.getString(1)
            var _user_email = cor.getString(2)
            var _user_Mob = cor.getString(3)
            var p = ArrayDetails(_user_id, _user_name, _user_email, _user_Mob)
            arrDD.add(p)
        }
        return arrDD
    }
}