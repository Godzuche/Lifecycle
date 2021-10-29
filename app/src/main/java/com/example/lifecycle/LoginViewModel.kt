package com.example.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private var _loginStatus = MutableLiveData<Boolean>()

    val loginStatus: LiveData<Boolean>
    get() {
        return _loginStatus
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            delay(2000)
            if (password == "_Iam463")
                _loginStatus.postValue(true)
            else
                _loginStatus.postValue(false)
        }
    }
}