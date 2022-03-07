package com.octopi.ecommerceapp.database

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.octopi.ecommerceapp.database.model.RegisterModel

class EcommerceViewModel: ViewModel() {

    val TAG = "em_lab"

    private val registerUserLiveData = MutableLiveData<Boolean>()
    val registerUserObserver get() = registerUserLiveData

    private val signInUserLiveData = MutableLiveData<Boolean>()
    val signInUserObserver get() = signInUserLiveData

    fun registerUser(context: Context,item: RegisterModel) {
        val dao = EcommerceDB.getDatabase(context)?.ecommerceDao()
        val x = dao?.addNewUser(item)
        registerUserLiveData.postValue(true)
        Log.d(TAG, "registerUser: callback: $x")
    }

    fun signInUser(context: Context,email: String, password: String) {
        val dao = EcommerceDB.getDatabase(context)?.ecommerceDao()
        val list = dao?.getUser(email,password)

        if (list.isNullOrEmpty()) {
            signInUserLiveData.postValue(false)
        }
        else signInUserLiveData.postValue(true)
    }
}