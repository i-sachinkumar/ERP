package com.ihrsachin.apostle.preference

import android.content.Context

class StudentPreference(private val context : Context){

    // Encrypted by: https://www.devglan.com/online-tools/text-encryption-decryption
    private val sharedPreferences = context.getSharedPreferences("J6IDV8QfatqdYBwF1+gZrUjm1PhnO7dKS9M7NozS8Y0=", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun add(key : String, value: String){
        editor.putString(key, value).commit()
    }
    fun get(key: String) : String? {
        return sharedPreferences.getString(key, null)
    }
    fun update(key: String, newValue : String){
        editor.putString(key, newValue).commit()
    }
    fun contains(key: String) : Boolean{
        return sharedPreferences.contains(key)
    }
    fun clear(){
        sharedPreferences.edit().clear().apply()
    }
    fun remove(key: String){
        editor.remove(key).apply()
    }
}