package com.example.android.devbyteviewer.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.android.devbyteviewer.database.getDatabase
import com.example.android.devbyteviewer.repository.VideosRepository
import kotlinx.coroutines.*
import java.io.IOException

class DevByteViewModel(application: Application) : AndroidViewModel(application) {

    //ViewModel นี้จะดึงข้อมูลจาก VideosRepository
    private val videosRepository = VideosRepository(getDatabase(application))

    // รายการของวีดีโอ
    val playlist = videosRepository.videos

    // เทื่อเกิด networkerror
    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    // ถ้า error view ควรใช้สิ่งนี้เพื่อเข้าถึงข้อมูล
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    // ตั้งค่าสถานะเพื่อแสดงข้อความแสดงข้อผิดพลาด
    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    //ตั้งค่าสถานะเพื่อแสดงข้อความแสดงข้อผิดพลาด มุมมองควรใช้สิ่งนี้เพื่อเข้าถึงข้อมูล
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown


    init {
        refreshDataFromRepository()
    }

    //เรียกใช้ข้อมูลที่เก็บไว้ หากมีอะไรผิดจะ catch และแสดงแบบ toast
    private fun refreshDataFromRepository() {
        viewModelScope.launch {
            try {
                videosRepository.refreshVideos()
                _eventNetworkError.value = false
                _isNetworkErrorShown.value = false

                //เมื่อ networkerror true คือไม่มีข้อมูล
            } catch (networkError: IOException) {
                if(playlist.value.isNullOrEmpty())
                    _eventNetworkError.value = true
            }
        }
    }

    //ถ้า NetworkErrorShown รีเซ็ตค่าสถานะข้อผิดพลาดของเครือข่าย
    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }

    //ทำ view model ของ DevByteViewModel
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DevByteViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DevByteViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
