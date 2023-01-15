package com.ihrsachin.apostle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    companion object {
        init {
            System.loadLibrary("apostle")
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //realm initialization
        Realm.init(this)
    }
}