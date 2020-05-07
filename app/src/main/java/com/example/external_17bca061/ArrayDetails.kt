package com.example.external_17bca061

class ArrayDetails (var c_id:Int, var c_name:String, var c_units:String, var c_price:String, var c_total:String) {
/*-------17BCA061-------*/
    override fun toString(): String {
        return "Customer Id: $c_id\t\t\t\t Name: $c_name\n" +
                "No of Units: $c_units \t\t\t\tPrice per units: $c_price\n" +
                "Total Amount: $c_total"
    }
}