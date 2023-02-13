package com.ihrsachin.apostle.screens.homepage

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomePageViewModel : ViewModel(){

    // The current student's name
    private var _name = MutableLiveData<String>()
    val name : LiveData<String>
        get() = _name


    //profile pic Uri
    private var _profilePicUri = MutableLiveData<Uri>()
    val profilePicUri : LiveData<Uri>
        get() = _profilePicUri
}