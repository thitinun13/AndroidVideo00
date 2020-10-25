package com.example.android.devbyteviewer.domain

import com.example.android.devbyteviewer.util.smartTruncate

//Model เป็น Class ที่แสดงถึงข้อมูลที่จะนำไปแสดงในหน้าจอของ app


 //ประกาศแสดงข้อมูลวีดีโอที่จะทำไปใช้เล่น

data class DevByteVideo(val title: String,
                        val description: String,
                        val url: String,
                        val updated: String,
                        val thumbnail: String) {


    //ตั้งให้แสดงคำอธิบายไม่เกิน 200 ตัวอักษร
    val shortDescription: String
        get() = description.smartTruncate(200)
}