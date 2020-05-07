package com.example.external_17bca061

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.openDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, VERSION) {
    companion object{
        var DATABASE_NAME = "DB_Externals"
        var VERSION = 1
        var TB_NAME = "Customer_Detail"
        var cId = "Cust_Id"
        var cName = "Cust_Name"
        var cunits = "No_Units"
        var cprice = "No_Mob"
        var total = "Total"
    }
/*-------17BCA061-------*/

    override fun onCreate(db: SQLiteDatabase?) {
        var query= "CREATE TABLE $TB_NAME($cId INTEGER PRIMARY KEY AUTOINCREMENT,$cName VARCHAR(20),$cunits INTEGER(3),$cprice INTEGER(3),$total INTEGER(4))"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var query = "DROP TABLE IF EXISTS $TB_NAME"
        db!!.execSQL(query)
        onCreate(db)
    }
/*-------17BCA061-------*/

    fun insertDate(name:String, unit:String, price:String):Boolean {
        var db=writableDatabase
        var cv=ContentValues()
        var t:Int = unit.toInt() * price.toInt()
        cv.put(cName,name)
        cv.put(cunits,unit)
        cv.put(cprice,price)
        cv.put(total, t)
        var flag=db.insert(TB_NAME,null,cv)
        db.close()
        if(flag>0){
            return true
        } else {
            return false
        }
    }
/*-------17BCA061-------*/

    fun viewAll():ArrayList<ArrayDetails> {
        var db=readableDatabase
        var cor:Cursor=db.query(TB_NAME, null, null, null, null, null, null)
        var arrAll=ArrayList<ArrayDetails>()
        while (cor.moveToNext()) {
            var c_id=cor.getInt(0)
            var c_name=cor.getString(1)
            var c_units=cor.getString(2)
            var c_price=cor.getString(3)
            var c_total=cor.getString(4)
            var a=ArrayDetails(c_id, c_name, c_units, c_price, c_total)
            arrAll.add(a)
        }
        return  arrAll
    }
/*-------17BCA061-------*/
}