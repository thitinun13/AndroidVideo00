package com.example.android.devbyteviewer.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.devbyteviewer.domain.DevByteVideo

//โดยไฟนี้จะทำหน้าที่อ่านและเขียนไฟจาก database

//ข้อมูลที่ได้รับมามีอะไรบ้าง
@Entity
data class DatabaseVideo constructor(
        @PrimaryKey
        val url: String,
        val updated: String,
        val title: String,
        val description: String,
        val thumbnail: String)


//แมปฐานข้อมูลวิดีโอไปยังเอนทิตีโดเมน

fun List<DatabaseVideo>.asDomainModel(): List<DevByteVideo> {
    return map {
        DevByteVideo(
                url = it.url,
                title = it.title,
                description = it.description,
                updated = it.updated,
                thumbnail = it.thumbnail)
    }
}
