package com.example.external_17bca061

class ArrayDetails (var anim_id:Int, var anim_name:String, var anim_qty:String, var anim_type:String) {
    override fun toString(): String {
        return "Id: $anim_id \t\t\t\t\t\t\tName: $anim_name \nQuantity: $anim_qty \t\tType: $anim_type"
    }
}